package com.lec.controller;

import java.io.IOException;

import javax.lang.model.element.ExecutableElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BookmarkMyService;
import com.lec.service.CommentAppendService;
import com.lec.service.FboardSearchListService;
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
import com.lec.service.MainService;
import com.lec.service.MwithdrawalService;
import com.lec.service.MyModifyService;
import com.lec.service.Service;
import com.lec.service.answerViewService;
import com.lec.service.fBaordCommentModifyViewService;
import com.lec.service.fBoardCommentDeleteService;
import com.lec.service.fBoardCommentListService;
import com.lec.service.fBoardCommentModifyService;
import com.lec.service.fBoardCommentModifyViewService;
import com.lec.service.fBoardCommentWriteService;
import com.lec.service.hBoardCommetnWriteService;
import com.lec.service.hBoardContentService;
import com.lec.service.hBoardDeleteService;
import com.lec.service.hBoardListService;
import com.lec.service.hBoardModifyService;
import com.lec.service.hBoardModifyViewService;
import com.lec.service.hBoardWriteService;
import com.lec.service.hBoardWriteViewService;
import com.lec.service.hBookmarkInService;
import com.lec.service.hBookmarkOutService;
import com.lec.service.hCommentAppendService;
import com.lec.service.idViewService;
import com.lec.service.myFboardListService;
import com.lec.service.pwViewService;
import com.lec.service.qListAppendService;
import com.lec.service.qWriteService;
import com.lec.service.qWriteViewService;
import com.lec.service.qaWriteService;
import com.lec.service.qnaListService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comm = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;

		if (comm.equals("/main.do")) {
			service = new MainService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if (comm.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		} else if (comm.equals("/login.do")) {
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if (comm.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		} else if (comm.equals("/join.do")) {
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "member/login.jsp";
		} else if (comm.equals("/logout.do")) {
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "loginView.do";
		} else if (comm.equals("/myView.do")) {
			viewPage = "member/myView.jsp";
		} else if (comm.equals("/myModifyView.do")) {
			viewPage = "member/myModifyView.jsp";
		} else if (comm.equals("/myModify.do")) {
			service = new MyModifyService();
			service.execute(request, response);
			viewPage = "myView.do";
		} else if (comm.equals("/freeBoardWriteView.do")) {//자유게시판
			viewPage = "freeBoard/freeBoardWrite.jsp";
		} else if (comm.equals("/freeBoardWrite.do")) {
			service = new FreeBoardWriteService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		} else if (comm.equals("/freeBoardList.do")) {
			service = new FreeBoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardList.jsp";
		} else if (comm.equals("/freeBoardModifyView.do")) {
			service = new FreeBoardModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardModify.jsp";
		} else if (comm.equals("/freeBoardModify.do")) {
			service = new FreeBoardModifyService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		} else if (comm.equals("/freeBoardContent.do")) {
			service = new FreeBoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardContent.jsp";
		} else if (comm.equals("/freeBoardDelete.do")) {
			service = new FreeBoardDeleteService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		} else if (comm.equals("/freeBoardReplyView.do")) { //자유게시판 댓글
			service = new FreeBoardReplyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/freeBoardReply.jsp";
		} else if (comm.equals("/freeBoardReply.do")) {
			service = new FreeBoardReplyService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		} else if (comm.equals("/fbCommentWrite.do")) {
			service = new fBoardCommentWriteService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		} else if (comm.equals("/commentAppend.do")) {
			service = new CommentAppendService();
			service.execute(request, response);
			viewPage = "freeBoard/fbreplyappend.jsp";
		} else if (comm.equals("/fbCommentModifyView.do")) {//
			service = new fBoardCommentModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/replyInput.jsp";
		} else if (comm.equals("/fbCommentModify.do")) {//
			service = new fBoardCommentModifyService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		} else if (comm.equals("/fbCommentDelete.do")) {//
			service = new fBoardCommentDeleteService();
			service.execute(request, response);
			viewPage = "freeBoardContent.do";
		} else if (comm.equals("/hBoardWriteView.do")) {// 병원 게시판
			service = new hBoardWriteViewService();
			service.execute(request, response);
			viewPage = "hsearchBoard/hSearchBoardWrite.jsp";
		} else if (comm.equals("/hBoardWrite.do")) {// 
			service = new hBoardWriteService();
			service.execute(request, response);
			viewPage = "hBoardList.do";
		} else if (comm.equals("/hBoardList.do")) {// 
			service = new hBoardListService();
			service.execute(request, response);
			viewPage = "hsearchBoard/hSearchBoardList.jsp";
		} else if (comm.equals("/hBoardContent.do")) {// 
			service = new hBoardContentService();
			service.execute(request, response);
			viewPage = "hsearchBoard/hSearchBoardContent.jsp";
		} else if (comm.equals("/hBoardModifyView.do")) {//
			service = new hBoardModifyViewService();
			service.execute(request, response);
			viewPage = "hsearchBoard/hSearchBoardModify.jsp";
		} else if (comm.equals("/hBoardModify.do")) {//
			service = new hBoardModifyService();
			service.execute(request, response);
			viewPage = "hBoardList.do";
		} else if (comm.equals("/hBoardDelete.do")) {//
			service = new hBoardDeleteService();
			service.execute(request, response);
			viewPage = "hBoardList.do";
		} else if (comm.equals("/hBoardCommentWrite.do")) {//
			service = new hBoardCommetnWriteService();
			service.execute(request, response);
			viewPage = "hBoardContent.do";
		} else if (comm.equals("/hCommentAppend.do")) {//
			service = new hCommentAppendService();
			service.execute(request, response);
			viewPage = "hsearchBoard/hreplyappend.jsp";
		} else if (comm.equals("/hBookmarkIn.do")) {// 북마크
			service = new hBookmarkInService();
			service.execute(request, response);
			viewPage = "hBoardContent.do";
		} else if (comm.equals("/hBookmarkOut.do")) {// 북마크 해제
			service = new hBookmarkOutService();
			service.execute(request, response);
			viewPage = "hBoardContent.do";
		} else if (comm.equals("/myFboardList.do")) {// 내 글보기
			service = new myFboardListService();
			service.execute(request, response);
			viewPage = "member/myFboardView.jsp";
		}else if (comm.equals("/fboardSearchList.do")) {// 자유게시판 검색
			service = new FboardSearchListService();
			service.execute(request, response);
			viewPage = "freeBoardList.do";
		}else if (comm.equals("/myBmarkList.do")) {// 북마크 보기
			service = new BookmarkMyService();
			service.execute(request, response);
			viewPage = "member/bookmarkView.jsp";
		}else if (comm.equals("/myBmarkList.do")) {// 북마크 보기
			service = new BookmarkMyService();
			service.execute(request, response);
			viewPage = "member/bookmarkView.jsp";
		}else if (comm.equals("/mWithdrawal.do")) {// 회원 탈퇴
			service = new MwithdrawalService();
			service.execute(request, response);
			viewPage = "main.do";
		}else if (comm.equals("/qWriteView.do")) {
			viewPage = "QnABoard/qnaBoardWrite.jsp";
		}else if (comm.equals("/qWrite.do")) {// Q작성
			service = new qWriteService();
			service.execute(request, response);
			viewPage = "qnaList.do";
		}else if (comm.equals("/aWrite.do")) {// A작성
			service = new qaWriteService();
			service.execute(request, response);
			viewPage = "qnaList.do";
		}else if (comm.equals("/qnaList.do")) {// qna리스트
			service = new qnaListService();
			service.execute(request, response);
			viewPage = "QnABoard/qnaBoardView.jsp";
		}else if (comm.equals("/answerView.do")) {// 답변보기
			service = new answerViewService();
			service.execute(request, response);
			viewPage = "QnABoard/answerView.jsp";
		}else if (comm.equals("/idpwfindView.do")) {//idpw찾기 View
			viewPage = "member/idfind.jsp";
		}else if (comm.equals("/idfind.do")) {// id찾기
			service = new idViewService();
			service.execute(request, response);
			viewPage = "idpwfindView.do";
		}else if (comm.equals("/pwfind.do")) {// pw찾기
			service = new pwViewService();
			service.execute(request, response);
			viewPage = "idpwfindView.do";
		}



		
		
//		else if (comm.equals("/AnswerAppend.do")) {// qna리스트
//			service = new qListAppendService();
//			service.execute(request, response);
//			viewPage = "QnABoard/qnaContent.jsp";
//		}
		/*
		  else if (comm.equals("/fbCommentModifyView.do")) {
			service = new fBaordCommentModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/replyInput.jsp";
		} }
		 */

		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);

	}

}
