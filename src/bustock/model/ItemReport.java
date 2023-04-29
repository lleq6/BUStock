/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

import java.util.List;

/**
 *
 * @author bz199
 */
public class ItemReport 
{
    private List<ItemLog> Items;
    private int[] Total;

    public ItemReport(List<ItemLog> Items, int[] Total) 
    {
        this.Items = Items;
        this.Total = Total;
    }

    public List<ItemLog> getItems() 
    {
        return Items;
    }

    public int[] getTotal() 
    {
        return Total;
    }
}
