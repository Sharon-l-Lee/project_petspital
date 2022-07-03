package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.AdminDao;

public class ALoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getInstance();
		
		int result = aDao.adminLogin(aid, apw);
		if(result == AdminDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", aDao.aidDto(aid));
		}
	}

}
