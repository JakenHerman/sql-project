package javadb;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
        


import java.sql.DriverManager;


public class DBConnection {
    private Connection DBConnection;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success");
            
        }
        catch (ClassNotFoundException cnfe){
            System.out.println("Connection failed" + cnfe);
        }
        
        String url = "jdbc:mysql://localhost:3306/nsa";
        try{
            DBConnection = DriverManager.getConnection(url, "root","piper93");
            
            System.out.println("Database Connected");
        }
        catch(SQLException se){
            System.out.println("No Database" + se);
        }
        return DBConnection;
    }
    
}
