/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistem_Kasir;
import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;
public class connection {
    public connection(){}
    public static Connection con;
    public static final String url = "jdbc:ucanaccess://";
    public static final String path = "C:/"+"tb.accdb";
    String user;
    
    public void makeConnection(){
        System.out.println("Opening database...");
        try{
            con = DriverManager.getConnection(url+path);
            System.out.println("Success !\n");
        }
        catch(Exception Ex){
            System.out.println("Error Opening the database...\n");
            System.out.println(Ex);
        }
    }
    
    public void closeConnection(){
        System.out.println("Closing database...");
        try{
            con.close();
            System.out.println("Success !\n");
        }
        catch(Exception Ex){
            System.out.println("Error Closing the database...\n");
            System.out.println(Ex);
        }
    }
    
    public void loginUser(String _username, String _password)
    {
        String sql="SELECT Username,Password FROM data Where Username = ? and Password =? ";
        int b=0;
        System.out.println("Login...");
        try{
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, _username);
            statement.setString(2, _password);
            ResultSet result=statement.executeQuery();
            while(result.next())
            {
                System.out.println(result.getString("Username"));
                System.out.println(result.getString("Password"));
                b=1;
            }
            int tampung = b;
            if(b==1)
            {
                JOptionPane.showMessageDialog(null, "Login Berhasil");
                Sistem_Kasir yp = new Sistem_Kasir(_username);
                yp.show();
                
                
            }
            else JOptionPane.showMessageDialog(null, "Login gagal, username dan password salah");
            statement.close();
        }
        catch(Exception Ex){
            System.out.println("your data it doesnt matching...\n");
            System.out.println(Ex);
        }
    }
   public ResultSet loginUserr(String _username, String _password)
    {
        String sql = "SELECT Username,Password FROM data Where Username = ? and Password =? ";
        ResultSet rs;
        System.out.println("Getting data...");
        try{
            PreparedStatement state = con.prepareStatement(sql);
            System.out.println(_username);
            state.setString(1, _username);
            state.setString(2, _password);
            rs = state.executeQuery();
        }
        catch(Exception e){
            rs = null;
            System.out.println("Error...");
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return rs;
    }
   
    public ResultSet getData(String user){
        String sql = "SELECT * from data where username = ?";
        ResultSet rs;
        System.out.println("Getting data...");
        try{
            PreparedStatement state = con.prepareStatement(sql);
            System.out.println(user);
            state.setString(1, user);
            rs = state.executeQuery();
        }
        catch(Exception e){
            rs = null;
            System.out.println("Error...");
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return rs;
    }
    
}
