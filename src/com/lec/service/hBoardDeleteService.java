package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.RhospitalDao;
import com.sun.javafx.collections.SetAdapterChange;

public class hBoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		RhospitalDao rDao = RhospitalDao.getInstance();
		int result = rDao.deleteBoard(rnum);
		if(result == RhospitalDao.SUCCESS) {
			request.setAttribute("rboardDelete", "병원 글 삭제 성공");
		}else {
			request.setAttribute("rboardDelete", "병원 글 삭제 실패");
			
		}
	}

}
