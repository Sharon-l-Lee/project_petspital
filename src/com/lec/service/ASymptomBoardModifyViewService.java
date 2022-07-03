package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.SBoardDao;
import com.lec.petspitalDao.ScategoryDao;

public class ASymptomBoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int snum = Integer.parseInt(request.getParameter("snum"));
		SBoardDao sDao = SBoardDao.getInstance();
		ScategoryDao scDao = ScategoryDao.getInstance();
		request.setAttribute("slist", scDao.listSymptom());
		request.setAttribute("slistcon", sDao.numDto(snum));

	}

}
