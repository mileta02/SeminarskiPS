/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author milan
 */
public class Konekcija {
    private static Konekcija instance;
    private Connection connection;
    
    private Konekcija(){
        String url = "jdbc:mysql://localhost:3306/ps_projekat";
        String username = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Connection getConnection(){
        return connection;
    }
    
    
    public static Konekcija getInstance(){
        if(instance==null)
            instance = new Konekcija();
        return instance;
    }
}
