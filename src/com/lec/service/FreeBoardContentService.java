package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.FileboardDto;
import com.lec.petspitalDto.FreplyDto;

public class FreeBoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String pageNum = request.getParameter("pageNum");
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fbcontent = fDao.getBoard(fnum);
		request.setAttribute("fbcontent", fbcontent);
		
		
		int recurrentPage = 1;
		final int PAGESIZE= 5;
		int startRow = (recurrentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		FreplyDao frDao = FreplyDao.getInstance();
		int totalComment = frDao.countComment();
		request.setAttribute("freplyList", frDao.listComment(fnum, startRow, endRow));
		int pageCnt = (int) Math.ceil((double)totalComment/PAGESIZE);
		
		

		request.setAttribute("repageNum", recurrentPage); 
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("totCnt", totalComment);
	

	}

}
