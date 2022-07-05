package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.MemberDao;

public class MEmailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.emailCheck(memail);
		if(result == MemberDao.MEMBER_EXIST) {
			request.setAttribute("emailConfirmResult", "존재하는 이메일입니다");
		}else {
			request.setAttribute("emailConfirmResult", "사용가능한 이메일입니다");
			
		}

	}

	

}
