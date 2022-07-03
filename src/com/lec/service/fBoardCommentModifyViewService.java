package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.FreplyDto;

public class fBoardCommentModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int frnum = Integer.parseInt(request.getParameter("frnum"));
		String frcontent = request.getParameter("frcontent");
		FreplyDao frDao = FreplyDao.getInstance();
		FreplyDto frcondto = frDao.getComment(frnum);
		request.setAttribute("frcondto", frcondto);

	}

}
