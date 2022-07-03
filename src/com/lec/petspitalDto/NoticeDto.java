package com.lec.petspitalDto;

import java.sql.Date;

public class NoticeDto {
	private int nnum;
	private String aid;
	private String aname;
	private String nsubject;
	private String ncontent;
	private String nfilename;
	private Date nrdate;
	private int nhit;
	private String nip;
	
	
	public NoticeDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NoticeDto(int nnum, String aid, String nsubject, String ncontent, String nfilename, Date nrdate, int nhit,
			String nip) {
		super();
		this.nnum = nnum;
		this.aid = aid;
		this.nsubject = nsubject;
		this.ncontent = ncontent;
		this.nfilename = nfilename;
		this.nrdate = nrdate;
		this.nhit = nhit;
		this.nip = nip;
	}

	
	

	

	public NoticeDto(int nnum, String aid, String aname, String nsubject, String ncontent, String nfilename,
			Date nrdate, int nhit, String nip) {
		super();
		this.nnum = nnum;
		this.aid = aid;
		this.aname = aname;
		this.nsubject = nsubject;
		this.ncontent = ncontent;
		this.nfilename = nfilename;
		this.nrdate = nrdate;
		this.nhit = nhit;
		this.nip = nip;
	}


	
	
	
	@Override
	public String toString() {
		return "NoticeDto [nnum=" + nnum + ", aid=" + aid + ", aname=" + aname + ", nsubject=" + nsubject
				+ ", ncontent=" + ncontent + ", nfilename=" + nfilename + ", nrdate=" + nrdate + ", nhit=" + nhit
				+ ", nip=" + nip + "]";
	}


	
	
	
	public String getAname() {
		return aname;
	}


	public void setAname(String aname) {
		this.aname = aname;
	}


	public int getNnum() {
		return nnum;
	}


	public void setNnum(int nnum) {
		this.nnum = nnum;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}


	public String getNsubject() {
		return nsubject;
	}


	public void setNsubject(String nsubject) {
		this.nsubject = nsubject;
	}


	public String getNcontent() {
		return ncontent;
	}


	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}


	public String getNfilename() {
		return nfilename;
	}


	public void setNfilename(String nfilename) {
		this.nfilename = nfilename;
	}


	public Date getNrdate() {
		return nrdate;
	}


	public void setNrdate(Date nrdate) {
		this.nrdate = nrdate;
	}


	public int getNhit() {
		return nhit;
	}


	public void setNhit(int nhit) {
		this.nhit = nhit;
	}


	public String getNip() {
		return nip;
	}


	public void setNip(String nip) {
		this.nip = nip;
	}
	
	
	
	

}
