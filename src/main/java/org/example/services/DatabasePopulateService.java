package org.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args){
        Connection connection = Database.getInstance().getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(ReaderFileSQL.readSQLFile("sql/populate_db.sql"));

//            Statement statement = connection.createStatement();
//            statement.execute(ReaderFileSQL.readSQLFile("sql/populate_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
