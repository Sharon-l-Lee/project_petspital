package com.lec.petspitalDto;

import java.sql.Date;

public class QnaDto {
	private int qnum;
	private String mid;
	private String mname;
	private String qsubject;
	private String qcontent;
	private String qfilename;
	private Date qrdate;
	private int qgroup;
	private int qstep;
	private int qindent;
	private int qhit;
	private String qip;

	public QnaDto() {
	}

	public QnaDto(int qnum, String mid, String mname, String qsubject, String qcontent, String qfilename, Date qrdate,
			int qgroup, int qstep, int qindent, int qhit, String qip) {
		this.qnum = qnum;
		this.mid = mid;
		this.mname = mname;
		this.qsubject = qsubject;
		this.qcontent = qcontent;
		this.qfilename = qfilename;
		this.qrdate = qrdate;
		this.qgroup = qgroup;
		this.qstep = qstep;
		this.qindent = qindent;
		this.qhit = qhit;
		this.qip = qip;
	}

	@Override
	public String toString() {
		return "QnaDto [qnum=" + qnum + ", mid=" + mid + ", mname=" + mname + ", qsubject=" + qsubject + ", qcontent="
				+ qcontent + ", qfilename=" + qfilename + ", qrdate=" + qrdate + ", qgroup=" + qgroup + ", qstep="
				+ qstep + ", qindent=" + qindent + ", qhit=" + qhit + ", qip=" + qip + "]";
	}

	public int getQgroup() {
		return qgroup;
	}

	public void setQgroup(int qgroup) {
		this.qgroup = qgroup;
	}

	public int getQstep() {
		return qstep;
	}

	public void setQstep(int qstep) {
		this.qstep = qstep;
	}

	public int getQindent() {
		return qindent;
	}

	public void setQindent(int qindent) {
		this.qindent = qindent;
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

	public String getQsubject() {
		return qsubject;
	}

	public void setQsubject(String qsubject) {
		this.qsubject = qsubject;
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

	public String getQip() {
		return qip;
	}

	public void setQrip(String qip) {
		this.qip = qip;
	}

}
