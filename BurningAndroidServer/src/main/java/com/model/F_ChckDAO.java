package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class F_ChckDAO {

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

	// 점검기록 보기
	public ArrayList<F_ChckDTO> FcinfoShow() {
		ArrayList<F_ChckDTO> Fclist = new ArrayList<F_ChckDTO>();

		conn();

		try {
			String sql = "select * from FRXT_CHCK order by CHCK_NUM";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int chck_num = rs.getInt("chck_num");
				String f_nick = rs.getString("f_nick");
				String nfc_num = rs.getString("nfc_num");
				String bld_flr = rs.getString("bld_flr");
				String chck_pwd = rs.getString("chck_pwd");
				String chck_press = rs.getString("chck_press");
				String chck_pin = rs.getString("chck_pin");
				String chck_body = rs.getString("chck_body");
				String chck_lever = rs.getString("chck_lever");
				String chck_hose = rs.getString("chck_hose");
				String chck_date = rs.getString("chck_date");

				F_ChckDTO dto = new F_ChckDTO(chck_num, f_nick, nfc_num, bld_flr, chck_pwd, chck_press, chck_pin,
						chck_body, chck_lever, chck_hose, chck_date);
				Fclist.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return Fclist;
	}

	// 점검사항 보기
	public F_ChckDTO FcinfoShowOne(String choice) {
		F_ChckDTO dto = null;
		conn();

		try {
			String sql = "select * from FRXT_CHCK where chck_date = ?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, choice);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int chck_num = rs.getInt("chck_num");
				String f_nick = rs.getString("f_nick");
				String nfc_num = rs.getString("nfc_num");
				String bld_flr = rs.getString("bld_flr");
				String chck_pwd = rs.getString("chck_pwd");
				String chck_press = rs.getString("chck_press");
				String chck_pin = rs.getString("chck_pin");
				String chck_body = rs.getString("chck_body");
				String chck_lever = rs.getString("chck_lever");
				String chck_hose = rs.getString("chck_hose");
				String chck_date = rs.getString("chck_date");

				dto = new F_ChckDTO(chck_num, f_nick, nfc_num, bld_flr, chck_pwd, chck_press, chck_pin,
						chck_body, chck_lever, chck_hose, chck_date);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;

	}

}
