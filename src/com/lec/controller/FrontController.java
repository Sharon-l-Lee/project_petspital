package com.lec.controller;

import java.io.IOException;

import javax.lang.model.element.ExecutableElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.CommentAppendService;
import com.lec.service.FreeBoardContentService;
import com.lec.service.FreeBoardDeleteService;
import com.lec.service.FreeBoardListService;
import com.lec.service.FreeBoardModifyService;
import com.lec.service.FreeBoardModifyViewService;
import com.lec.service.FreeBoardReplyService;
import com.lec.service.FreeBoardReplyViewService;
import com.lec.service.FreeBoardWriteService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MyModifyService;
import com.lec.service.Service;
import com.lec.service.fBoardCommentDeleteService;
import com.lec.service.fBoardCommentListService;
import com.lec.service.fBoardCommentModifyService;
import com.lec.service.fBoardCommentModifyViewService;
import com.lec.service.fBoardCommentWriteService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		if(comm.equals("/main.do")) {
			viewPage = "main/main.jsp";
		}else if(comm.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		}else if(comm.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(comm.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		}else if(comm.equals("/join.do")) {
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(comm.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(comm.equals("/myView.do")) {
			//service = new MyViewService();
			//service.execute(request, response);
			viewPage = "member/myView.jsp";
		}else if(comm.equals("/myModifyView.do")) {
			viewPage = "member/myModifyView.jsp";
		}else if(comm.equals("/myModify.do")) {
			service = new MyModifyService();
			service.execute(request, response);
			viewPage = "member/myView.jsp";
		}else if(comm.equals("/freeBoardWriteView.do")) {
			viewPage = "freeBoard/freeBoardWrite.jsp";
		}else if(comm.equals("/freeBoardWrite.do")) {
			service = new FreeBoardWriteService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		}else if(comm.equals("/freeBoardList.do")) { 
			service = new FreeBoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardList.jsp";
		}else if(comm.equals("/freeBoardModifyView.do")) {
			service = new FreeBoardModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardModify.jsp";
		}else if(comm.equals("/freeBoardModify.do")) {
			service = new FreeBoardModifyService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		}else if(comm.equals("/freeBoardContent.do")) {
			service = new FreeBoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardContent.jsp";
		}else if(comm.equals("/freeBoardDelete.do")) {
			service = new FreeBoardDeleteService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		}else if(comm.equals("/freeBoardReplyView.do")) {
			service = new FreeBoardReplyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardReply.jsp";
		}else if(comm.equals("/freeBoardReply.do")) {
			service = new FreeBoardReplyService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		}else if(comm.equals("/fbCommentWrite.do")) {
			service = new fBoardCommentWriteService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		}else if(comm.equals("/commentAppend.do")) {
			service = new CommentAppendService();
			service.execute(request, response);
			viewPage = "freeBoard/fbreplyappend.jsp";
		}else if(comm.equals("/fbCommentModifyView.do")) {//
			service = new fBoardCommentModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/replyInput.jsp";
		}else if(comm.equals("/fbCommentModify.do")) {//
			service = new fBoardCommentModifyService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		}else if(comm.equals("/fbCommentDelete.do")) {//
			service = new fBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		}else if(comm.equals("/fbCommentDelete.do")) {//병원 글쓰기
			service = new fBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		}
		
		
		
		
		/*
			 * else if(comm.equals("/fbCommentModifyView.do")) { service = new
			 * fBaordCommentModifyViewService(); ; service.execute(request, response);
			 * viewPage = "freeBoardContent.do"; }
			 */
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
	}

}
