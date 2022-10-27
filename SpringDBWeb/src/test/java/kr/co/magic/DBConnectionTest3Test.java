package kr.co.magic;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DBConnectionTest3Test {

		@Test
		public void springJdbcConnectiontest() throws SQLException{
			
			ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/root-context.xml");
			DataSource ds = ac.getBean(DataSource.class);
			
			Connection conn =ds.getConnection();
			
			assertTrue(conn!=null);
		}
		
		

}
