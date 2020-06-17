/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistem_Kasir;

/**
 *
 * @author meyld
 */
public class control {
    private connection d = new connection();
    public control(){}
    public void loginn(String _username, String _password)
    {
        d.makeConnection();
        d.loginUser(_username,_password);
        d.closeConnection();

    }
}
