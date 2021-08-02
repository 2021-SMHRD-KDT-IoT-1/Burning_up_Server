package model;

public class F_ChckDTO {

	private int chck_num;
	private String f_nick;
	private int nfc_num;
	private int bld_flr;
	private String chck_pwd;
	private String chck_press;
	private String chck_pin;
	private String chck_body;
	private String chck_lever;
	private String chck_hose;
	private String chck_date;
	
	public F_ChckDTO(int chck_num, String f_nick, int nfc_num, int bld_flr, String chck_pwd, String chck_press,
			String chck_pin, String chck_body, String chck_lever, String chck_hose, String chck_date) {
		super();
		this.chck_num = chck_num;
		this.f_nick = f_nick;
		this.nfc_num = nfc_num;
		this.bld_flr = bld_flr;
		this.chck_pwd = chck_pwd;
		this.chck_press = chck_press;
		this.chck_pin = chck_pin;
		this.chck_body = chck_body;
		this.chck_lever = chck_lever;
		this.chck_hose = chck_hose;
		this.chck_date = chck_date;
	}

	public int getChck_num() {
		return chck_num;
	}

	public void setChck_num(int chck_num) {
		this.chck_num = chck_num;
	}

	public String getF_nick() {
		return f_nick;
	}

	public void setF_nick(String f_nick) {
		this.f_nick = f_nick;
	}

	public int getNfc_num() {
		return nfc_num;
	}

	public void setNfc_num(int nfc_num) {
		this.nfc_num = nfc_num;
	}

	public int getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(int bld_flr) {
		this.bld_flr = bld_flr;
	}

	public String getChck_pwd() {
		return chck_pwd;
	}

	public void setChck_pwd(String chck_pwd) {
		this.chck_pwd = chck_pwd;
	}

	public String getChck_press() {
		return chck_press;
	}

	public void setChck_press(String chck_press) {
		this.chck_press = chck_press;
	}

	public String getChck_pin() {
		return chck_pin;
	}

	public void setChck_pin(String chck_pin) {
		this.chck_pin = chck_pin;
	}

	public String getChck_body() {
		return chck_body;
	}

	public void setChck_body(String chck_body) {
		this.chck_body = chck_body;
	}

	public String getChck_lever() {
		return chck_lever;
	}

	public void setChck_lever(String chck_lever) {
		this.chck_lever = chck_lever;
	}

	public String getChck_hose() {
		return chck_hose;
	}

	public void setChck_hose(String chck_hose) {
		this.chck_hose = chck_hose;
	}

	public String getChck_date() {
		return chck_date;
	}

	public void setChck_date(String chck_date) {
		this.chck_date = chck_date;
	}
	
}
