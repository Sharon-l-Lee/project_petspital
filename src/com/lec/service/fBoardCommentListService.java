package com.lec.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.FileboardDto;
import com.lec.petspitalDto.FreplyDto;

public class fBoardCommentListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE= 10, BLOCKSIZE= 5;
		int startRow = (currentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		FreplyDao frDao = FreplyDao.getInstance();
		int totalBoard = frDao.countComment();
		request.setAttribute("freplyList", frDao.listComment(fnum, startRow, endRow));
		int pageCnt = (int) Math.ceil((double)totalBoard/PAGESIZE);
		
		int startPage = ((currentPage-1) / BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt ) {
			endPage = pageCnt;
		}
		FreplyDto fbrcontent= frDao.getComment(fnum);
		request.setAttribute("fbrcontent", fbrcontent);
	
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage); 
		request.setAttribute("pageCnt", pageCnt);
	
		
	}

}
