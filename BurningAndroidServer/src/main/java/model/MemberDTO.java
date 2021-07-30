package model;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String addr;
	private String b_name;
	private String gen;
	private String bir;
	private int code;

	public MemberDTO(String id, String pw, String name, String tel, String addr, String b_name, String gen, String bir,
			int code) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.b_name = b_name;
		this.gen = gen;
		this.bir = bir;
		this.code = code;
	}
	
	public MemberDTO(String id, String pw, String name, String tel, String addr, String b_name,	int code) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.b_name = b_name;
		this.code = code;
	}
	
	public MemberDTO(int code, String id, String pw, String name, String tel, String gen, String bir) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.gen = gen;
		this.bir = bir;
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getBir() {
		return bir;
	}

	public void setBir(String bir) {
		this.bir = bir;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
