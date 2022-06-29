package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;

public class FreeBoardListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE= 10, BLOCKSIZE= 5;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		FileboardDao fDao = FileboardDao.getInstance();
		int totalBoard = fDao.countBoard();
		request.setAttribute("freeBoardView", fDao.listBoard(startRow, endRow));
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
