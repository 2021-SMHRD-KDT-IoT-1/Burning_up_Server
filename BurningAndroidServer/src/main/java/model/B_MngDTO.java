package model;

public class B_MngDTO {

	private int BLD_FLR;
	private String BLD_DWG;
	
	public B_MngDTO(int bLD_FLR, String bLD_DWG) {
		super();
		BLD_FLR = bLD_FLR;
		BLD_DWG = bLD_DWG;
	}

	public int getBLD_FLR() {
		return BLD_FLR;
	}

	public void setBLD_FLR(int bLD_FLR) {
		BLD_FLR = bLD_FLR;
	}

	public String getBLD_DWG() {
		return BLD_DWG;
	}

	public void setBLD_DWG(String bLD_DWG) {
		BLD_DWG = bLD_DWG;
	}
	
}
