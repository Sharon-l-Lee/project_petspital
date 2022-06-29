package com.lec.petspitalDto;

import java.sql.Date;

public class FileboardDto {
	private int fnum;
	private String mid;
	private String mname;
	private String fsubject;
	private String fcontent;
	private String ffilename;
	private String ffilename2;
	private String ffilename3;
	private Date frdate;
	private int fhit;
	private int fgroup;
	private int fstep;
	private int findent;
	private String fip;
	
	//»ý¼ºÀÚ
	
	public FileboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FileboardDto(int fnum, String mid, String mname, String fsubject, String fcontent, String ffilename, String ffilename2,
			String ffilename3, Date frdate, int fhit, int fgroup, int fstep, int findent, String fip) {
		super();
		this.fnum = fnum;
		this.mid = mid;
		this.mname = mname;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.ffilename2 = ffilename2;
		this.ffilename3 = ffilename3;
		this.frdate = frdate;
		this.fhit = fhit;
		this.fgroup = fgroup;
		this.fstep = fstep;
		this.findent = findent;
		this.fip = fip;
	}


	//toString

	
	@Override
	public String toString() {
		return "FileboardDto [fnum=" + fnum + ", mid=" + mid + ", mname=" + mname + ", fsubject=" + fsubject
				+ ", fcontent=" + fcontent + ", ffilename=" + ffilename + ", ffilename2=" + ffilename2 + ", ffilename3="
				+ ffilename3 + ", frdate=" + frdate + ", fhit=" + fhit + ", fgroup=" + fgroup + ", fstep=" + fstep
				+ ", findent=" + findent + ", fip=" + fip + "]";
	}


	
	
	
	
	//setter & getter
	
	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public int getFnum() {
		return fnum;
	}





	public void setFnum(int fnum) {
		this.fnum = fnum;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getFsubject() {
		return fsubject;
	}



	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}



	public String getFcontent() {
		return fcontent;
	}



	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}



	public String getFfilename() {
		return ffilename;
	}



	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}



	public String getFfilename2() {
		return ffilename2;
	}



	public void setFfilename2(String ffilename2) {
		this.ffilename2 = ffilename2;
	}



	public String getFfilename3() {
		return ffilename3;
	}



	public void setFfilename3(String ffilename3) {
		this.ffilename3 = ffilename3;
	}



	public Date getFrdate() {
		return frdate;
	}



	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}



	public int getFhit() {
		return fhit;
	}



	public void setFhit(int fhit) {
		this.fhit = fhit;
	}



	public int getFgroup() {
		return fgroup;
	}



	public void setFgroup(int fgroup) {
		this.fgroup = fgroup;
	}



	public int getFstep() {
		return fstep;
	}



	public void setFstep(int fstep) {
		this.fstep = fstep;
	}



	public int getFindent() {
		return findent;
	}



	public void setFindent(int findent) {
		this.findent = findent;
	}



	public String getFip() {
		return fip;
	}



	public void setFip(String fip) {
		this.fip = fip;
	}
	
	
	
	
	
	

}
