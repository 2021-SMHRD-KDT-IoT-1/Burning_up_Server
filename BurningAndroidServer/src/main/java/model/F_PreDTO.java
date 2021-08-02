package model;

public class F_PreDTO {
	
	private int pre_num; 
	private int nfc_num;
	private int pre_value;
	
	public F_PreDTO(int pre_num, int nfc_num, int pre_value) {
		super();
		this.pre_num = pre_num;
		this.nfc_num = nfc_num;
		this.pre_value = pre_value;
	}

	public int getPre_num() {
		return pre_num;
	}

	public void setPre_num(int pre_num) {
		this.pre_num = pre_num;
	}

	public int getNfc_num() {
		return nfc_num;
	}

	public void setNfc_num(int nfc_num) {
		this.nfc_num = nfc_num;
	}

	public int getPre_value() {
		return pre_value;
	}

	public void setPre_value(int pre_value) {
		this.pre_value = pre_value;
	}

}
