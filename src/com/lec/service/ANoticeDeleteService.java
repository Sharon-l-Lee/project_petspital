package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.NoticeDao;

public class ANoticeDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nnum = Integer.parseInt(request.getParameter("nnum"));
		NoticeDao ntDao = NoticeDao.getInstance();
		int result = ntDao.deleteNBoard(nnum);
		if(result == NoticeDao.SUCCESS) {
			request.setAttribute("noticedelete", "공지사항 삭제완료");
		}
	}

}
