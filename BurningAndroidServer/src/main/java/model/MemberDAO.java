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

	//회원가입
	public int join(MemberDTO member) {

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

	//로그인
	public MemberDTO login(MemberDTO logdto) {

		conn();

		try {
			String sql = "select * from fire_user where id=? and pw=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, logdto.getId());
			psmt.setString(2, logdto.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				String addr = rs.getString(5);
				String b_name = rs.getString(6);
				String gen = rs.getString(7);
				String bir = rs.getString(8);
				int code = rs.getInt(9);

				dto = new MemberDTO(id, pw, name, tel, addr, b_name, gen, bir, code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
		

		}
}
