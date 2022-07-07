package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDao.QnaDao;
import com.lec.petspitalDto.FreplyDto;
import com.lec.petspitalDto.QnaDto;

public class qListAppendService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
				int qnum = Integer.parseInt(request.getParameter("qnum"));
				String pageNum = request.getParameter("pageNum");
				if(pageNum==null) {
					pageNum = "1";
				}
				final int PAGESIZE=5;
				int recurrentPage = Integer.parseInt(pageNum);
				QnaDao qDao = QnaDao.getInstance();
				int totalComment = qDao.countQnA();
				int pageCnt = (int)Math.ceil((double)totalComment/PAGESIZE);//����������
				if(recurrentPage<=pageCnt) {
					int startRow = (recurrentPage-1) * PAGESIZE +1;
					int endRow   = startRow + PAGESIZE -1;
					
					request.setAttribute("qContent", qDao.reply_modifyView(qnum));
					request.setAttribute("qnum", qnum);
					request.setAttribute("repageNum", recurrentPage);// pageNum ������ param.pageNum
				}else {
					request.setAttribute("error", "���̻��������� ����");
				}	
	}
}
