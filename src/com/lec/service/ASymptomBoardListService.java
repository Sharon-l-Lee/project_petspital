package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.SBoardDao;
import com.lec.petspitalDao.ScategoryDao;
import com.lec.petspitalDto.SBoardDto;

public class ASymptomBoardListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SBoardDao sDao = SBoardDao.getInstance();
		ScategoryDao scDao = ScategoryDao.getInstance();
		request.setAttribute("sblist", sDao.listSboard());
		request.setAttribute("category", scDao.listSymptom());
		

	}

}
