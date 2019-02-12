package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	// MySQL ver.6 이상에서는 DRIVER = "com.mysql.cj.jdbc.Driver"
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/bbs?useSSL=false";
	// MySQL ver.6 이상에서는 "jdbc:mysql://127.0.0.1:3306/bbs?useSSL=false&serverTimezone=Asia/Seoul"
	
	private static final String USER = "Yuriel";
	
	private static final String PW = "Sapph1r3";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
