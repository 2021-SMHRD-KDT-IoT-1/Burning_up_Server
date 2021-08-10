package com.model;

public class FrfinfoDTO {
	
	private int frf_num;
	private String frf_tlt;
	private String frf_cnt;
	private String frf_file;
	private String frf_dt;
	
	public FrfinfoDTO(int frf_num, String frf_tlt, String frf_cnt, String frf_file, String frf_dt) {
		super();
		this.frf_num = frf_num;
		this.frf_tlt = frf_tlt;
		this.frf_cnt = frf_cnt;
		this.frf_file = frf_file;
		this.frf_dt = frf_dt;
	}
	
	public FrfinfoDTO(String frf_tlt, String frf_cnt, String frf_file) {
		super();
		this.frf_tlt = frf_tlt;
		this.frf_cnt = frf_cnt;
		this.frf_file = frf_file;
	}

	public int getFrf_num() {
		return frf_num;
	}

	public void setFrf_num(int frf_num) {
		this.frf_num = frf_num;
	}

	public String getFrf_tlt() {
		return frf_tlt;
	}

	public void setFrf_tlt(String frf_tlt) {
		this.frf_tlt = frf_tlt;
	}

	public String getFrf_cnt() {
		return frf_cnt;
	}

	public void setFrf_cnt(String frf_cnt) {
		this.frf_cnt = frf_cnt;
	}

	public String getFrf_file() {
		return frf_file;
	}

	public void setFrf_file(String frf_file) {
		this.frf_file = frf_file;
	}

	public String getFrf_dt() {
		return frf_dt;
	}

	public void setFrf_dt(String frf_dt) {
		this.frf_dt = frf_dt;
	}
	
}
