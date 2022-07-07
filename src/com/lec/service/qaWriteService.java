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

import com.lec.petspitalDao.NoticeDao;
import com.lec.petspitalDao.QnaDao;
import com.lec.petspitalDto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class qaWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("QnAPhoto");
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
			MemberDto member = (MemberDto) session.getAttribute("member");
			String mid = member.getMid();
			String qfilename = filename;
			String qsubject = mRequest.getParameter("qsubject");
			String qcontent = mRequest.getParameter("qcontent");
			int qgroup = Integer.parseInt(mRequest.getParameter("qgroup"));
			int qstep = Integer.parseInt(mRequest.getParameter("qstep"));
			int qindent = Integer.parseInt(mRequest.getParameter("qindent"));
			String qip = request.getRemoteAddr();

			QnaDao qDao = QnaDao.getInstance();
			int result = qDao.replyA(mid, qsubject, qcontent, qfilename, qgroup, qstep, qindent, qip);
			if (result == NoticeDao.SUCCESS) {
				request.setAttribute("nwriteresult", "답변글 올리기 성공");
				request.setAttribute("reqgroup", qgroup);
				request.setAttribute("reqcontent", qcontent);
			} else {
				request.setAttribute("nwriteErrorMsg", "답변글 올리기 실패");

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
							"D:\\LDSwebPro\\source\\07_1'st Project\\project\\WebContent\\QnAPhoto/" + filename);
					byte[] bs = new byte[(int) serverfile.length()];
					while (true) {
						int nReadCnt = is.read(bs);
						if (nReadCnt == -1)
							break;
						os.write(bs, 0, nReadCnt);
					} // while
					System.out.println("�뙆�씪泥⑤� 蹂듭궗 �셿猷�");
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
