/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DbConnectionFactory {
    private static DbConnectionFactory instance;
    private Connection connection;
    public DbConnectionFactory() {
       createNewConnection();

    }
    
    private void createNewConnection(){
         try {
            if(connection==null || connection.isClosed()) {
               
            String url= konfiguracija.Konfiguracija.getInstanca().getProperty("url");
                System.out.println(url);
            String user= konfiguracija.Konfiguracija.getInstanca().getProperty("username");
            System.out.println(user);
            String pass= konfiguracija.Konfiguracija.getInstanca().getProperty("password");
            System.out.println(pass);
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat_programiranje_db", "root", "Veljko135");
            connection.setAutoCommit(false);
        }
        } catch (SQLException ex) {
            System.out.println("Neuspesno povezivanje sa bazom, pograsni kredencijali");
        }
    }
    
    public static DbConnectionFactory getInstance(){
        if(instance==null)
            instance=new DbConnectionFactory();
        return instance;
    }

    public Connection getConnection() {
          try {
            if (connection == null || connection.isClosed()) {
                createNewConnection(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    
}
