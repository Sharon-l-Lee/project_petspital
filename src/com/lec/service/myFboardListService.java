package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDto.MemberDto;

public class myFboardListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("member");
		String mid = member.getMid();
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE= 10, BLOCKSIZE= 5;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		FileboardDao fDao = FileboardDao.getInstance();
		int totalBoard = fDao.countMyBoard(mid);
		request.setAttribute("myfreeBoard", fDao.listMyFboard(mid, startRow, endRow));
		int pageCnt = (int) Math.ceil((double)totalBoard/PAGESIZE);
		
		int startPage = ((currentPage-1) / BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt ) {
			endPage = pageCnt;
		}
		
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); 
		request.setAttribute("pageCnt", pageCnt);
		
		
		
	}
		

	

}
