package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.NoticeDao;
import com.lec.petspitalDto.NoticeDto;

public class MainService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeDao nDao = NoticeDao.getInstance();
		request.setAttribute("notice", nDao.mainListnboard());

	}

}
