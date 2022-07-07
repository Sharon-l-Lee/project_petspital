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
	
	
	//
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

//	--2. public int count()
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
	
//	
	
	public int writeBoard(String mid, String fsubject, String fcontent, String ffilename, String ffilename2,String ffilename3, String fip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)" + 
				"    VALUES(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, FILEBOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try { //占쏙옙占쌜억옙占쏙옙占� step占쏙옙 占쏙옙占쏙옙 占쏙옙占� 0占쏙옙占쏙옙
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
			System.out.println("占쏙옙占쌜억옙占쏙옙 占쏙옙占쏙옙");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"占쏙옙占쌜억옙占쏙옙占쏙옙占�");
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

//	

	private void preReplyStepA(int fgroup, int fstep){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET fSTEP =fSTEP +1 WHERE fGROUP = ? AND fSTEP > ?";
		
		try { //
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fgroup);
			pstmt.setInt(2, fstep);
			
			 int result = pstmt.executeUpdate();
			System.out.println(result == 0? "첫占썰변" : result +"占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙");
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
	
	
//	
	public int replyBoard (String mid, String fsubject, String fcontent, String ffilename, String ffilename2, String ffilename3, int fgroup, int fstep, int findent, String fip){
		
		preReplyStepA(fgroup, fstep); //
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
			System.out.println("占썰변占쌜억옙占쏙옙 占쏙옙占쏙옙");
		} catch (SQLException e) {
			
			System.out.println(e.getMessage()+"占썰변占쌜억옙占쏙옙 占쏙옙占쏙옙");
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
	
	// 
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
			System.out.println(result ==SUCCESS ? "占쏙옙占쏙옙 占쏙옙占쏙옙" : "占쏙옙占쏙옙占쏙옙占쏙옙");
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
	
//	

	//관리자 삭제
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
			System.out.println("");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"");
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

	//占쏙옙회占쏙옙 占시몌옙占쏙옙 

	
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
	
	
//	占쏢세븝옙占쏙옙(FNUM占쏙옙占쏙옙 DTO占쏙옙占쏙옙占쏙옙占쏙옙) 占쏢세븝옙占쏙옙 + 占쏙옙회占쏙옙 占쏙옙占싱깍옙
	
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

	
	//占썰변占쏙옙 占쌨깍옙, 占쏙옙占쏙옙占싹기를 占쏙옙占쏙옙 占쌜뱄옙호占쏙옙 dto占쌀뤄옙占쏙옙占쏙옙
	
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

//회占쏙옙 탈占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
	public void withdrawDeleteBoard(int mid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE MID =?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			pstmt.executeUpdate();
			System.out.println("占쌉쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"占쌉쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙");
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
	
	//SELECT * 
//    FROM(SELECT ROWNUM RN, A.*
//            FROM(SELECT * FROM FILEBOARD WHERE MID='aaa' order by frdate desc)A)
//       WHERE RN BETWEEN  1 AND 10
	
	public ArrayList<FileboardDto> listMyFboard(String mid, int startRow, int endRow) {
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM RN, A.*" + 
				"         FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND M.MID= ? order by frdate desc)A)" + 
				"    WHERE RN BETWEEN  ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int fnum = rs.getInt("fnum");
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
	//占쏙옙 占쏙옙 占쏙옙占쏙옙
	//SELECT COUNT(*) FROM FILEBOARD WHERE MID='aaa';
	
	public int countMyBoard(String mid) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM FILEBOARD WHERE MID= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
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
	
	//寃��깋
	
	public ArrayList<FileboardDto> searchList(String fsubject, int startRow, int endRow) {
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM RN, A.* " + 
				"        FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fSUBJECT LIKE '%'||?||'%' ORDER BY fGROUP DESC, FSTEP)A)" + 
				"				WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fsubject);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int fnum = rs.getInt("fnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 fsubject = rs.getNString("fsubject");
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
	
	//寃��깋�맂 湲� 媛��닔
	public int countSearch(String fsubject) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM FILEBOARD WHERE fSUBJECT LIKE '%'||?||'%'";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fsubject);
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
	
	//�깉�눜�슜 湲��궘�젣
			public void withdrawfb(String mid){
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql = "DELETE FROM FILEBOARD WHERE MID =?";
				
				try { 
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mid);;
					pstmt.executeUpdate();
					System.out.println("�옄�쑀寃뚯떆�뙋 湲� 媛뺤젣 �궘�젣 �꽦怨�");
				} catch (SQLException e) {
					System.out.println(e.getMessage()+"�옄�쑀寃뚯떆�뙋 湲� 媛뺤젣 �궘�젣 �떎�뙣");
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
