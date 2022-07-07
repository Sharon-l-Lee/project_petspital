package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.MemberDao;
import com.lec.petspitalDto.MemberDto;

public class idViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		String fmid = mDao.idFind(memail);
		if (fmid != null) {
			request.setAttribute("fmid", fmid);
		}
	}

}
