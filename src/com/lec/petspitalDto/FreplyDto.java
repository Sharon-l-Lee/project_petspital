package com.lec.petspitalDto;

import java.sql.Date;

public class FreplyDto {
	private int frnum;
	private int fnum;
	private String mid;
	private String mname;
	private String aid;
	private String frcontent;
	private Date frdate;
	private String frip;
	
	
	public FreplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	//MID
	
	public FreplyDto(int frnum, int fnum, String mname, String aid, String frcontent, Date frdate, String frip) {
		super();
		this.frnum = frnum;
		this.fnum = fnum;
		this.mname = mname;
		this.aid = aid;
		this.frcontent = frcontent;
		this.frdate = frdate;
		this.frip = frip;
	}

	
	
	

	public FreplyDto(int frnum, int fnum, String mid, String mname, String aid, String frcontent, Date frdate,
			String frip) {
		super();
		this.frnum = frnum;
		this.fnum = fnum;
		this.mid = mid;
		this.mname = mname;
		this.aid = aid;
		this.frcontent = frcontent;
		this.frdate = frdate;
		this.frip = frip;
	}

	@Override
	public String toString() {
		return "FreplyDto [frnum=" + frnum + ", fnum=" + fnum + ", mid=" + mid + ", mname=" + mname + ", aid=" + aid
				+ ", frcontent=" + frcontent + ", frdate=" + frdate + ", frip=" + frip + "]";
	}

	public int getFrnum() {
		return frnum;
	}

	public void setFrnum(int frnum) {
		this.frnum = frnum;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
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

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}



	public String getFrcontent() {
		return frcontent;
	}

	public void setFrcontent(String frcontent) {
		this.frcontent = frcontent;
	}

	public Date getFrdate() {
		return frdate;
	}

	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}

	public String getFrip() {
		return frip;
	}

	public void setFrip(String frip) {
		this.frip = frip;
	}
	
	
	
	
	
	
	
	

}
