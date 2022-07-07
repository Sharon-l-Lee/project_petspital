package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.MemberDao;

public class pwViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		String fmpw = mDao.pwFind(memail);
		if (fmpw != null) {
			request.setAttribute("fmpw", fmpw);
		}
	}
	

}
