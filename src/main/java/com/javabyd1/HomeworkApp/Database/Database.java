package com.javabyd1.HomeworkApp.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection = null;
    private final static String ADRESS = "jdbc:mysql://localhost";
    private final static String DATABASE = "j1b ? useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String PORT = "3306";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    private static void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getFormatedURLAdress(){return ADRESS + ":" + PORT + "/" + DATABASE;}

    private static void loadConnection(){
        try {
            connection = DriverManager.getConnection(getFormatedURLAdress(), USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (connection == null){
            loadDriver();
            loadConnection();
        }
        return connection;
    }
}
