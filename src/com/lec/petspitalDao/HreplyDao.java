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

import com.lec.petspitalDto.FreplyDto;
import com.lec.petspitalDto.HreplyDto;

public class HreplyDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private DataSource ds;

	private HreplyDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static HreplyDao instance = new HreplyDao();

	public static HreplyDao getInstance() {
		return instance;
	}
	
	
	
	
//	--병원 글 댓글 쓰기
//	INSERT INTO HREPLY(hNUM, rNUM, mID, aId, hCONTENT , hRDATE , hIP ) VALUES(HREPLY_SEQ.NEXTVAL, 2, 'bbb',null, '댓글 확인',SYSDATE, '127.10.25' );
	public int writehComment(int rnum, String mid, String aid, String hcontent, int hrating, String hip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		String sql = "INSERT INTO HREPLY(hNUM, rNUM, mID, aId, hCONTENT ,hRATING, hRDATE , hIP ) VALUES(HREPLY_SEQ.NEXTVAL, ?,  ? , ? , ? , ?, SYSDATE, ? )";
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rnum);
			pstmt.setString(2, mid);
			pstmt.setString(3, aid);
			pstmt.setString(4, hcontent);
			pstmt.setInt(5, hrating);
			pstmt.setString(6, hip);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS ? "병원 댓글 쓰기 성공" : "병원 댓글 쓰기 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"병원 댓글 쓰기 실패");
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
	
	//	--병원 글 댓글 출력
//	SELECT * 
//	    FROM(SELECT ROWNUM RN, A.* 
//	        FROM (SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT,hRDATE, hIP FROM HREPLY H where rNUM=2 order by hNUM desc)A)
//					WHERE rn between 1 and 10;
	
	public ArrayList<HreplyDto> listhComment(int rnum, int startRow, int endRow) {
		ArrayList<HreplyDto> dtos = new ArrayList<HreplyDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * " + 
				"	    FROM(SELECT ROWNUM RN, A.* " + 
				"	        FROM (SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT, hRATING, hRDATE, hIP FROM HREPLY H where rNUM=? order by hNUM desc)A)" + 
				"					WHERE rn between ? and ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int hnum = rs.getInt("hnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String hcontent = rs.getString("hcontent");
				 int hrating = rs.getInt("hrating");
				 Date hrdate = rs.getDate("hrdate");
				 String hip = rs.getString("hip");
				
				dtos.add(new HreplyDto(hnum, rnum, mid, mname, hcontent, hrating, hrdate, hip));
				
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
//	--댓글 갯수
//	SELECT COUNT(*) FROM HREPLY;
	
	public int counthComment() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM HREPLY";

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
//	--글에 댓글 수
//	SELECT COUNT(*)CNT FROM HREPLY WHERE rNUM='2';
//
//	--병원 댓글 수정
//	UPDATE HREPLY SET hCONTENT= '댓글확인수정' WHERE hNUM=1;
	
	public int modifyhComment(String hcontent, int hnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE HREPLY SET hCONTENT= ? WHERE hNUM=? ";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hcontent);
			pstmt.setInt(2, hnum);
			result = pstmt.executeUpdate();
			System.out.println(result ==SUCCESS ? "병원 댓글 수정" : "병원 댓글 수정");
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
//	--댓글 삭제
//	DELETE FROM HREPLY WHERE hNUM='2'; 
//
	public int deletehComment(int hnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM HREPLY WHERE hNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hnum);
			result = pstmt.executeUpdate();
			System.out.println("병원 댓글 삭제 성공");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"병원 댓글 삭제 실패");
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
//	--병원 댓글 dto
//	SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT,hRDATE, hIP FROM HREPLY H where rNUM=2;
	public HreplyDto gethComment(int rnum){
		HreplyDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT,hRDATE, hIP FROM HREPLY H where rNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int hnum = rs.getInt("hnum");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String hcontent = rs.getString("hcontent");
				 int hrating = rs.getInt("hrating");
				 Date hrdate = rs.getDate("hrdate");
				 String hip = rs.getString("hip");
				dto = new HreplyDto(hnum, rnum, mid, mname, hcontent, hrating, hrdate, hip);
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

}
