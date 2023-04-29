/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

/**
 *
 * @author bz199
 */
public class ItemStock 
{
    private String SKU;
    private String Name;
    private String Category;
    private int Qty;
    private double Price;
    
    public ItemStock(String SKU, String Name, String Category, int Qty, double Price)
    {
        this.SKU = SKU;
        this.Name = Name;
        this.Category = Category;
        this.Qty = Qty;
        this.Price = Price;
    }

    public void setSKU(String SKU) 
    {
        this.SKU = SKU;
    }

    public void setName(String Name) 
    {
        this.Name = Name;
    }

    public void setCategory(String Category) 
    {
        this.Category = Category;
    }

    public void setQty(int Qty) 
    {
        this.Qty = Qty;
    }

    public void setPrice(double Price) 
    {
        this.Price = Price;
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
