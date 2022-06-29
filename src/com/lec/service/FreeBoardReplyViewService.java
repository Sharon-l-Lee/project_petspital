package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDto.FileboardDto;

public class FreeBoardReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String pageNum = request.getParameter("pageNum");
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fborigin = fDao.reply_modifyView(fnum);
		request.setAttribute("fborigin", fborigin);
		
	}

}
