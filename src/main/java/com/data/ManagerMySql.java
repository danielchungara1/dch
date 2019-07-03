package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerMySql {

    // Librería de MySQL
    public static String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public static String database = "dch_db";

    // Host
    public static String hostname = "localhost";

    // Puerto
    public static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false"+"&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    // Nombre de usuario
    public static String username = "root";

    // Clave de usuario
    public static String password = "terricola";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    
    public static ResultSet executeQuery(String query) throws SQLException {
		Connection connection = ManagerMySql.getConnection();
		PreparedStatement sentenciaSql = connection.prepareStatement(query);
		return sentenciaSql.executeQuery();
		
	}

}