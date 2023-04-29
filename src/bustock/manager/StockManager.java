/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.manager;

import bustock.model.Category;
import bustock.model.ItemStock;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class StockManager 
{
    private static List<ItemStock> Items = new ArrayList<>();
    private static List<Category> Categories = new ArrayList<>();
    
    public static void LoadStock()
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var Statement = Connection.createStatement();
            var rs = Statement.executeQuery("SELECT * FROM Stock");
            while (rs.next())
            {
                Items.add(new ItemStock(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean AddItem(ItemStock Item)
    {
        if (Item == null)
        {
            return false;
        }
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("INSERT INTO Stock (SKU, Name, Category, Qty, Price) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, Item.getSKU());
            ps.setString(2, Item.getName());
            ps.setString(3, Item.getCategory());
            ps.setInt(4, Item.getQty());
            ps.setDouble(5, Item.getPrice());
            ps.executeUpdate();
            Items.add(Item);
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 19)
            {
                JOptionPane.showMessageDialog(null, "SKU should be unique\nPlease try another SKU", "Add item fail" ,JOptionPane.ERROR_MESSAGE);
            }
            return false;    
        }
    }
    
    public static void UpdateItem(ItemStock Item, String OGsku)
    {
        if (Item == null || OGsku == null || OGsku.isEmpty())
        {
            return;
        }
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("UPDATE Stock SET SKU=?, Name=?, Category=?, Qty=?, Price=? WHERE SKU=?");
            ps.setString(1, Item.getSKU());
            ps.setString(2, Item.getName());
            ps.setString(3, Item.getCategory());
            ps.setInt(4, Item.getQty());
            ps.setDouble(5, Item.getPrice());
            ps.setString(6, OGsku);
            ps.executeUpdate();
            UpdateItemCache(Item, OGsku);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 19)
            {
                JOptionPane.showMessageDialog(null, "Update fail", "Update item fail" , JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static void UpdateItemCache(ItemStock Stock, String SKU)
    {
        if (Stock == null)
        {
            return;
        }
        var Item = GetItemBySKU(SKU);
        if (Item != null)
        {
            Item.setSKU(Stock.getSKU());
            Item.setName(Stock.getName());
            Item.setCategory(Stock.getCategory());
            Item.setQty(Stock.getQty());
            Item.setPrice(Stock.getPrice());
        }
    }
    
    public static void DeleteItemBySKU(String OGsku)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("DELETE FROM Stock WHERE SKU=?");
            ps.setString(1, OGsku);
            ps.executeUpdate();
            var Item = GetItemBySKU(OGsku);
            if (Item != null)
            {
                Items.remove(Item);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 19)
            {
                JOptionPane.showMessageDialog(null, "Delete fail", "Delete item fail" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void DeleteItemByCategory(String Category)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("DELETE FROM Stock WHERE Category=?");
            ps.setString(1, Category);
            ps.executeUpdate();
            var Lists = GetItemsByCategory(Category);
            if (Lists != null && !Lists.isEmpty())
            {
                Items.removeAll(Lists);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            if (ex.getErrorCode() == 19)
            {
                JOptionPane.showMessageDialog(null, "Delete fail", "Delete item fail" ,JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void LoadCategory()
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var Statement = Connection.createStatement();
            var rs = Statement.executeQuery("SELECT Name FROM Categories");
            while(rs.next())
            {
                var Category = new Category();
                Category.SetName(rs.getString("Name"));
                Categories.add(Category);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean AddCategory(String categoryName)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("INSERT INTO Categories (Name) VALUES (?)");
            ps.setString(1, categoryName);
            ps.executeUpdate();
            var Category = new Category();
            Category.SetName(categoryName);
            Categories.add(Category);
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean UpdateCategory(String categoryName, String newCategoryName)
    {
        if (categoryName.isEmpty() || newCategoryName.isEmpty())
        {
            return false;
        }
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("UPDATE Categories SET Name=? WHERE Name=?");
            ps.setString(1, newCategoryName);
            ps.setString(2, categoryName);
            ps.executeUpdate();
            UpdateCategoryCache(categoryName, newCategoryName);
            UpdateItemAllByName(categoryName, newCategoryName);
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private static void UpdateCategoryCache(String categoryName, String newCategoryName)
    {
        if (categoryName.isEmpty() || newCategoryName.isEmpty())
        {
            return;
        }
        var Category = GetCategoryByName(categoryName);
        if (Category != null)
        {
            Category.SetName(newCategoryName);
        }
    }
    
    private static void UpdateItemAllByName(String categoryName, String newCategoryName)
    {
        if (categoryName.isEmpty() || newCategoryName.isEmpty())
        {
            return;
        }
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("UPDATE Stock SET Category=? WHERE Category=?;");
            ps.setString(1, newCategoryName);
            ps.setString(2, categoryName);
            ps.executeUpdate();
            UpdateItemByCategory(categoryName, newCategoryName);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void UpdateItemByCategory(String categoryName, String newCategoryName)
    {
        if (categoryName.isEmpty() || newCategoryName.isEmpty())
        {
            return;
        }
        var List = GetItemsByCategory(categoryName);
        if (List != null && !List.isEmpty())
        {
            for (var Item : List)
            {
                Item.setCategory(newCategoryName);   
            }
        }
    }
    
    public static boolean DeleteCategory(String categoryName)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("DELETE FROM Categories WHERE Name=?");
            ps.setString(1,categoryName);
            ps.executeUpdate();
            var Category = GetCategoryByName(categoryName);
            if (Category != null)
            {
                Categories.remove(Category);
                DeleteItemByCategory(categoryName);
            }
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static ItemStock GetItemBySKU(String SKU)
    {
        return Items.stream().filter(x -> x.getSKU().equals(SKU)).findFirst().orElse(null);
    }
    
    public static ItemStock GetItemByCategory(String Category)
    {
        return Items.stream().filter(x -> x.getCategory().equals(Category)).findFirst().orElse(null);
    }
    
    public static Category GetCategoryByName(String Name)
    {
        return Categories.stream().filter(x -> x.GetName().equals(Name)).findFirst().orElse(null);
    }
    
    public static List<ItemStock> GetItems()
    {
        return Items;
    }
    
    public static List<ItemStock> GetItemsByName(String Name)
    {
        return Items.stream().filter(x -> x.getName().contains(Name)).toList();
    }
    
    public static List<ItemStock> GetItemsByCategory(String Category)
    {
        return Items.stream().filter(x -> x.getCategory().contains(Category)).toList();
    }
    
    public static List<ItemStock> GetItemsBySelectedItem(int Index, String Filter)
    {
        return Items.stream().filter(x -> (
                Index == 0 ? x.getSKU().contains(Filter) : 
                Index == 1 ? x.getName().contains(Filter) : 
                Index == 3 ? x.getQty() == Integer.parseInt(Filter) :
                x.getPrice() == Double.parseDouble(Filter))).toList();
    }
    
    public static List<Category> GetCategories()
    {
        return Categories;
    }
    
    public static void ClearStocks()
    {
        Items.clear();
    }
}
