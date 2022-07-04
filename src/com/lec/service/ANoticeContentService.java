package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.NoticeDao;
import com.lec.petspitalDto.NoticeDto;

public class ANoticeContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nnum = Integer.parseInt(request.getParameter("nnum"));
		NoticeDao nDao = NoticeDao.getInstance();
		NoticeDto notice = nDao.getnBoard(nnum);
		request.setAttribute("nContent", notice);
		
	}

}
