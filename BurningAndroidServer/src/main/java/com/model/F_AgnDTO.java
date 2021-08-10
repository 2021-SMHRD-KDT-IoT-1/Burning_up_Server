package com.model;

public class F_AgnDTO {
	
	private int agn_num;
	private int fnc_num;
	private int agn_value;
	
	public F_AgnDTO(int agn_num, int fnc_num, int agn_value) {
		super();
		this.agn_num = agn_num;
		this.fnc_num = fnc_num;
		this.agn_value = agn_value;
	}

	public int getAgn_num() {
		return agn_num;
	}

	public void setAgn_num(int agn_num) {
		this.agn_num = agn_num;
	}

	public int getFnc_num() {
		return fnc_num;
	}

	public void setFnc_num(int fnc_num) {
		this.fnc_num = fnc_num;
	}

	public int getAgn_value() {
		return agn_value;
	}

	public void setAgn_value(int agn_value) {
		this.agn_value = agn_value;
	}

}
