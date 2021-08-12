package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class F_ClcDAO {

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
	
	//폐기 신청
	public int ClcUpload(F_ClcDTO dto) {
		conn();
		
		try {
			String sql = "insert into FRXT_CLC values(ALR_NUM2.nextval, ?, ?, date, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getNfc_num());
			psmt.setString(3, dto.getClc_dsp());
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
		
	}
	
	//수거신청 목록 보기
	public ArrayList<FrfinfoDTO> showBoard() {
		ArrayList<FrfinfoDTO> list = new ArrayList<FrfinfoDTO>();
		
		conn();
		
		try {
			String sql = "select * from frf_inf order by frf_num desc";
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int frf_num = rs.getInt("frf_num");
				String frf_tlt = rs.getString("frf_tlt");
				String frf_cnt = rs.getString("frf_cnt");
				String frf_file = rs.getString("frf_file");
				String frf_dt = rs.getString("frf_dt");
				
				FrfinfoDTO dto = new FrfinfoDTO(frf_num, frf_tlt, frf_cnt, frf_file, frf_dt);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	//수거신청 글 보기
	public FrfinfoDTO showOne(int choice) {
		FrfinfoDTO dto = null;
		conn();
		
		try {
			String sql = "select *from frf_inf where frf_num = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, choice);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int frf_num = rs.getInt("frf_num");
				String frf_tlt = rs.getString("frf_tlt");
				String frf_cnt = rs.getString("frf_cnt");
				String frf_file = rs.getString("frf_file");
				String frf_dt = rs.getString("frf_dt");
				
				dto = new FrfinfoDTO(frf_num, frf_tlt, frf_cnt, frf_file, frf_dt);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
		
	}
	
}

	

