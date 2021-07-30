package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	int cnt = 0;
	ResultSet rs = null;
	MemberDTO dto = null;

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

	// 관리자 회원가입
	public int MngJoin(MemberDTO member) {

		conn();

		try {

			String sql = "insert into fire_user values(?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPw());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getTel());
			psmt.setString(5, member.getAddr());
			psmt.setString(6, member.getB_name());
			psmt.setString(7, member.getGen());
			psmt.setString(8, member.getBir());
			psmt.setInt(9, member.getCode());
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// 사용자 회원가입
	public int UserJoin(MemberDTO usermember) {

		try {

			String sql = "insert into fire_user values(?,?,?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, usermember.getId());
			psmt.setString(2, usermember.getPw());
			psmt.setString(3, usermember.getName());
			psmt.setString(4, usermember.getTel());
			psmt.setString(5, usermember.getAddr());
			psmt.setString(6, usermember.getB_name());
			psmt.setString(7, usermember.getGen());
			psmt.setString(8, usermember.getBir());
			psmt.setInt(9, usermember.getCode());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	// 로그인
	public int login(String id, String pw) {

		int code = 0;

		conn();

		try {
			String sql = "select code from fire_user where id=? and pw=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				code = rs.getInt("CODE");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return code;
	}
	
	//관리자 정보 수정
	public int UserUpdate(MemberDTO UpdateDto) {
		
		conn();
		
		try {
			
			String sql = "update fire_user set pw = ?, name = ?, tel = ? where id = ?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, UpdateDto.getPw());
			psmt.setString(2, UpdateDto.getName());
			psmt.setString(3, UpdateDto.getTel());
			psmt.setString(4, UpdateDto.getId());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
}
