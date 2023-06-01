package org.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Statement statement =DatabasePostgres.getInstance().getPostgresConnection().createStatement();
        statement.executeUpdate("CREATE TABLE test_table(id int PRIMARY KEY, name CHARACTER)");
    }
}
