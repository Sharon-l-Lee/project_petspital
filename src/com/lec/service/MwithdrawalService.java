package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.BookmarkDao;
import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.FreplyDao;
import com.lec.petspitalDao.HreplyDao;
import com.lec.petspitalDao.MemberDao;
import com.lec.petspitalDao.RhospitalDao;
import com.lec.petspitalDto.MemberDto;

public class MwithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		if (member != null) {
			String mid = member.getMid();
			FileboardDao fDao = FileboardDao.getInstance();
			FreplyDao frDao = FreplyDao.getInstance();
			RhospitalDao rDao = RhospitalDao.getInstance();
			HreplyDao hDao = HreplyDao.getInstance();
			BookmarkDao bDao = BookmarkDao.getInstance();
			fDao.withdrawfb(mid);
			frDao.withdrawfr(mid);
			rDao.withdrawho(mid);
			hDao.withdrawhr(mid);
			bDao.withdrawbm(mid);

			MemberDao mDao = MemberDao.getInstance();
			int result = mDao.deleteMember(mid);
			if (result == MemberDao.SUCCESS) {
				request.setAttribute("result", "회원 탈퇴 성공, 지워진 글은 복원할 수 없습니다");
			} else {
				request.setAttribute("result", "회원 탈퇴 실패");

			}

		} else {

			request.setAttribute("result", "로그인 된 회원이 아닙니다");
		}
		session.invalidate();

	}

}
