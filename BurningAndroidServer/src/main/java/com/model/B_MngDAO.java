package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class B_MngDAO {
	
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
	
	//피난안내도 등록
		public int Bupload(B_MngDTO dto) {
			conn();
			
			try {
				String sql = "insert into BLD_MNG values(?, ?)";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, dto.getBld_flr());
				psmt.setString(2, dto.getBld_dwg());
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return cnt;
		}
		
		//피난안내도 목록 보기
		public ArrayList<B_MngDTO> BshowBoard() {
			ArrayList<B_MngDTO> list = new ArrayList<B_MngDTO>();
			
			conn();
			
			try {
				String sql = "select * from BLD_MNG order by bld_flr";
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String bld_flr = rs.getString("bld_flr");
					String bld_dwg = rs.getString("bld_dwg");
					
					B_MngDTO dto = new B_MngDTO(bld_flr, bld_dwg);
					list.add(dto);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return list;
		}
		
		//피난안내도 보기
		public B_MngDTO BshowOne(String choice) {
			
			B_MngDTO dto = null;
			
			conn();
			
			try {
				String sql = "select *from BLD_MNG where bld_flr = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, choice);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String bld_flr = rs.getString("bld_flr");
					String bld_dwg = rs.getString("bld_dwg");
					
					dto = new B_MngDTO(bld_flr, bld_dwg);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return dto;
		}
}
