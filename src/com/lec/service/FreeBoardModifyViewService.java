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
		FileboardDto fboard = fDao.reply_modifyView(fnum); //�� �������� set���� �ʰ� �󼼺��� >  �����Ҷ� �ҷ��ͼ� set
		request.setAttribute("fboard", fboard);
	}

}
