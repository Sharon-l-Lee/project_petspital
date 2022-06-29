package com.lec.petspitalDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.petspitalDto.FileboardDto;

public class FileboardDao {

	
	public static final int SUCCESS = 1;
	public static final int FAIL = 1;
	
	private DataSource ds;
	
	private FileboardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static FileboardDao instance = new FileboardDao();
	public static FileboardDao getInstance() {
		return instance;
	}
	
	
	//게시판 리스트
	public ArrayList<FileboardDto> listBoard(int startRow, int endRow) {
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				"    (SELECT ROWNUM RN, A.*" + 
				"    FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID ORDER BY fGROUP DESC, FSTEP)A)" + 
				"    WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int fnum = rs.getInt("fnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String ffilename2 = rs.getString("ffilename2");
				 String ffilename3 = rs.getString("ffilename3");
				 Date frdate = rs.getDate("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep= rs.getInt("fstep");
				 int findent= rs.getInt("findent");
				 String fip = rs.getString("fip");
				
				dtos.add(new FileboardDto(fnum, mid,mname, fsubject, fcontent, ffilename, ffilename2, ffilename3, frdate, fhit, fgroup, fstep, findent, fip));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return dtos;

	}

//	--2.등록된 글 수 public int count()
//	SELECT COUNT(*) FROM FILEBOARD;
	public int countBoard() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM FILEBOARD";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return cnt;
	}
	
//	글쓰기 public 
	
	public int writeBoard(String mid, String fsubject, String fcontent, String ffilename, String ffilename2,String ffilename3, String fip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)" + 
				"    VALUES(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try { //원글쓰기는 step과 레벨 모두 0고정
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, fsubject);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setString(5, ffilename2);
			pstmt.setString(6, ffilename3);
			pstmt.setString(7, fip);
			result = pstmt.executeUpdate();
			System.out.println("원글쓰기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"원글쓰기실패");
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
		return result;
	}

//	 답변글 쓰기 전 작업 (void로)

	private void preReplyStepA(int fgroup, int fstep){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSTEP =fSTEP +1 WHERE fGROUP = ? AND fSTEP > ?";
		
		try { //원글쓰기는 step과 레벨 모두 0고정
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			
			 int result = pstmt.executeUpdate();
			System.out.println(result == 0? "첫답변" : result +"행 스탭 조정");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
	}
	
	
//	답변글 쓰기
	public int replyBoard (String mid, String fsubject, String fcontent, String ffilename, String ffilename2, String ffilename3, int fgroup, int fstep, int findent, String fip){
		
		preReplyStepA(fgroup, fstep); //답변글 전에 fstep조정
		int result =FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FILEBOARD (fNUM, MID,  fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)" + 
				"    VALUES(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, mid);
			pstmt.setString(2, fsubject);
			pstmt.setString(3, fcontent);
			pstmt.setString(4, ffilename);
			pstmt.setString(5, ffilename2);
			pstmt.setString(6, ffilename3);
			pstmt.setInt(7, fgroup);
			pstmt.setInt(8, fstep+1); 
			pstmt.setInt(9, findent+1);
			pstmt.setString(10, fip);
			result = pstmt.executeUpdate();
			System.out.println("답변글쓰기 성공");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()+"답변글쓰기 실패");
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
		return result;
		
		
	}
	
	//글 수정하기 
	public int modifyBoard(int fnum, String fsubject, String fcontent, String ffilename, String ffilename2, String ffilename3, String fip){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSUBJECT=?," + 
				"              FCONTENT=?," + 
				"                FFILENAME =?," + 
				"                fFILENAME2 = ?," + 
				"                fFILENAME3 = ?," + 
				"                fRDATE = SYSDATE, " + 
				"                fIP = ? " + 
				"               WHERE fNUM= ?  ";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fsubject);
			pstmt.setString(2, fcontent);
			pstmt.setString(3, ffilename);
			pstmt.setString(4, ffilename2);
			pstmt.setString(5, ffilename3);
			pstmt.setString(6, fip);
			pstmt.setInt(7, fnum);
			result = pstmt.executeUpdate();
			System.out.println(result ==SUCCESS ? "수정 성공" : "수정실패");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
		return result;
		
	
	}
	
//	글 삭제하기

	
	public int deleteBoard(int fnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FNUM =?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			result = pstmt.executeUpdate();
			System.out.println("삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"삭제실패");
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
		return result;
		
	}

	//조회수 올리기 

	
	private void hitUp(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
	}
	
	
//	상세보기(FNUM으로 DTO가져오기) 상세보기 + 조회수 높이기
	
	public FileboardDto getBoard(int fnum){
		hitUp(fnum);
		FileboardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String ffilename2 = rs.getString("ffilename2");
				 String ffilename3 = rs.getString("ffilename3");
				 Date frdate = rs.getDate("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep= rs.getInt("fstep");
				 int findent= rs.getInt("findent");
				 String fip = rs.getString("fip");
				dto = new FileboardDto(fnum, mid, mname, fsubject, fcontent, ffilename, ffilename2, ffilename3, frdate, fhit, fgroup, fstep, findent, fip);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return dto;
		
	}

	
	//답변글 달기, 수정하기를 위한 글번호로 dto불러오기
	
	public FileboardDto reply_modifyView(int fnum){
		FileboardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String fsubject = rs.getString("fsubject");
				 String fcontent = rs.getString("fcontent");
				 String ffilename = rs.getString("ffilename");
				 String ffilename2 = rs.getString("ffilename2");
				 String ffilename3 = rs.getString("ffilename3");
				 Date frdate = rs.getDate("frdate");
				 int fhit = rs.getInt("fhit");
				 int fgroup = rs.getInt("fgroup");
				 int fstep= rs.getInt("fstep");
				 int findent= rs.getInt("findent");
				 String fip = rs.getString("fip");
				dto = new FileboardDto(fnum, mid, mname, fsubject, fcontent, ffilename, ffilename2, ffilename3, frdate, fhit, fgroup, fstep, findent, fip);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return dto;
		
	}

//회원 탈퇴를 위한 글 강제 삭제
	public void withdrawDeleteBoard(int mid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID =?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			pstmt.executeUpdate();
			System.out.println("게시판 글 강제 삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"게시판 글 강제 삭제실패");
		} finally {
			
				try {
					if(pstmt!=null)
					pstmt.close();
					if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
		}
		

	}
}
