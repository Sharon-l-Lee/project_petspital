package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.ScategoryDao;

public class ASymptomBoardWriteViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ScategoryDao scDao = ScategoryDao.getInstance();
		request.setAttribute("slist", scDao.listSymptom());

	}

}
