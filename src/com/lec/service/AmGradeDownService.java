package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.MemberDao;

public class AmGradeDownService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.gradeDown(mid);
		if(result == MemberDao.SUCCESS) {
			request.setAttribute("mgradedown", "등급 다운 완료");
		}
	}

}
