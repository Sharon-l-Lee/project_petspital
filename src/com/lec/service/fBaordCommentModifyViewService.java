package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;

public class fBaordCommentModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int frnum = Integer.parseInt(request.getParameter("frnum"));
		FreplyDao frDao = FreplyDao.getInstance();
		request.setAttribute("ccontent", frDao.getComment(frnum));
	}

}
