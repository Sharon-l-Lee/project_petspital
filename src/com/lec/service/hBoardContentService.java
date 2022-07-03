package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDao.RhospitalDao;
import com.lec.petspitalDto.FileboardDto;
import com.lec.petspitalDto.RhospitalDto;

public class hBoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		String pageNum = request.getParameter("pageNum");
		RhospitalDao rDao = RhospitalDao.getInstance();
		RhospitalDto rhcontent = rDao.getBoard(rnum);
		request.setAttribute("rhcontent", rhcontent);
		request.setAttribute("pageNum", pageNum);
		
		
		
		
		
		/* int recurrentPage = 1;
		final int PAGESIZE= 5;
		int startRow = (recurrentPage-1) * PAGESIZE +1;
		int endRow = startRow + PAGESIZE -1;
		´ñ±Û ºÎºÐ
		 * FreplyDao frDao = FreplyDao.getInstance(); int totalComment =
		 * frDao.countComment(); request.setAttribute("freplyList",
		 * frDao.listComment(fnum, startRow, endRow));
		int pageCnt = (int) Math.ceil((double)totalComment/PAGESIZE);
		
		request.setAttribute("repageNum", recurrentPage); 
		 request.setAttribute("pageCnt", pageCnt); request.setAttribute("totCnt",
		 * totalComment);
		 */
	

	}

	

}
