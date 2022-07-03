package com.lec.petspitalDto;

public class SBoardDto {
	private int snum;
	private String aid;
	private int scategoryid;
	private String scategoryname;
	private String ssubject;
	private String scontent;
	
	public SBoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SBoardDto(int snum, String aid, int scategoryid, String scategoryname, String ssubject, String scontent) {
		super();
		this.snum = snum;
		this.aid = aid;
		this.scategoryid = scategoryid;
		this.scategoryname = scategoryname;
		this.ssubject = ssubject;
		this.scontent = scontent;
	}

	
	
	public SBoardDto(int snum, String aid, int scategoryid, String ssubject, String scontent) {
		super();
		this.snum = snum;
		this.aid = aid;
		this.scategoryid = scategoryid;
		this.ssubject = ssubject;
		this.scontent = scontent;
	}

	@Override
	public String toString() {
		return "SBoardDto [snum=" + snum + ", aid=" + aid + ", scategoryid=" + scategoryid + ", scategoryname="
				+ scategoryname + ", ssubject=" + ssubject + ", scontent=" + scontent + "]";
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	public String getSsubject() {
		return ssubject;
	}

	public void setSsubject(String ssubject) {
		this.ssubject = ssubject;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	
	
	

}
