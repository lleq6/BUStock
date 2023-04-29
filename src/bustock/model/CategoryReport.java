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
public class CategoryReport 
{
    private List<CategoryLog> Items;
    private int[] TotalArray;
        
    public CategoryReport(List<CategoryLog> Items, int[] TotalArray) 
    {
        this.Items = Items;
        this.TotalArray = TotalArray;
    }
        
    public List<CategoryLog> getItems() 
    {
        return Items;
    }

    public int[] getTotalArray() 
    {
        return TotalArray;
    }
}
