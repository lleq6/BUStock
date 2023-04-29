/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.manager;

import bustock.model.Account;
import java.util.logging.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author bz199
 */
public class SQLManager 
{
    public static final String URL = "jdbc:sqlite:DATABASE.db";
    
    public static Account userLogin(String username, String password)
    {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
        {
            return null;
        }
        try (var Connection = DriverManager.getConnection(URL))
        {
            var ps = Connection.prepareStatement("SELECT * FROM User WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            var rs = ps.executeQuery();
            if (rs.next())
            {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            return null;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void userRegister(String username, String password, String email)
    {
        try (var Connection = DriverManager.getConnection(URL))
        {
            var ps = Connection.prepareStatement("INSERT INTO User (Username, Password, Email) VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Register complete!", "Register", JOptionPane.WARNING_MESSAGE);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean usernameExist(String username)
    {
        if (username == null || username.isEmpty())
        {
            return false;
        }
        try (var Connection = DriverManager.getConnection(URL))
        {
            var ps = Connection.prepareStatement("SELECT COUNT(*) FROM User WHERE username = ?");
            ps.setString(1, username);
            var rs = ps.executeQuery();
            if (rs.next())
            {
                return rs.getInt(1) > 0;
            }
            return false;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean emailExist(String email)
    {
        if (email == null || email.isEmpty())
        {
            return false;
        }
        try (var Connection = DriverManager.getConnection(URL))
        {
            var ps = Connection.prepareStatement("SELECT COUNT(*) FROM User WHERE Email = ?");
            ps.setString(1, email);
            var rs = ps.executeQuery();
            if (rs.next())
            {
                return rs.getInt(1) > 0;
            }
            return false;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(SQLManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}