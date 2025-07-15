package com.data.session_04.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/library_db?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "123456";

    // Mở kết nối
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }catch (ClassCastException e){
            System.err.println("Driver not found"+ e.getMessage());
        }catch (SQLException e){
            System.err.println("Connection not found"+ e.getMessage());
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    // Đóng kết nối
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e){
                System.err.println("Failed to close connection"+ e.getMessage());
            }
        }
    }
}
