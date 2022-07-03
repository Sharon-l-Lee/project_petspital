package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.SBoardDao;
import com.lec.petspitalDto.AdminDto;

public class ASymptomBoardWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int scategoryid = Integer.parseInt(request.getParameter("scategoryid"));
		AdminDto admin = (AdminDto) session.getAttribute("admin");
		String aid = admin.getAid();
		String ssubject = request.getParameter("ssubject");
		String scontent = request.getParameter("scontent");
		SBoardDao sDao = SBoardDao.getInstance();
		int result = sDao.writeSboard(scategoryid, aid, ssubject, scontent);
		if(result == SBoardDao.SUCCESS) {
			request.setAttribute("sboardWrite", "증상글 쓰기 성공");
		}else {
			request.setAttribute("sboardWriteError", "증상글 쓰기 실패");
			
		}
	}

}
