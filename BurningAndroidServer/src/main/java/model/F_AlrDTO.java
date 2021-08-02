package model;

public class F_AlrDTO {

	private int alr_num;
	private int nfc_num;
	private String id;
	private String alr_date;
	private int bld_flr;
	
	public F_AlrDTO(int alr_num, int nfc_num, String id, String alr_date, int bld_flr) {
		super();
		this.alr_num = alr_num;
		this.nfc_num = nfc_num;
		this.id = id;
		this.alr_date = alr_date;
		this.bld_flr = bld_flr;
	}

	public int getAlr_num() {
		return alr_num;
	}

	public void setAlr_num(int alr_num) {
		this.alr_num = alr_num;
	}

	public int getNfc_num() {
		return nfc_num;
	}

	public void setNfc_num(int nfc_num) {
		this.nfc_num = nfc_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlr_date() {
		return alr_date;
	}

	public void setAlr_date(String alr_date) {
		this.alr_date = alr_date;
	}

	public int getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(int bld_flr) {
		this.bld_flr = bld_flr;
	}

}
