package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class F_InfoDAO {

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
	
	//소화기 목록 보기
		public ArrayList<F_InfoDTO> FinfoShow() {
			ArrayList<F_InfoDTO> Flist = new ArrayList<F_InfoDTO>();
			
			conn();
			
			try {
				String sql = "select * from FRXT_INFO order by f_nick";
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String f_nick = rs.getString("f_nick");
					String nfc_num = rs.getString("nfc_num");
					String nfc_pro = rs.getString("nfc_pro");
					String use_dt = rs.getString("use_dt");
					String nfc_regi = rs.getString("nfc_regi");
					String bld_flr = rs.getString("bld_flr");
					
					F_InfoDTO dto = new F_InfoDTO(f_nick, nfc_num, nfc_pro, use_dt, nfc_regi, bld_flr);
					Flist.add(dto);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return Flist;
		}
		
		//소화기 점검사항 보기
		public F_InfoDTO FinfoShowOne(String choice) {
			F_InfoDTO dto = null;
			conn();
			
			try {
				String sql = "select *from FRXT_INFO where f_nick = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, choice);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String f_nick = rs.getString("f_nick");
					String nfc_num = rs.getString("nfc_num");
					String nfc_pro = rs.getString("nfc_pro");
					String use_dt = rs.getString("use_dt");
					String nfc_regi = rs.getString("nfc_regi");
					String bld_flr = rs.getString("bld_flr");
					
					dto = new F_InfoDTO(f_nick, f_nick, nfc_pro, use_dt, nfc_regi, bld_flr);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return dto;
			
		}
	
}
