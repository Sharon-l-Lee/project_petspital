package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;

public class fBaordCommentWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String mid = request.getParameter("mid");
		String frcontent = request.getParameter("frcontent");
		String frip = request.getRemoteAddr();
		
		FreplyDao frDao = FreplyDao.getInstance();
		int result = frDao.writeComment(fnum, mid, frcontent, frip);
		if(result == FreplyDao.SUCCESS) {
			request.setAttribute("fcomment", "´ñ±Û ¼º°ø");
		}else {
			request.setAttribute("fcommentError", "´ñ±Û ½ÇÆÐ");
			
		}
		

	}

}
