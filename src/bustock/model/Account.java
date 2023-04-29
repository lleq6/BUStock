/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

/**
 *
 * @author User
 */
public class Account 
{
    private String Username, Password, Email;
    
    public Account(String Username, String Password, String Email)
    {
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }

    public String GetUsername() 
    {
        return Username;
    }

    public String GetPassword() 
    {
        return Password;
    }
    
    public String GetEmail() 
    {
        return Email;
    }
}
