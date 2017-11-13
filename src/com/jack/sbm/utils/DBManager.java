package com.jack.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static Connection con;
	private static final String DRIVAERNAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL="jdbc:sqlserver://localhost:1433;databaseName=db_sbm";
	private static final String USERNAME="sa";
	private static final String PASSWORD="123456";
public static Connection getConnection(){
	try {
		Class.forName(DRIVAERNAME);
		con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}
public static void close(Statement statement,Connection connection){
	try {
		statement.close();
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
