package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.RcategoryDao;
import com.lec.petspitalDao.ScategoryDao;

public class hBoardWriteViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		RcategoryDao rDao = RcategoryDao.getInstance();
		request.setAttribute("rlist", rDao.listAnimal());

	}

}
