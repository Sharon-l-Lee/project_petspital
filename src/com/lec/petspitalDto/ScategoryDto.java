package com.lec.petspitalDto;

public class ScategoryDto {
	private int scategoryid;
	private String scategoryname;
	
	public ScategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScategoryDto(int scategoryid, String scategoryname) {
		super();
		this.scategoryid = scategoryid;
		this.scategoryname = scategoryname;
	}

	@Override
	public String toString() {
		return "ScategoryDto [scategoryid=" + scategoryid + ", scategoryname=" + scategoryname + "]";
	}

	public int getScategoryid() {
		return scategoryid;
	}

	public void setScategoryid(int scategoryid) {
		this.scategoryid = scategoryid;
	}

	public String getScategoryname() {
		return scategoryname;
	}

	public void setScategoryname(String scategoryname) {
		this.scategoryname = scategoryname;
	}
	
	
	
	
	
}
