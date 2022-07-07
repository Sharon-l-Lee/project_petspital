package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.NoticeDao;
import com.lec.petspitalDao.QnaDao;
import com.lec.petspitalDto.QnaDto;

public class qnaListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 6, BLOCKSIZE = 5;
		int startRow = (currentPage - 1) * PAGESIZE + 1;
		int endRow = startRow + PAGESIZE - 1;
		QnaDao qDao = QnaDao.getInstance();
		int totalBoard = qDao.countQnA();
		request.setAttribute("qnaList", qDao.listQnA(startRow, endRow));
		int pageCnt = (int) Math.ceil((double) totalBoard / PAGESIZE);

		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}

		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("pageCnt", pageCnt);

		

	}

}
