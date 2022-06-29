package com.lec.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.MemberDao;
import com.lec.petspitalDto.MemberDto;

public class MyModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid =  request.getParameter("mid"); 
		  String mpw =  request.getParameter("mpw");
		  String mname =  request.getParameter("mname");
		  String memail =  request.getParameter("memail");
		  String mbirthStr = request.getParameter("mbirth"); 
			Date mbirth = null;
			if (!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
		  String mgender =  request.getParameter("mgender");
		  String mphone =  request.getParameter("mphone");
		  String maddress =  request.getParameter("maddress");
		  String maddress2 =  request.getParameter("maddress2");
		  
		  MemberDao mDao = MemberDao.getInstance();
		  MemberDto member = new MemberDto(mid, mpw, mname, mbirth, mgender, memail, mphone, maddress, maddress2, 1, null);
		  int result = mDao.modifyMember(member);
		  if(result == MemberDao.SUCCESS) {
			  HttpSession session = request.getSession();
			  session.setAttribute("member", member);
			  request.setAttribute("modify_result", "회원수정 성공");
		  }else {
			  
			  request.setAttribute("modifyErrorMsg", "회원수정 실패");
		  }

	}

}
