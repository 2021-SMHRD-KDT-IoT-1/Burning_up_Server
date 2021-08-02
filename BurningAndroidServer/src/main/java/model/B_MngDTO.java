package model;

public class B_MngDTO {

	private int bld_flr;
	private String bld_dwg;
	
	public B_MngDTO(int bld_flr, String bld_dwg) {
		super();
		this.bld_flr = bld_flr;
		this.bld_dwg = bld_dwg;
	}

	public int getBld_flr() {
		return bld_flr;
	}

	public void setBld_flr(int bld_flr) {
		this.bld_flr = bld_flr;
	}

	public String getBld_dwg() {
		return bld_dwg;
	}

	public void setBld_dwg(String bld_dwg) {
		this.bld_dwg = bld_dwg;
	}
	
}
