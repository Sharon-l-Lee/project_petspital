package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.AFboardListService;
import com.lec.service.ALoginService;
import com.lec.service.AMemberViewService;
import com.lec.service.ANoticeContentService;
import com.lec.service.ANoticeDeleteService;
import com.lec.service.ANoticeListService;
import com.lec.service.ANoticeModifyService;
import com.lec.service.ANoticeModifyViewService;
import com.lec.service.ANoticeWriteService;
import com.lec.service.ASymptomBoardContentService;
import com.lec.service.ASymptomBoardDeleteService;
import com.lec.service.ASymptomBoardListService;
import com.lec.service.ASymptomBoardModifyService;
import com.lec.service.ASymptomBoardModifyViewService;
import com.lec.service.ASymptomBoardWriteService;
import com.lec.service.ASymptomBoardWriteViewService;
import com.lec.service.AmGradeDownService;
import com.lec.service.AmGradeUpService;
import com.lec.service.MEmailConfirmService;
import com.lec.service.MIdConfirmService;
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
		
		if(comm.equals("/adminlogin.let")) {//
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(comm.equals("/adminView.let")) {//
			viewPage = "admin/adminView.jsp";
		}else if(comm.equals("/memberView.let")) {//
			service = new AMemberViewService();
			service.execute(request, response);
			viewPage = "admin/memberView.jsp";
		}else if(comm.equals("/memberGradeUp.let")) {//
			service = new AmGradeUpService();
			service.execute(request, response);
			viewPage = "memberView.let";
		}else if(comm.equals("/memberGradeDown.let")) {//
			service = new AmGradeDownService();
			service.execute(request, response);
			viewPage = "memberView.let";
		}else if(comm.equals("/sBoardWriteView.let")) {//
			service = new ASymptomBoardWriteViewService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardWrite.jsp";
		}else if(comm.equals("/sBoardWrite.let")) {//
			service = new ASymptomBoardWriteService();
			service.execute(request, response);
			viewPage = "adminView.let";
		}else if(comm.equals("/sBoardList.let")) {//
			service = new ASymptomBoardListService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardList.jsp";
		}else if(comm.equals("/sBoardContent.let")) {//
			service = new ASymptomBoardContentService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardContent.jsp";
		}else if(comm.equals("/sBoardModifyView.let")) {//
			service = new ASymptomBoardModifyViewService();
			service.execute(request, response);
			viewPage = "adminSBoard/sBoardModifyView.jsp";
		}else if(comm.equals("/sBoardModify.let")) {//
			service = new ASymptomBoardModifyService();
			service.execute(request, response);
			viewPage = "sBoardList.let";
		}else if(comm.equals("/sBoardDelete.let")) {//
			service = new ASymptomBoardDeleteService();
			service.execute(request, response);
			viewPage = "sBoardList.let";
		}else if(comm.equals("/noticeWriteView.let")) {//
			viewPage = "notice/noticeWrite.jsp";
		}else if(comm.equals("/noticeWrite.let")) {//
			service = new ANoticeWriteService();
			service.execute(request, response);
			viewPage = "main.do";
		}else if(comm.equals("/noticeList.let")) {//
			service = new ANoticeListService();
			service.execute(request, response);
			viewPage = "notice/noticeList.jsp";
		}else if(comm.equals("/noticeDelete.let")) {//
			service = new ANoticeDeleteService();
			service.execute(request, response);
			viewPage = "noticeList.let";
		}else if(comm.equals("/noticeContent.let")) {//
			service = new ANoticeContentService();
			service.execute(request, response);
			viewPage = "notice/noticeContent.jsp";
		}else if(comm.equals("/noticeModifyView.let")) {//
			service = new ANoticeModifyViewService();
			service.execute(request, response);
			viewPage = "notice/noticeModify.jsp";
		}else if(comm.equals("/noticeModify.let")) {//
			service = new ANoticeModifyService();
			service.execute(request, response);
			viewPage = "noticeList.let";
		}else if(comm.equals("/idConfirm.let")) {//
			service = new MIdConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";
		}else if(comm.equals("/emailConfirm.let")) {//
			service = new MEmailConfirmService();
			service.execute(request, response);
			viewPage = "member/emailConfirm.jsp";
		}else if(comm.equals("/adminFboardList.let")) {//관리자탭에서 자유게시판 글 관리
			service = new AFboardListService();
			service.execute(request, response);
			viewPage = "admin/adminFboardList.jsp";
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
