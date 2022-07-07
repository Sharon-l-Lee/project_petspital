package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.MemberDao;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		
		int result = mDao.memberLogin(mid, mpw);
		if(result == MemberDao.LOGIN_SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", mDao.idDto(mid));
		}else {
			request.setAttribute("loginErrorMsg", "아이디 혹은 비밀번호를 확인하세요");
			
		}

	}

}
