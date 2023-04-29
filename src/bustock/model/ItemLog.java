/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

/**
 *
 * @author bz199
 */
public class ItemLog 
{
    private String LogID;
    private String Date;
    private String Username;
    private String SKU;
    private String Name;
    private String Category;
    private int Qty;
    private double Price;
    private String State;

    public void setLogID(String LogID) 
    {
        this.LogID = LogID;
    }

    public void setDate(String Date) 
    {
        this.Date = Date;
    }

    public void setUsername(String Username) 
    {
        this.Username = Username;
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

    public void setState(String State) 
    {
        this.State = State;
    }
    
    public String[] getTableArray()
    {
        String[] data = {
            this.LogID,
            this.Date,
            this.SKU,
            this.Name,
            this.Username,
            this.State
        };
        return data;
    }    

    public String getLogID() 
    {
        return LogID;
    }

    public String getDate() 
    {
        return Date;
    }

    public String getUsername() 
    {
        return Username;
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

    public String getState() 
{
        return State;
    }
}
