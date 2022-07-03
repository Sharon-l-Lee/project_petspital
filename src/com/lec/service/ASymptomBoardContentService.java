package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.SBoardDao;

public class ASymptomBoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int snum = Integer.parseInt(request.getParameter("snum"));
		SBoardDao sDao = SBoardDao.getInstance();
		request.setAttribute("slistcon", sDao.numDto(snum));
		

	}

}
