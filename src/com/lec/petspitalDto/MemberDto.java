package com.lec.petspitalDto;

import java.sql.Date;

public class MemberDto {
	 private String mid; 
	 private String mpw ;
	 private String mname;
	 private Date mbirth;
	 private String mgender;
	 private String memail;
	 private String mphone;
	 private String maddress;
	 private String maddress2;
	 private int mgrade;
	 private Date mrdate;
	 
	 //»ý¼ºÀÚ
	public MemberDto() {
		
	}

	public MemberDto(String mid, String mpw, String mname, Date mbirth, String mgender, String memail, String mphone,
			String maddress, String maddress2, int mgrade, Date mrdate) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
		this.mgender = mgender;
		this.memail = memail;
		this.mphone = mphone;
		this.maddress = maddress;
		this.maddress2 = maddress2;
		this.mgrade = mgrade;
		this.mrdate = mrdate;
	}
	public MemberDto(String mid,  String mname, Date mbirth,  String memail, String mphone,
			 int mgrade, Date mrdate) {
		this.mid = mid;
		this.mname = mname;
		this.mbirth = mbirth;
		this.memail = memail;
		this.mphone = mphone;
		this.mgrade = mgrade;
		this.mrdate = mrdate;
	}

	//toString
	
	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth + ", mgender="
				+ mgender + ", memail=" + memail + ", mphone=" + mphone + ", maddress=" + maddress + ", maddress2="
				+ maddress2 + ", mgrade=" + mgrade + ", mrdate=" + mrdate + "]";
	}

	
	//setter & getter
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Date getMbirth() {
		return mbirth;
	}

	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMaddress2() {
		return maddress2;
	}

	public void setMaddress2(String maddress2) {
		this.maddress2 = maddress2;
	}

	public int getMgrade() {
		return mgrade;
	}

	public void setMgrade(int mgrade) {
		this.mgrade = mgrade;
	}

	public Date getMrdate() {
		return mrdate;
	}

	public void setMrdate(Date mrdate) {
		this.mrdate = mrdate;
	}
	
	
	
	
	
	 
}
