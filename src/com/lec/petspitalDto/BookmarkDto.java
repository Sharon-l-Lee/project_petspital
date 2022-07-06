package com.lec.petspitalDto;

public class BookmarkDto {
	private int bnum;
	private int rnum;
	private String mid;
	private String aid;
	
	
	
	public BookmarkDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	

	public BookmarkDto(int bnum, int rnum, String mid) {
		super();
		this.bnum = bnum;
		this.rnum = rnum;
		this.mid = mid;
	}






	public BookmarkDto(int bnum, int rnum, String mid, String aid) {
		super();
		this.bnum = bnum;
		this.rnum = rnum;
		this.mid = mid;
		this.aid = aid;
	}




	

	
	
	
	public BookmarkDto(int bnum, String mid) {
		this.bnum = bnum;
		this.mid = mid;
		// TODO Auto-generated constructor stub
	}






	@Override
	public String toString() {
		return "BookmarkDto [bnum=" + bnum + ", rnum=" + rnum + ", mid=" + mid + ", aid=" + aid + "]";
	}




	public String getAid() {
		return aid;
	}




	public void setAid(String aid) {
		this.aid = aid;
	}




	public int getBnum() {
		return bnum;
	}


	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	
	
	
	
}
