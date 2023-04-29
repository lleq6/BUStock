/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bustock.model;

/**
 *
 * @author bz199
 */
public class CategoryLog 
{
    private String Username;
    private String Date;
    private String OldName;
    private String NewName;
    private String State;

    public void setUsername(String Username) 
    {
        this.Username = Username;
    }

    public void setDate(String Date) 
    {
        this.Date = Date;
    }

    public void setOldName(String OldName) 
    {
        this.OldName = OldName;
    }

    public void setNewName(String NewName) 
    {
        this.NewName = NewName;
    }

    public void setState(String State) 
    {
        this.State = State;
    }
    
    public String[] getArray()
    {
        String[] data = {
        this.Username,
        this.Date,
        this.OldName,
        this.NewName,
        this.State
        };
        return data;
    }

    public String getUsername() 
    {
        return Username;
    }

    public String getDate() 
    {
        return Date;
    }

    public String getOldName() 
    {
        return OldName;
    }

    public String getNewName() 
    {
        return NewName;
    }

    public String getState() 
    {
        return State;
    }
}
