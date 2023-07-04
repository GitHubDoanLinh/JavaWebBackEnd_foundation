package fa.training.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "3306";
    public static final String DATABASE = "hrdb";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connect failed!");
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement cstm, PreparedStatement pstm, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(pstm != null) {
                pstm.close();
            }
            if(cstm != null) {
                cstm.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
