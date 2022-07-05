package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.MemberDao;

public class MIdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.idCheck(mid);
		if(result == MemberDao.MEMBER_EXIST) {
			request.setAttribute("idConfirmResult", "존재하는 아이디입니다");
		}else {
			request.setAttribute("idConfirmResult", "사용가능한 아이디입니다");
			
		}

	}

}
