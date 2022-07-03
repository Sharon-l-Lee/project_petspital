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
import com.lec.petspitalDao.NoticeDao;
import com.lec.petspitalDto.AdminDto;
import com.lec.petspitalDto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ANoticeWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("freeBoardPhoto");
		int maxSize = 1024 * 1024 * 10;
		String filename = "";
		String originFilename = "";
		try {

			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			int idx = 0;
			while (paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				if (!param.equals("files")) {
					filename = mRequest.getFilesystemName(param);
					originFilename = mRequest.getOriginalFileName(param);
					idx++;
				}
			}
			HttpSession session = request.getSession();
			AdminDto admin = (AdminDto) session.getAttribute("admin");
			String aid = admin.getAid();
			String nfilename = filename;
			String nsubject = mRequest.getParameter("nsubject");
			String ncontent = mRequest.getParameter("ncontent");
			String nip = request.getRemoteAddr();

			NoticeDao nDao = NoticeDao.getInstance();
			int result = nDao.writeNboard(aid, nsubject, ncontent, nfilename, nip);
			if (result == NoticeDao.SUCCESS) {
				request.setAttribute("nwriteresult", "공지 글쓰기 성공");
			} else {
				request.setAttribute("nwriteErrorMsg", "공지 글쓰기 실패");

			}
			request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (filename != null) {
			InputStream is = null;
			OutputStream os = null;
			try {

				File serverfile = new File(path + "/" + filename);
				if (serverfile.exists()) {
					is = new FileInputStream(serverfile);
					os = new FileOutputStream(
							"D:\\LDSwebPro\\source\\07_project\\project\\WebContent\\noticePhoto/" + filename);
					byte[] bs = new byte[(int) serverfile.length()];
					while (true) {
						int nReadCnt = is.read(bs);
						if (nReadCnt == -1)
							break;
						os.write(bs, 0, nReadCnt);
					} // while
					System.out.println("서버 파일 첨부 &  복사 완료");
				} // if
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (os != null)
						os.close();
					if (is != null)
						is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
