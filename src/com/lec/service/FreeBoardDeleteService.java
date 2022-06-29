package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FileboardDao;

public class FreeBoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao fDao = FileboardDao.getInstance();
		int result = fDao.deleteBoard(fnum);
		if(result == FileboardDao.SUCCESS) {
			request.setAttribute("fboardDeleteResult", "�Խ��� �� ���� ����");
		}else {
			request.setAttribute("fboardDeleteError", "�Խ��� �� ���� ����");
			
		}
	}

}
