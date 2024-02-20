package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			
			//return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_ryukumite", "root", "robson1977");
			return DriverManager.getConnection("jdbc:mysql://bdryukumite.cv4ugays2km0.us-east-1.rds.amazonaws.com:3307/bd_ryukumite", "admin", "robson1977");
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
