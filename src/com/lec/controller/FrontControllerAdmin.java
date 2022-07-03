package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.ALoginService;
import com.lec.service.AMemberViewService;
import com.lec.service.ASymptomBoardContentService;
import com.lec.service.ASymptomBoardDeleteService;
import com.lec.service.ASymptomBoardListService;
import com.lec.service.ASymptomBoardModifyService;
import com.lec.service.ASymptomBoardModifyViewService;
import com.lec.service.ASymptomBoardWriteService;
import com.lec.service.ASymptomBoardWriteViewService;
import com.lec.service.AmGradeDownService;
import com.lec.service.AmGradeUpService;
import com.lec.service.Service;


/**
 * Servlet implementation class FrontControllerAdmin
 */
@WebServlet("*.let")
public class FrontControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControllerAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm = uri.substring(conPath.length());
		String viewPage = null;
		Service service =null;
		
		if(comm.equals("/adminlogin.let")) {//������
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(comm.equals("/adminView.let")) {//������ ������
			viewPage = "admin/adminView.jsp";
		}else if(comm.equals("/memberView.let")) {//������ ���������� �������Ʈ����
			service = new AMemberViewService();
			service.execute(request, response);
			viewPage = "admin/memberView.jsp";
		}else if(comm.equals("/memberGradeUp.let")) {//��޾�
			service = new AmGradeUpService();
			service.execute(request, response);
			viewPage = "memberView.let";
		}else if(comm.equals("/memberGradeDown.let")) {//��� �ٿ�
			service = new AmGradeDownService();
			service.execute(request, response);
			viewPage = "memberView.let";
		}else if(comm.equals("/sBoardWriteView.let")) {//���� ���� view
			service = new ASymptomBoardWriteViewService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardWrite.jsp";
		}else if(comm.equals("/sBoardWrite.let")) {//���� ����
			service = new ASymptomBoardWriteService();
			service.execute(request, response);
			viewPage = "adminView.let";
		}else if(comm.equals("/sBoardList.let")) {//���� ���
			service = new ASymptomBoardListService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardList.jsp";
		}else if(comm.equals("/sBoardContent.let")) {//���� �󼼺���
			service = new ASymptomBoardContentService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardContent.jsp";
		}else if(comm.equals("/sBoardModifyView.let")) {//���� �����ϱ� view
			service = new ASymptomBoardModifyViewService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardModifyView.jsp";
		}else if(comm.equals("/sBoardModify.let")) {//���� �����ϱ�
			service = new ASymptomBoardModifyService();
			service.execute(request, response);
			viewPage = "sBoardList.let";
		}else if(comm.equals("/sBoardDelete.let")) {//���� �����ϱ�
			service = new ASymptomBoardDeleteService();
			service.execute(request, response);
			viewPage = "sBoardList.let";
		}
		
		

		/*
		 * 
		 * else if(comm.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}
		 * */
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}
}
