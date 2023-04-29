/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

/**
 *
 * @author User
 */
public class OldItem 
{
    private String LogID;
    private String SKU;
    private String Name;
    private String Category;
    private int Qty;
    private double Price;
    
    public OldItem(String LogID, String SKU, String Name, String Category, int Qty, double Price)
    {
        this.LogID = LogID;
        this.SKU = SKU;
        this.Name = Name;
        this.Category = Category;
        this.Qty = Qty;
        this.Price = Price;
    }
    
    public String getLogID() 
    {
        return LogID;
    }

    public String getSKU() 
    {
        return SKU;
    }

    public String getName() 
    {
        return Name;
    }

    public String getCategory() 
    {
        return Category;
    }

    public int getQty() 
    {
        return Qty;
    }

    public double getPrice() 
    {
        return Price;
    }
}
