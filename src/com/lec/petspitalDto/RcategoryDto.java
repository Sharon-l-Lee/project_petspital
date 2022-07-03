package com.lec.petspitalDto;

public class RcategoryDto {
	private int rcategoryid;
	private String rcategoryname;
	
	
	public RcategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RcategoryDto(int rcategoryid, String rcategoryname) {
		super();
		this.rcategoryid = rcategoryid;
		this.rcategoryname = rcategoryname;
	}


	@Override
	public String toString() {
		return "RcategoryDto [rcategoryid=" + rcategoryid + ", rcategoryname=" + rcategoryname + "]";
	}


	public int getRcategoryid() {
		return rcategoryid;
	}


	public void setRcategoryid(int rcategoryid) {
		this.rcategoryid = rcategoryid;
	}


	public String getRcategoryname() {
		return rcategoryname;
	}


	public void setRcategoryname(String rcategoryname) {
		this.rcategoryname = rcategoryname;
	}
	
	
	
	
	
	
}
