package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDto.FileboardDto;

public class FreeBoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String pageNum = request.getParameter("pageNum");
	
		
		FileboardDao fDao = FileboardDao.getInstance();
		FileboardDto fbcontent = fDao.getBoard(fnum);
		request.setAttribute("fbcontent", fbcontent);

	}

}
