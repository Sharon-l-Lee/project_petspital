package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.RcategoryDao;
import com.lec.petspitalDao.RhospitalDao;
import com.lec.petspitalDto.RcategoryDto;

public class hBoardListService implements Service {

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
		String rcategoryname = request.getParameter("rcategoryname");
		if(rcategoryname ==null) {
			rcategoryname = "";
		}
		RhospitalDao rDao = RhospitalDao.getInstance();
		int totalBoard = rDao.countHboard();
		request.setAttribute("HboardView", rDao.listHboard(rcategoryname, startRow, endRow));
		
		int pageCnt = (int) Math.ceil((double)totalBoard/PAGESIZE);
		
		int startPage = ((currentPage-1) / BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt ) {
			endPage = pageCnt;
		}
		
		RcategoryDao rcDao = RcategoryDao.getInstance();
		request.setAttribute("rlist", rcDao.listAnimal());
		request.setAttribute("rcategoryname",rcategoryname);
		
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); 
		request.setAttribute("pageCnt", pageCnt);
		

	}

}
