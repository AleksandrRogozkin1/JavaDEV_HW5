package org.example.services;

import org.example.props.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePostgres {
    private static DatabasePostgres instance;
    private Connection PostgresConnection;


    private DatabasePostgres(){
        try {
            String postgresURL = PropertyReader.getConnectionURLforPostrgres();
            this.PostgresConnection= DriverManager.getConnection(postgresURL,
                    PropertyReader.getUserForPostgres(),PropertyReader.getPasswordForPostgres());
        }catch (SQLException ex){
            throw new RuntimeException("Connection exception!") ;
        }
    }
    public static DatabasePostgres getInstance(){
        if (instance == null) {
            instance = new DatabasePostgres();
        }
        return instance;
    }
    public Connection getPostgresConnection(){
        return PostgresConnection;
    }
    public int executeUpdate(String query){
        try (Statement statement=instance.getPostgresConnection().createStatement()){
            return statement.executeUpdate(query);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void closeConnection(){
        try {
            PostgresConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
