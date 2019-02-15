package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try(Connection con = DriverManager.getConnection(
					"jdbc:log4jdbc:mysql://127.0.0.1:3306/spring?useSSL=false&amp;serverTimezone=UTC",
					"Yuriel",
					"Sapph1r3"
				)) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
