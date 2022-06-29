package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDto.FileboardDto;

public class FreeBoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fboard = fDao.reply_modifyView(fnum); //글 쓸때부터 set하지 않고 상세보기 >  수정할때 불러와서 set
		request.setAttribute("fboard", fboard);
	}

}
