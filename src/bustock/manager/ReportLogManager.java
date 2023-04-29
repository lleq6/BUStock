/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.manager;

import bustock.model.ItemLog;
import bustock.model.CategoryReport;
import bustock.model.CategoryLog;
import bustock.model.ItemReport;
import java.util.*;

/**
 *
 * @author bz199
 */
public class ReportLogManager 
{
    private static int GetIndexByState(String State)
    {
        return State.contains("ADD") ? 1 : State.equals("UPDATE") ? 2 : State.equals("DELETE") ? 3 : 0;
    }
    
    public static ItemReport GetItemReport(String Date)
    {
        var Month = Date.split("-")[0];
        var Year = Date.split("-")[1];
        var Items = new ArrayList<ItemLog>();
        int[] Counter = { 0, 0, 0, 0 };
        for (var Item : LogManager.getItems().stream().filter(x -> x.getDate().split("-")[1].equals(Month) && x.getDate().split("-")[2].split(" ")[0].equals(Year)).toList())
        {
            if (Item != null)
            {
                var Index = GetIndexByState(Item.getState());
                Counter[Index] += 1;
                Counter[0] += 1;
                Items.add(Item);
            }
        }
        return new ItemReport(Items, Counter);
    }
    
    public static CategoryReport GetCategoryReport(String Date)
    {
        var Month = Date.split("-")[0];
        var Year = Date.split("-")[1];
        var Categories = new ArrayList<CategoryLog>();
        int[] Counter = { 0, 0, 0, 0 };
        for (var Category : LogManager.getCategories().stream().filter(x -> x.getDate().split("-")[1].equals(Month) && x.getDate().split("-")[2].split(" ")[0].equals(Year)).toList())
        {
            if (Category != null)
            {
                var Index = GetIndexByState(Category.getState());
                Counter[Index] += 1;
                Counter[0] += 1;
                Categories.add(Category);
            }
        }
        return new CategoryReport(Categories, Counter);
    }
}
