package com.model;

public class B_MngDTO {

	private String bld_flr;
	private String bld_dwg;
	
	public B_MngDTO(String bld_flr, String bld_dwg) {
		super();
		this.bld_flr = bld_flr;
		this.bld_dwg = bld_dwg;
	}

	public String getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(String bld_flr) {
		this.bld_flr = bld_flr;
	}

	public String getBld_dwg() {
		return bld_dwg;
	}

	public void setBld_dwg(String bld_dwg) {
		this.bld_dwg = bld_dwg;
	}

}
