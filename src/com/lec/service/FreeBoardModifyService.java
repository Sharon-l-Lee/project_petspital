package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.petspitalDao.FileboardDao;
import com.lec.petspitalDao.MemberDao;
import com.lec.petspitalDto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FreeBoardModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("freeBoardPhoto");
		int maxSize = 1024 * 1024 * 10;
		String filenames[]= {"","",""};
		String originalFilenames[]= {"","",""};
		
		
		
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			int idx = 0;
			while(paramNames.hasMoreElements()) {
				String param= paramNames.nextElement();
				if(!param.equals("files")) {
					filenames[idx]= mRequest.getFilesystemName(param);
					originalFilenames[idx] = mRequest.getOriginalFileName(param);
					idx++;
				}
			
			}
			HttpSession session = request.getSession();
			int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
			String dbfilename = mRequest.getParameter("dbfilename");
			String dbfilename2 = mRequest.getParameter("dbfilename2");
			String dbfilename3 = mRequest.getParameter("dbfilename3");
			String ffilename = filenames[2];
			ffilename = (ffilename==null ) ?  dbfilename : ffilename;
			String ffilename2 = filenames[1];
			ffilename2 = (ffilename2==null ) ?  dbfilename2 : ffilename2;
			String ffilename3 = filenames[0];
			ffilename3 = (ffilename3==null ) ?  dbfilename3: ffilename3;
			String fsubject = mRequest.getParameter("fsubject");
			String fcontent = mRequest.getParameter("fcontent");
			String fip = request.getRemoteAddr();
			
			FileboardDao fDao = FileboardDao.getInstance();
			int result = fDao.modifyBoard(fnum, fsubject, fcontent, ffilename, ffilename2, ffilename3, fip);
			if(result == FileboardDao.SUCCESS) {
				request.setAttribute("fboardModifyResult", "자유게시판 글 수정 성공");
			}else {
				request.setAttribute("fboardModifyError", "자유게시판 글 수정 실패");
				
			}
		
				request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 서버에 올라간 fileboardUp 파일을 소스폴더에 filecopy (파일 수정을 안 했거나, 예외가 떨어질 경우 복사 안 함)
		
		
			
			for(String f : filenames) {
				InputStream is =null;
				OutputStream os = null;
			
					try {
						File serverfile = new File(path + "/" + f);
						if(serverfile.exists()) {
						is = new FileInputStream(serverfile);
						os = new FileOutputStream("D:\\LDSwebPro\\source\\07_1'st Project\\project\\WebContent\\freeBoardPhoto/"+f);
						byte bs[] = new byte[(int) serverfile.length()];
						while(true) {
							int nReadCnt = is.read(bs);
							if(nReadCnt == -1) break;
							os.write(bs, 0, nReadCnt);
						}
						System.out.println("파일 변경 완료");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				
			}
		
	}

}
