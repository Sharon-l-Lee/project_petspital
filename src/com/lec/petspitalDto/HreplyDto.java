package com.lec.petspitalDto;

import java.sql.Date;

public class HreplyDto {
	private int hnum;
	private int rnum;
	private String mid;
	private String mname;
	private String aid;
	private String hcontent;
	private int hrating;
	private Date hrdate;
	private String hip;
	
	
	//생성자
	
	public HreplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HreplyDto(int hnum, int rnum, String mid, String mname, String aid, String hcontent, int hrating,
			Date hrdate, String hip) {
		super();
		this.hnum = hnum;
		this.rnum = rnum;
		this.mid = mid;
		this.mname = mname;
		this.aid = aid;
		this.hcontent = hcontent;
		this.hrating = hrating;
		this.hrdate = hrdate;
		this.hip = hip;
	}


	
	public HreplyDto(int hnum, int rnum, String mid, String mname, String hcontent, int hrating, Date hrdate, String hip) {
		super();
		this.hnum = hnum;
		this.rnum = rnum;
		this.mid = mid;
		this.mname = mname;
		this.hcontent = hcontent;
		this.hrating = hrating;
		this.hrdate = hrdate;
		this.hip = hip;
	}
	
	public HreplyDto(int hnum, int rnum, String mid, String mname, String hcontent, Date hrdate, String hip) {
		super();
		this.hnum = hnum;
		this.rnum = rnum;
		this.mid = mid;
		this.mname = mname;
		this.hcontent = hcontent;
		this.hrdate = hrdate;
		this.hip = hip;
	}


	


	public int getHnum() {
		return hnum;
	}


	public void setHnum(int hnum) {
		this.hnum = hnum;
	}


	public int getRnum() {
		return rnum;
	}


	public void setRnum(int rnum) {
		this.rnum = rnum;
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


	public String getHcontent() {
		return hcontent;
	}


	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}


	public int getHrating() {
		return hrating;
	}


	public void setHrating(int hrating) {
		this.hrating = hrating;
	}


	public Date getHrdate() {
		return hrdate;
	}


	public void setHrdate(Date hrdate) {
		this.hrdate = hrdate;
	}


	public String getHip() {
		return hip;
	}


	public void setHip(String hip) {
		this.hip = hip;
	}
	
	
	
	
	
	
	
	

	
}
