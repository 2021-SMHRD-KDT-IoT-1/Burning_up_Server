package model;

public class F_InfoDTO {
	
	private String f_nick;
	private int fnc_num;
	private String nfc_pro;
	private String use_dt;
	private String nfc_regi;
	private int bld_flr;
	private String f_loc;
	
	public F_InfoDTO(String f_nick, int fnc_num, String nfc_pro, String use_dt, String nfc_regi, int bld_flr,
			String f_loc) {
		super();
		this.f_nick = f_nick;
		this.fnc_num = fnc_num;
		this.nfc_pro = nfc_pro;
		this.use_dt = use_dt;
		this.nfc_regi = nfc_regi;
		this.bld_flr = bld_flr;
		this.f_loc = f_loc;
	}

	public String getF_nick() {
		return f_nick;
	}

	public void setF_nick(String f_nick) {
		this.f_nick = f_nick;
	}

	public int getFnc_num() {
		return fnc_num;
	}

	public void setFnc_num(int fnc_num) {
		this.fnc_num = fnc_num;
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

	public int getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(int bld_flr) {
		this.bld_flr = bld_flr;
	}

	public String getF_loc() {
		return f_loc;
	}

	public void setF_loc(String f_loc) {
		this.f_loc = f_loc;
	}
	
}
