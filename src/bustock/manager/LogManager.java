/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.manager;

import bustock.model.ItemLog;
import bustock.model.OldItem;
import bustock.model.CategoryLog;
import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author User
 */
public class LogManager
{
    private static List<ItemLog> Items = new ArrayList<>();
    private static List<OldItem> OldItems = new ArrayList<>();
    private static List<CategoryLog> Categories = new ArrayList<>();
    
    public static boolean SaveItem(ItemLog Item)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("INSERT INTO Item_Log (LogID, Date, Username, SKU, Name, Category, Qty, Price, State) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, Item.getLogID());
            ps.setString(2, Item.getDate());
            ps.setString(3, Item.getUsername());
            ps.setString(4, Item.getSKU());
            ps.setString(5, Item.getName());
            ps.setString(6, Item.getCategory());
            ps.setInt(7, Item.getQty());
            ps.setDouble(8, Item.getPrice());
            ps.setString(9, Item.getState());
            ps.executeUpdate();
            Items.add(Item);
            return true;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void SaveOldItem(String LogID, String SKU, String Name, String Category, int Qty, double Price)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var Item = new OldItem(LogID, SKU, Name, Category, Qty, Price);
            var ps = Connection.prepareStatement("INSERT INTO Old_Item_Log (LogID, SKU, Name, Category, Qty, Price) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, Item.getLogID());
            ps.setString(2, Item.getSKU());
            ps.setString(3, Item.getName());
            ps.setString(4, Item.getCategory());
            ps.setInt(5, Item.getQty());
            ps.setDouble(6, Item.getPrice());
            ps.executeUpdate();
            OldItems.add(Item);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void SaveCategory(CategoryLog Category)
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("INSERT INTO Categories_Log (Username, Date, Old_Name, New_Name, State) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, Category.getUsername());
            ps.setString(2, Category.getDate());
            ps.setString(3, Category.getOldName());
            ps.setString(4, Category.getNewName());
            ps.setString(5, Category.getState());
            ps.executeUpdate();
            Categories.add(Category);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LoadCategories()
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("SELECT * FROM Categories_Log");
            var rs = ps.executeQuery();
            while (rs.next())
            {
                var Category = new CategoryLog();
                Category.setUsername(rs.getString(1));
                Category.setDate(rs.getString(2));
                Category.setOldName(rs.getString(3));
                Category.setNewName(rs.getString(4));
                Category.setState(rs.getString(5));
                Categories.add(Category);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void LoadItems()
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("SELECT * FROM Item_Log");
            var rs = ps.executeQuery();
            while (rs.next())
            {
                var Item = new ItemLog();
                Item.setLogID(rs.getString(1));
                Item.setDate(rs.getString(2));
                Item.setUsername(rs.getString(3));
                Item.setSKU(rs.getString(4));
                Item.setName(rs.getString(5));
                Item.setCategory(rs.getString(6));
                Item.setQty(rs.getInt(7));
                Item.setPrice(rs.getDouble(8));
                Item.setState(rs.getString(9));
                Items.add(Item);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void LoadOldItems()
    {
        try (var Connection = DriverManager.getConnection(SQLManager.URL))
        {
            var ps = Connection.prepareStatement("SELECT * FROM Old_Item_Log");
            var rs = ps.executeQuery();
            while (rs.next())
            {
                OldItems.add(new OldItem(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6)));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static OldItem getOldLogDetail(String LogID)
    {
        if (LogID.isEmpty())
        {
            return null;
        }
        return OldItems.stream().filter(x -> x.getLogID().equals(LogID)).findFirst().orElse(null);
    }

    public static ItemLog getLogDetail(String LogID)
    {
        if (LogID.isEmpty())
        {
            return null;
        }
        return Items.stream().filter(x -> x.getLogID().equals(LogID)).findFirst().orElse(null);
    }

    public static String getCurDateTime()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(myFormatObj);
        return formattedDate;
    }
    public static String getCurDateTime(String State)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String formattedDate = now.format(myFormatObj);
        return State + formattedDate;
    }

    public static List<ItemLog> getItems() 
    {
        return Items;
    }

    public static List<OldItem> getOldItems() 
    {
        return OldItems;
    }

    public static List<CategoryLog> getCategories() 
    {
        return Categories;
    }
}
