package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.FreplyDto;

public class fBoardCommentModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int frnum = Integer.parseInt(request.getParameter("frnum"));
		String frcontent = request.getParameter("frcontent");
		FreplyDao frDao = FreplyDao.getInstance();
		int result = frDao.modifyComment(frcontent, frnum);
		if(result == FreplyDao.SUCCESS) {
			request.setAttribute("frcontent", frcontent);
		}
	}

}
