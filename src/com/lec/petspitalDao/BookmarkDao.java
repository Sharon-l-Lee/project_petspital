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

import com.lec.petspitalDto.BookmarkDto;
import com.lec.petspitalDto.FileboardDto;
import com.lec.petspitalDto.RhospitalDto;

public class BookmarkDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private DataSource ds;

	private BookmarkDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static BookmarkDao instance = new BookmarkDao();

	public static BookmarkDao getInstance() {
		return instance;
	}
	
	
	
//	--북마크 넣기
//	INSERT INTO BOOKMARK (bNUM, rNUM, mID) VALUES (BMARK_SEQ.NEXTVAL, 4, 'aaa');
//
	
	public int bookMarkIn(int rnum, String mid, String aid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOOKMARK (bNUM, rNUM, mID, aID) VALUES (BMARK_SEQ.NEXTVAL, ?, ?, ?)";
		
		try { //���۾���� step�� ���� ��� 0����
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, mid);
			pstmt.setString(3, aid);
			result = pstmt.executeUpdate();
			System.out.println("북마크 완료");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"북마킹 실패");
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
//	--북마크 지우기
//	DELETE BOOKMARK WHERE rNUM= 1 AND mID = 'aaa';
//
	
	public int deleteBookmark(int rnum, String mid){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE BOOKMARK WHERE rNUM= ? AND mID = ?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, mid);
			result = pstmt.executeUpdate();
			System.out.println("북마크 지우기 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"북마킹 해제 실패");
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
//	--북마크 보기
//	SELECT * FROM BOOKMARK WHERE rnum=4 and mID='aaa';
	
	public BookmarkDto getBookmark(String mid){
		BookmarkDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT * FROM BOOKMARK WHERE mID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 int bnum = rs.getInt("bnum");
				dto =  new BookmarkDto(bnum, mid);
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
//
//	--북마크 갯수
//	SELECT  COUNT(*) FROM BOOKMARK WHERE rNUM=4 AND mID='aaa';
	public int countBookmark(String mid) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM BOOKMARK WHERE mID=?";

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
	
	//북마크 여부
	
	public int doBookmark(int rnum, String mid) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM BOOKMARK WHERE rNUM=? AND mID=?";

		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setString(2, mid);
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
	
	//북마크 리스트
	
	
	//탈퇴용 북마크 삭제
	
	//탈퇴용 글삭제
	public int withdrawbm(String mid){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOOKMARK WHERE MID = ?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);;
			result = pstmt.executeUpdate();
			System.out.println("북마크 강제 삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"북마크 글 강제 삭제 실패");
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
	
	
}
