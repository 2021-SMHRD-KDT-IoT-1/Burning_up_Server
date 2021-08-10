package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class F_AgnDAO {
	
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
	public int Gyrosensor(int gyro) {

		conn();

		try {

			String sql = "update FRXT_AGN set AGN_VALUE = ? where AGN_NUM=1" ;
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, gyro);
			
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	public String showGyro(String agn) {
		String value ="1";
		conn();

		try {
			String sql = "select * from FRXT_AGN where AGN_VALUE = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, agn);

			rs = psmt.executeQuery();

			if (rs.next()) {
				value = rs.getString(3);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return value;
	}
	
}
