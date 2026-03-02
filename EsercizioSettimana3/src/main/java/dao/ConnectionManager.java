package dao;

import config.DatabaseInitializer;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DatabaseInitializer.getInstance().getConn();
    }

}
