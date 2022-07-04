package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDto.FreplyDto;

public class CommentAppendService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String repageNum = request.getParameter("repageNum");
		if(repageNum==null) {
			repageNum = "1";
		}
		final int PAGESIZE=5;
		int recurrentPage = Integer.parseInt(repageNum);
		FreplyDao frDao = FreplyDao.getInstance();
		int totalComment = frDao.countComment();
		int pageCnt = (int)Math.ceil((double)totalComment/PAGESIZE);//����������
		if(recurrentPage<=pageCnt) {
			int startRow = (recurrentPage-1) * PAGESIZE +1;
			int endRow   = startRow + PAGESIZE -1;
			ArrayList<FreplyDto> freplyList = frDao.listComment(fnum, startRow, endRow);
			request.setAttribute("freplyList", freplyList);
			request.setAttribute("fnum", fnum);
			request.setAttribute("repageNum", recurrentPage);// pageNum ������ param.pageNum
		}else {
			request.setAttribute("error", "���̻��������� ����");
		}
	}
	}


