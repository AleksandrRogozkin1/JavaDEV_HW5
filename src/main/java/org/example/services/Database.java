package org.example.services;
import org.example.props.PropertyReader;

import java.sql.*;
public class Database {
//    ffff
    private static Database instance;
   private Connection connection;


    private Database(){
        try {
            String connectionURL = PropertyReader.getConnectionURL();
            this.connection=DriverManager.getConnection(connectionURL);
        }catch (SQLException ex){
            throw new RuntimeException("Connection exception!") ;
        }
    }
   public static Database getInstance(){
       if (instance == null) {
           instance = new Database();
       }
       return instance;
   }
   public Connection getConnection(){
       return connection;
   }
   public int executeUpdate(String query){
        try (Statement statement=instance.getConnection().createStatement()){
            return statement.executeUpdate(query);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
   }
   public void closeConnection(){
       try {
           connection.close();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

}
