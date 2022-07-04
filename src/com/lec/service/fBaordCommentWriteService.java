package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.AdminDto;
import com.lec.petspitalDto.MemberDto;

public class fBaordCommentWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int fnum = Integer.parseInt(request.getParameter("fnum"));
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		AdminDto admin = (AdminDto) session.getAttribute("admin");
		String mid = null, aid = null;
		if (member != null) {
			mid = member.getMid();
		} else if (admin != null) {
			aid = admin.getAid();
		}
		String frcontent = request.getParameter("frcontent");
		String frip = request.getRemoteAddr();

		FreplyDao frDao = FreplyDao.getInstance();
		int result = frDao.writeComment(fnum, mid, aid, frcontent, frip);
		if (result == FreplyDao.SUCCESS) {

			request.setAttribute("fcomment", "댓글 성공");
		} else {
			request.setAttribute("fcommentError", "댓글 실패");

		}

	}

}
