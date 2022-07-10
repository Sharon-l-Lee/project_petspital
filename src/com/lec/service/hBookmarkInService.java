package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.BookmarkDao;
import com.lec.petspitalDto.AdminDto;
import com.lec.petspitalDto.MemberDto;

public class hBookmarkInService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
//		AdminDto admin = (AdminDto)session.getAttribute("admin");
		String mid = null;
		String aid= null;
		if(member !=null) {
			mid = member.getMid();
		}
//		if(admin != null) {
//			aid = admin.getAid();
//		}
		
		BookmarkDao bDao = BookmarkDao.getInstance();
		int result = bDao.bookMarkIn(rnum, mid, aid);
		if(result == BookmarkDao.SUCCESS) {
			request.setAttribute("bookmarkin", "ºÏ¸¶Å© ¼º°ø");
		}

	}

}
