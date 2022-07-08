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
import com.lec.petspitalDto.FreplyDto;

public class FreplyDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 1;
	
	private DataSource ds;
	
	private FreplyDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static FreplyDao instance = new FreplyDao();
	public static FreplyDao getInstance() {
		return instance;
	}
	
	
	public ArrayList<FreplyDto> listComment(int fnum, int startRow, int endRow) {
		ArrayList<FreplyDto> dtos = new ArrayList<FreplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"    FROM(SELECT ROWNUM RN, A.* " + 
				"        FROM (SELECT FRNUM, FNUM, MID, nvl((select mname from member where mid=f.mid),'������') mname,FRCONTENT,FRRDATE, FRIP FROM FREPLY F where fnum=? order by frnum desc)A)" + 
				"				WHERE RN between ? and ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int frnum = rs.getInt("frnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String frcontent = rs.getString("frcontent");
				 Date frrdate = rs.getDate("frrdate");
				 String frip = rs.getString("frip");
				
				dtos.add(new FreplyDto(frnum, fnum, mid, mname, frcontent, frrdate, frip));
				
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
	
//	--��� �Է�
//	INSERT INTO FREPLY(fRNUM, fNUM, mID,fRCONTENT, FRDATE, FRIP ) VALUES(FREPLY_SEQ.NEXTVAL, 16, 'aaa', '��� Ȯ��',SYSDATE, '127.10.25' );
	public int writeComment(int fnum, String mid, String aid, String frcontent, String frip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FREPLY(fRNUM, fNUM, mID, aId, fRCONTENT, FRRDATE, FRIP ) "
				+ "			VALUES(FREPLY_SEQ.NEXTVAL, ?, ?, ?, ?,SYSDATE, ? )";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, fnum);
			pstmt.setString(2, mid);
			pstmt.setString(3, aid);
			pstmt.setString(4, frcontent);
			pstmt.setString(5, frip);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "댓글 쓰기 성공" : "댓글쓰기 실패");
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
//	UPDATE FREPLY SET fRCONTENT=  WHERE fRNUM=1;
	public int modifyComment(String frcontent, int frnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FREPLY SET fRCONTENT= ? WHERE fRNUM=? ";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, frcontent);
			pstmt.setInt(2, frnum);
			result = pstmt.executeUpdate();
			System.out.println(result ==SUCCESS ? "댓글 수정 성공" : "댓글 수정 실패");
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
//	DELETE FROM FREPLY WHERE fRNUM='2';
	
	public int deleteComment(int frnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FREPLY WHERE fRNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, frnum);
			result = pstmt.executeUpdate();
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
	//SELECT COUNT(*)CNT FROM FREPLY;
	
	public int countComment() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM FREPLY";

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
	
	public FreplyDto getComment(int frnum){
		FreplyDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT FRNUM, FNUM, M.MID, MNAME, FRCONTENT, FRRDATE, FRIP FROM FREPLY F, MEMBER M WHERE F.MID=M.MID AND FNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, frnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int fnum = rs.getInt("fnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String frcontent = rs.getString("frcontent");
				 Date frrdate = rs.getDate("frrdate");
				 String frip = rs.getString("frip");
				dto = new FreplyDto(frnum, fnum, mid, mname, frcontent, frrdate, frip);
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
	
	//탈퇴용 글삭제 DELETE FROM FREPLY WHERE MID ='7';
	public void withdrawfr(String mid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FREPLY WHERE MID = ?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);;
			pstmt.executeUpdate();
			System.out.println("자유게시판 댓글 강제 삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"자유게시판 댓글 강제 삭제 실패");
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
