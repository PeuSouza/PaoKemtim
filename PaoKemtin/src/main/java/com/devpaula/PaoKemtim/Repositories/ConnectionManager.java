package com.devpaula.PaoKemtim.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/PaoKemtim";
	private static final String USER = "root";
	// Abaixo colocar a senha do banco de dados.
	private static final String PASSWORD = "root";

	private static Connection conn = null;

	static Connection getCurrentConnection() throws SQLException {

		if (conn == null)
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		return conn;

	}

	static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}