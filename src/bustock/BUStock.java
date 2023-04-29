/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bustock;

import bustock.manager.StockManager;
import bustock.manager.LogManager;

/**
 *
 * @author bz199
 */
public class BUStock 
{
    public static void main(String[] args)
    {
        // Load Data in Database
        StockManager.LoadStock();
        StockManager.LoadCategory();
        LogManager.LoadCategories();
        LogManager.LoadItems();
        LogManager.LoadOldItems();
        java.awt.EventQueue.invokeLater(() -> 
        {
            new LoginPage().setVisible(true);
        });
    }
}
