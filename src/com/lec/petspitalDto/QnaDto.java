package com.lec.petspitalDto;

import java.sql.Date;

public class QnaDto {
	private int qnum;
	private String mid;
	private String mname;
	private String qsubejct;
	private String qcontent;
	private String qfilename;
	private Date qrdate;
	private int qhit;
	private String qrip;
	
	public QnaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QnaDto(int qnum, String mid, String mname, String qsubejct, String qcontent, String qfilename, Date qrdate,
			int qhit, String qrip) {
		super();
		this.qnum = qnum;
		this.mid = mid;
		this.mname = mname;
		this.qsubejct = qsubejct;
		this.qcontent = qcontent;
		this.qfilename = qfilename;
		this.qrdate = qrdate;
		this.qhit = qhit;
		this.qrip = qrip;
	}

	public QnaDto(int qnum, String mid, String qsubejct, String qcontent, String qfilename, Date qrdate, int qhit,
			String qrip) {
		super();
		this.qnum = qnum;
		this.mid = mid;
		this.qsubejct = qsubejct;
		this.qcontent = qcontent;
		this.qfilename = qfilename;
		this.qrdate = qrdate;
		this.qhit = qhit;
		this.qrip = qrip;
	}

	@Override
	public String toString() {
		return "QnaDto [qnum=" + qnum + ", mid=" + mid + ", mname=" + mname + ", qsubejct=" + qsubejct + ", qcontent="
				+ qcontent + ", qfilename=" + qfilename + ", qrdate=" + qrdate + ", qhit=" + qhit + ", qrip=" + qrip
				+ "]";
	}

	public int getQnum() {
		return qnum;
	}

	public void setQnum(int qnum) {
		this.qnum = qnum;
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

	public String getQsubejct() {
		return qsubejct;
	}

	public void setQsubejct(String qsubejct) {
		this.qsubejct = qsubejct;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public String getQfilename() {
		return qfilename;
	}

	public void setQfilename(String qfilename) {
		this.qfilename = qfilename;
	}

	public Date getQrdate() {
		return qrdate;
	}

	public void setQrdate(Date qrdate) {
		this.qrdate = qrdate;
	}

	public int getQhit() {
		return qhit;
	}

	public void setQhit(int qhit) {
		this.qhit = qhit;
	}

	public String getQrip() {
		return qrip;
	}

	public void setQrip(String qrip) {
		this.qrip = qrip;
	}
	
	
	
	

}
