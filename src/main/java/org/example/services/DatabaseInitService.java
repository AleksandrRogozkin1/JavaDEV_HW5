package org.example.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(ReaderFileSQL.readSQLFile("sql/init_db.sql"));
//            System.out.println(ReaderFileSQL.readSQLFile("sql/init_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
