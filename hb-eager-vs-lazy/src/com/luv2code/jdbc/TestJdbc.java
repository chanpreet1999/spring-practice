package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?useSSL=false";
		String username="root";
		String password="root";
		
			System.out.println("Connecting with database:"+jdbcUrl);
			Connection con=DriverManager.getConnection(jdbcUrl,username,password);
			System.out.println("Connection Successful!!!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
