package com.model;

public class F_ClcDTO {
	
	private String clc_no;
	private String id;
	private int nfc_num;
	private String clc_dt;
	private String clc_dsp;
	
	public F_ClcDTO(String clc_no, String id, int nfc_num, String clc_dt, String clc_dsp) {
		super();
		this.clc_no = clc_no;
		this.id = id;
		this.nfc_num = nfc_num;
		this.clc_dt = clc_dt;
		this.clc_dsp = clc_dsp;
	}

	public String getClc_no() {
		return clc_no;
	}

	public void setClc_no(String clc_no) {
		this.clc_no = clc_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNfc_num() {
		return nfc_num;
	}

	public void setNfc_num(int nfc_num) {
		this.nfc_num = nfc_num;
	}

	public String getClc_dt() {
		return clc_dt;
	}

	public void setClc_dt(String clc_dt) {
		this.clc_dt = clc_dt;
	}

	public String getClc_dsp() {
		return clc_dsp;
	}

	public void setClc_dsp(String clc_dsp) {
		this.clc_dsp = clc_dsp;
	}
	
}
