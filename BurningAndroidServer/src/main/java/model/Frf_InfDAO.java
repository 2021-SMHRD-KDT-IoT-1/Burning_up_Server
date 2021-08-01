package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Frf_InfDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//공지사항 작성
	public int upload(Frf_InfDTO dto) {
		
		conn();
		
		try {
			String sql = "insert into FRF_INF values(FRF_NUM2.nextval, ?, ?, sysdate)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getFrf_tlt());
			psmt.setString(2, dto.getFrf_cnt());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}


}
