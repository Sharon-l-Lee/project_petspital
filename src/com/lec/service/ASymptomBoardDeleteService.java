package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.SBoardDao;

public class ASymptomBoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int snum = Integer.parseInt(request.getParameter("snum"));
		SBoardDao sDao = SBoardDao.getInstance();
		int result = sDao.deleteSBoard(snum);
		if(result == SBoardDao.SUCCESS) {
			request.setAttribute("sboarddelete", "증상 글 삭제 성공");
		}else {
			request.setAttribute("sboarddeleteError", "증상 글 삭제 실패");
			
		}
	}

}
