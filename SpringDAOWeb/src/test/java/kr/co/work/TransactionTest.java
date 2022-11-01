package kr.co.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TransactionTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void tarnsactionTest() throws SQLException {
		Connection conn = null;
		
		deleteAll();
		conn = ds.getConnection();
		conn.setAutoCommit(false);
		
		String sql = "INSERT INTO t_user values(?, ?, ?, ?, ?, ?, now())";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
	
	}

	private void deleteAll() throws SQLException {
			Connection conn = ds.getConnection();
			String sql = "delete from t_user";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		}
		
	}


