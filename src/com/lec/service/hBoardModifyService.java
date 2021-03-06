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
import com.lec.petspitalDao.RhospitalDao;
import com.lec.petspitalDto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class hBoardModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("hsearchBoardPhoto");
		int maxSize = 1024 * 1024 * 10;
		String[] filename = {"","",""};
		String[] originFilename = {"","",""};
		try {
			
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames();
			int idx=0;
			while(paramNames.hasMoreElements()) {
				String param = paramNames.nextElement();
				if(!param.equals("files")) {
					filename[idx] = mRequest.getFilesystemName(param); 
					originFilename[idx]= mRequest.getOriginalFileName(param);
					idx++;
				}
			}
			HttpSession session = request.getSession();
			int rcategoryid = Integer.parseInt(mRequest.getParameter("rcategoryid"));
			int rnum = Integer.parseInt(mRequest.getParameter("rnum"));
			MemberDto member = (MemberDto)session.getAttribute("member");
			String mid = member.getMid();
			String rfilename = filename[2];
			String rfilename2 = filename[1];
			String rfilename3 = filename[0];
			String rsubject = mRequest.getParameter("rsubject");
			String rcontent = mRequest.getParameter("rcontent");
			String rip = request.getRemoteAddr();
			
			RhospitalDao rDao = RhospitalDao.getInstance();
			String pageNum = request.getParameter("pageNum");
				int result = rDao.modifyhBoard(rcategoryid, rsubject, rcontent, rfilename, rfilename2, rfilename3, rip, rnum);
				if(result == FileboardDao.SUCCESS) {
					request.setAttribute("fwriteresult", "???? ?? ???? ????");
				}else {
					request.setAttribute("fwriteErrorMsg", "???? ?? ???? ????");
					
				}
				request.setAttribute("pageNum", mRequest.getParameter("pageNum"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for(String f : filename){
			if(f!=null){
				InputStream is = null; 
				OutputStream os = null;
				try {
					
					File serverfile = new File(path + "/" + f);
					if (serverfile.exists()) { 
						is = new FileInputStream(serverfile); 
						os = new FileOutputStream("D:\\LDSwebPro\\source\\07_1'st Project\\project\\WebContent\\hsearchBoardPhoto/" + f);
						byte[] bs = new byte[(int) serverfile.length()];
						while (true) {
					int nReadCnt = is.read(bs);
					if (nReadCnt == -1)
						break; 
					os.write(bs, 0, nReadCnt); 
				} // while
						System.out.println("???? ???? ???? &  ???? ????");
					} //if
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


	

}
