package com.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDB {
	
	public static void main(String[] args) {
		
		String url =
				"jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connection successful");
		conn.close();
		
		}
		catch (SQLException sqlExc) {
			sqlExc.printStackTrace();
		}
		
		
		
		
	}

}
