package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	UserDTO dto = null;
	ArrayList<UserDTO> list = null;

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

	// 회원가입

	public int Join(UserDTO dto) {

		conn();

		try {

			String sql = "insert into fire_user values(?,?,?,?,?,?,?,?,?)";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getTel());
			psmt.setString(5, dto.getAddr());
			psmt.setString(6, dto.getB_name());
			psmt.setString(7, dto.getGen());
			psmt.setString(8, dto.getBir());
			psmt.setInt(9, dto.getCode());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// 로그인
	public UserDTO login(UserDTO InDto) {

		conn();

		try {
			String sql = "select * from fire_user where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, InDto.getId());
			psmt.setString(2, InDto.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
				String b_name = rs.getString(6);

				dto = new UserDTO(id, pw, name, tel, addr, b_name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	// 회원 정보 수정
	public int update(UserDTO dto) {

		conn();

		try {
			String sql = "update fire_user set pw =?, name =?, tel =? where id =?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getTel());
			psmt.setString(4, dto.getId());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	//관리자 정보 조회
	public ArrayList<UserDTO> oneselect(String userid) {

		list = new ArrayList<UserDTO>();

		conn();

		try {
			String sql = "select * from fire_user where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);

			rs = psmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
				String b_name = rs.getString(6);

				dto = new UserDTO(id, pw, name, tel, addr, b_name);
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	//회원 탈퇴
	public int delete(UserDTO dto) {

		conn();

		try {
			String sql = "delete from fire_user where id =? and pw =?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
