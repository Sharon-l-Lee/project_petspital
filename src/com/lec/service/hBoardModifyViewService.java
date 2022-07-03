package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.RcategoryDao;
import com.lec.petspitalDao.RhospitalDao;
import com.lec.petspitalDto.FileboardDto;
import com.lec.petspitalDto.MemberDto;
import com.lec.petspitalDto.RhospitalDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class hBoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		RhospitalDao rDao = RhospitalDao.getInstance();
		RhospitalDto rboard = rDao.modifyView(rnum);
		request.setAttribute("rboard", rboard);
		RcategoryDao rcDao = RcategoryDao.getInstance();
		request.setAttribute("rlist", rcDao.listAnimal());
		
}

}