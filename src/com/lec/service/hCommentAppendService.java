package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDao.HreplyDao;
import com.lec.petspitalDto.FreplyDto;
import com.lec.petspitalDto.HreplyDto;

public class hCommentAppendService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		String repageNum = request.getParameter("repageNum");
		if(repageNum == null) {
			repageNum = "1";
		}
		int currentPage = Integer.parseInt(repageNum);
		final int PAGESIZE= 10;
		HreplyDao hDao = HreplyDao.getInstance();
		int totalBoard = hDao.counthComment();
		int pageCnt = (int) Math.ceil((double)totalBoard/PAGESIZE);
		
		if(currentPage<=pageCnt) {
			int startRow = (currentPage-1) * PAGESIZE +1;
			int endRow = startRow + PAGESIZE -1;
			ArrayList<HreplyDto> hreplyList = hDao.listhComment(rnum, startRow, endRow);
			request.setAttribute("hreplyList", hreplyList);
			request.setAttribute("rnum", rnum);
			request.setAttribute("repageNum", currentPage);// 
		}else {
			request.setAttribute("error", "병원 댓글 리스트 출력 실패");
		}
		
	
		
	}


	

}
