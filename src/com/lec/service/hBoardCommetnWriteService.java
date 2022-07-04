package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.HreplyDao;
import com.lec.petspitalDto.AdminDto;
import com.lec.petspitalDto.MemberDto;

public class hBoardCommetnWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		AdminDto admin = (AdminDto) session.getAttribute("admin");
		String mid = null;
		String aid = null;
		if(member != null) {
			mid = member.getMid();
			
		}else if (admin != null) {
			aid = admin.getAid();
		}
		String hcontent = request.getParameter("hcontent");
		String hip = request.getRemoteAddr();
		int hrating = Integer.parseInt(request.getParameter("hrating"));
		HreplyDao hDao = HreplyDao.getInstance();
		int result = hDao.writehComment(rnum, mid, aid, hcontent,hrating, hip);
		if(result == HreplyDao.SUCCESS) {
			request.setAttribute("HcomtWrite", "병원 댓글 성공");
		}else {
			request.setAttribute("HcomtWriteError", "병원 댓글 실패");
			
		}

	}

}
