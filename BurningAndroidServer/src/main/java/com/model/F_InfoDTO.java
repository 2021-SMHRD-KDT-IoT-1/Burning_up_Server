package com.model;

public class F_InfoDTO {
	
	private String f_nick;
	private String nfc_num;
	private String nfc_pro;
	private String use_dt;
	private String nfc_regi;
	private String bld_flr;
	
	public F_InfoDTO(String f_nick, String nfc_num, String nfc_pro, String use_dt, String nfc_regi, String bld_flr) {
		super();
		this.f_nick = f_nick;
		this.nfc_num = nfc_num;
		this.nfc_pro = nfc_pro;
		this.use_dt = use_dt;
		this.nfc_regi = nfc_regi;
		this.bld_flr = bld_flr;
	}

	public String getF_nick() {
		return f_nick;
	}

	public void setF_nick(String f_nick) {
		this.f_nick = f_nick;
	}

	public String getNfc_num() {
		return nfc_num;
	}

	public void setNfc_num(String nfc_num) {
		this.nfc_num = nfc_num;
	}

	public String getNfc_pro() {
		return nfc_pro;
	}

	public void setNfc_pro(String nfc_pro) {
		this.nfc_pro = nfc_pro;
	}

	public String getUse_dt() {
		return use_dt;
	}

	public void setUse_dt(String use_dt) {
		this.use_dt = use_dt;
	}

	public String getNfc_regi() {
		return nfc_regi;
	}

	public void setNfc_regi(String nfc_regi) {
		this.nfc_regi = nfc_regi;
	}

	public String getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(String bld_flr) {
		this.bld_flr = bld_flr;
	}

}
