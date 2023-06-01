package org.example.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getConnectionURL(){
        try(InputStream inputStream=PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop=new Properties();
            if(inputStream==null){
                System.out.println("Unable to find application properties!");
                return null;
            }
            prop.load(inputStream);
            return new StringBuilder("jdbc:")
                    .append(prop.getProperty("h2.db.host"))
                    .append(":./")
                    .append(prop.getProperty("h2.db.database"))
                    .toString();
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static String getConnectionURLforPostrgres(){
        try(InputStream inputStream=PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop=new Properties();
            if(inputStream==null){
                System.out.println("Unable to find application properties!");
                return null;
            }
            prop.load(inputStream);
            return new StringBuilder("jdbc:postgresql://")
                    .append(prop.getProperty("postgres.db.host"))
                    .append(":")
                    .append(prop.getProperty("postgres.db.port"))
                    .append("/")
                    .append(prop.getProperty("postgres.db.database"))
                    .toString();
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static String getUserForPostgres(){
        try(InputStream inputStream=PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop=new Properties();
            if(inputStream==null){
                System.out.println("Unable to find application properties!");
                return null;
            }
            prop.load(inputStream);
            return  prop.getProperty("postgres.db.username");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static String getPasswordForPostgres(){
        try(InputStream inputStream=PropertyReader.class.getClassLoader()
                .getResourceAsStream("application.properties")){
            Properties prop=new Properties();
            if(inputStream==null){
                System.out.println("Unable to find application properties!");
                return null;
            }
            prop.load(inputStream);
            return  prop.getProperty("postgres.db.password");
        } catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
