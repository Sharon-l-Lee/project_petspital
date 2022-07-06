package com.lec.petspitalDto;

import java.sql.Date;

public class RhospitalDto {
	private int rnum;
	private int rcategoryid;
	private String rcategoryname;
	private String mid;
	private String mname;
	private String rsubject;
	private String rcontent;
	private String rfilename;
	private String rfilename2;
	private String rfilename3;
	private int rhit;
	private Date rrdate;
	private String rip;

	public RhospitalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RhospitalDto(int rnum, int rcategoryid, String mid, String mname, String rsubject, String rcontent,
			String rfilename, String rfilename2, String rfilename3, int rhit, Date rrdate, String rip) {
		super();
		this.rnum = rnum;
		this.rcategoryid = rcategoryid;
		this.mid = mid;
		this.mname = mname;
		this.rsubject = rsubject;
		this.rcontent = rcontent;
		this.rfilename = rfilename;
		this.rfilename2 = rfilename2;
		this.rfilename3 = rfilename3;
		this.rhit = rhit;
		this.rrdate = rrdate;
		this.rip = rip;
	}
	
	

	public RhospitalDto(int rnum, int rcategoryid, String rcategoryname, String mid, String mname, String rsubject,
			String rcontent, String rfilename, String rfilename2, String rfilename3, int rhit, Date rrdate,
			String rip) {
		super();
		this.rnum = rnum;
		this.rcategoryid = rcategoryid;
		this.rcategoryname = rcategoryname;
		this.mid = mid;
		this.mname = mname;
		this.rsubject = rsubject;
		this.rcontent = rcontent;
		this.rfilename = rfilename;
		this.rfilename2 = rfilename2;
		this.rfilename3 = rfilename3;
		this.rhit = rhit;
		this.rrdate = rrdate;
		this.rip = rip;
	}

	
	
	
	public RhospitalDto(int rnum, String mid, String rsubject, Date rrdate) {
		this.rnum = rnum;
		this.mid = mid;
		this.rsubject = rsubject;
		this.rrdate = rrdate;
	}

	@Override
	public String toString() {
		return "RhospitalDto [rnum=" + rnum + ", rcategoryid=" + rcategoryid + ", rcategoryname=" + rcategoryname
				+ ", mid=" + mid + ", mname=" + mname + ", rsubject=" + rsubject + ", rcontent=" + rcontent
				+ ", rfilename=" + rfilename + ", rfilename2=" + rfilename2 + ", rfilename3=" + rfilename3 + ", rhit="
				+ rhit + ", rrdate=" + rrdate + ", rip=" + rip + "]";
	}

	
	public String getRcategoryname() {
		return rcategoryname;
	}

	public void setRcategoryname(String rcategoryname) {
		this.rcategoryname = rcategoryname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getRcategoryid() {
		return rcategoryid;
	}

	public void setRcategoryid(int rcategoryid) {
		this.rcategoryid = rcategoryid;
	}

	public String getRsubject() {
		return rsubject;
	}

	public void setRsubject(String rsubject) {
		this.rsubject = rsubject;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRfilename() {
		return rfilename;
	}

	public void setRfilename(String rfilename) {
		this.rfilename = rfilename;
	}

	public String getRfilename2() {
		return rfilename2;
	}

	public void setRfilename2(String rfilename2) {
		this.rfilename2 = rfilename2;
	}

	public String getRfilename3() {
		return rfilename3;
	}

	public void setRfilename3(String rfilename3) {
		this.rfilename3 = rfilename3;
	}

	public int getRhit() {
		return rhit;
	}

	public void setRhit(int rhit) {
		this.rhit = rhit;
	}

	public Date getRrdate() {
		return rrdate;
	}

	public void setRrdate(Date rrdate) {
		this.rrdate = rrdate;
	}

	public String getRip() {
		return rip;
	}

	public void setRip(String rip) {
		this.rip = rip;
	}

}
