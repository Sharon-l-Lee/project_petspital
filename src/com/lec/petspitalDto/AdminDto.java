package com.lec.petspitalDto;

public class AdminDto {
	private String aid;
	private String apw;
	private String aname;
	
	
	//»ý¼ºÀÚ
	public AdminDto() {
	}


	public AdminDto(String aid, String apw, String aname) {
		super();
		this.aid = aid;
		this.apw = apw;
		this.aname = aname;
	}


	//toString
	@Override
	public String toString() {
		return "adminDto [aid=" + aid + ", apw=" + apw + ", aname=" + aname + "]";
	}

	//setter &  getter

	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getApw() {
		return apw;
	}


	public void setApw(String apw) {
		this.apw = apw;
	}


	public String getAname() {
		return aname;
	}


	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
	
	
	
}
