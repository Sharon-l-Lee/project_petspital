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

public class RhospitalDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private DataSource ds;

	private RhospitalDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static RhospitalDao instance = new RhospitalDao();

	public static RhospitalDao getInstance() {
		return instance;
	}
	
//	SELECT * FROM
//	    (SELECT ROWNUM RN, A.*
//	    FROM(SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.mID=M.mID)A)
//	    WHERE RN BETWEEN 1 AND 30 ;
	
	public ArrayList<RhospitalDto> listHboard(String rcategoryname,int startRow, int endRow) {
		ArrayList<RhospitalDto> dtos = new ArrayList<RhospitalDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				"    (SELECT ROWNUM RN, A.*" + 
				"        FROM(SELECT R.*, RCATEGORYNAME, MNAME FROM RHOSPITAL R, MEMBER M, RCATEGORY C " + 
				"           WHERE R.mID=M.mID AND C.RCATEGORYID=r.RCATEGORYID and RCATEGORYNAME LIKE '%'||?||'%' ORDER BY RNUM DESC)A)" + 
				"                WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rcategoryname);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int rnum = rs.getInt("rnum");
				 int rcategoryid = rs.getInt("rcategoryid");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String rsubject = rs.getString("rsubject");
				 String rcontent = rs.getString("rcontent");
				 String rfilename = rs.getString("rfilename");
				 String rfilename2 = rs.getString("rfilename2");
				 String rfilename3 = rs.getString("rfilename3");
				 int rhit = rs.getInt("rhit");
				 Date rrdate = rs.getDate("rrdate");
				 String rip = rs.getString("rip");
				dtos.add(new RhospitalDto(rnum, rcategoryid,rcategoryname, mid, mname, rsubject, rcontent, rfilename, rfilename2, rfilename3, rhit, rrdate, rip));
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
	
	/*
	 * // SELECT * FROM // (SELECT ROWNUM RN, A.* // FROM(SELECT R.*, MNAME FROM
	 * RHOSPITAL R, MEMBER M WHERE R.mID=M.mID and RCATEGORYID= 1 ORDER BY RNUM
	 * DESC)A) // WHERE RN BETWEEN 1 AND 30;
	 * 
	 * public ArrayList<RhospitalDto> listHboardAni(int rcategoryid, int startRow,
	 * int endRow) { ArrayList<RhospitalDto> dtos = new ArrayList<RhospitalDto>();
	 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * String sql = "SELECT * FROM" + "  (SELECT ROWNUM RN, A.*" +
	 * "      FROM(SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.mID=M.mID and RCATEGORYID= ? ORDER BY RNUM DESC)A)"
	 * + "      WHERE RN BETWEEN ? AND ?";
	 * 
	 * try { conn = ds.getConnection(); pstmt = conn.prepareStatement(sql);
	 * pstmt.setInt(1, rcategoryid); pstmt.setInt(2, startRow); pstmt.setInt(3,
	 * endRow); rs = pstmt.executeQuery(); while (rs.next()) { int rnum =
	 * rs.getInt("rnum"); String mid = rs.getString("mid"); String mname =
	 * rs.getString("mname"); String rsubject = rs.getString("rsubject"); String
	 * rcontent = rs.getString("rcontent"); String rfilename =
	 * rs.getString("rfilename"); String rfilename2 = rs.getString("rfilename2");
	 * String rfilename3 = rs.getString("rfilename3"); int rhit = rs.getInt("rhit");
	 * Date rrdate = rs.getDate("rrdate"); String rip = rs.getString("rip");
	 * dtos.add(new RhospitalDto(rnum, rcategoryid, mid, mname, rsubject, rcontent,
	 * rfilename, rfilename2, rfilename3, rhit, rrdate, rip)); } } catch
	 * (SQLException e) { System.out.println(e.getMessage()); } finally {
	 * 
	 * try { if (rs != null) rs.close(); if (pstmt != null) pstmt.close(); if (conn
	 * != null) conn.close(); } catch (SQLException e) {
	 * System.out.println(e.getMessage());
	 * 
	 * } } return dtos;
	 * 
	 * }
	 */
	

	
	
//	INSERT INTO RHOSPITAL ( rNUM,rCATEGORYID, mID, rSUBJECT, rCONTENT,rFILENAME, rFILENAME2, rFILENAME3, rRDATE,rIP  )
//	    VALUES(RHOS_SEQ.NEXTVAL, 1, 'aaa','', '', 'noImg.png', NULL, NULL, SYSDATE, '123.10.52');

	public int writeHboard(int rcategoryid, String mid, String rsubject, String rcontent, String rfilename, String rfilename2,String rfilename3, String rip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO RHOSPITAL (rNUM,rCATEGORYID, mID, rSUBJECT, rCONTENT,rFILENAME, rFILENAME2, rFILENAME3, rRDATE, rIP  )" + 
				"	    VALUES(RHOS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rcategoryid);
			pstmt.setString(2, mid);
			pstmt.setString(3, rsubject);
			pstmt.setString(4, rcontent);
			pstmt.setString(5, rfilename);
			pstmt.setString(6, rfilename2);
			pstmt.setString(7, rfilename3);
			pstmt.setString(8, rip);
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
//	DELETE FROM RHOSPITAL WHERE rNUM=1;
	
	
	public int deleteBoard(int rnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RHOSPITAL WHERE rNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
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
//	UPDATE RHOSPITAL SET rCATEGORYID=2,
//	                    rSUBJECT='',
//	                    rCONTENT='',
//	                    rFILENAME='noImg.png',
//	                    rFILENAME2=NULL,
//	                    rFILENAME3=NULL
//	                    WHERE rNUM=1;
	
	public int modifyhBoard( int rcategoryid, String rsubject, String rcontent, String rfilename, String rfilename2, String rfilename3, String rip, int rnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RHOSPITAL SET rCATEGORYID=?," + 
				"	                 rSUBJECT=?," + 
				"                    rCONTENT=?," + 
				"	                 rFILENAME=?," + 
				"                    rFILENAME2=?," + 
				"                    rFILENAME3=?, rip=?" + 
				"                    WHERE rNUM=? ";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rcategoryid);
			pstmt.setString(2, rsubject);
			pstmt.setString(3, rcontent);
			pstmt.setString(4, rfilename);
			pstmt.setString(5, rfilename2);
			pstmt.setString(6, rfilename3);
			pstmt.setString(7, rip);
			pstmt.setInt(8, rnum);
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
	
	
	
//	UPDATE RHOSPITAL SET rHIT = rHIT+1 WHERE rNUM=1;
	

	private void hitUp(int rnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE RHOSPITAL SET rHIT = rHIT+1 WHERE rNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
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
//	SELECT COUNT(*) FROM RHOSPITAL;
//	
	
	public int countHboard() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM RHOSPITAL";

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
	
//	SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=2;
	
	
	public RhospitalDto getBoard(int rnum){
		hitUp(rnum);
		RhospitalDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 int rcategoryid = rs.getInt("rcategoryid");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String rsubject = rs.getString("rsubject");
				 String rcontent = rs.getString("rcontent");
				 String rfilename = rs.getString("rfilename");
				 String rfilename2 = rs.getString("rfilename2");
				 String rfilename3 = rs.getString("rfilename3");
				 int rhit = rs.getInt("rhit");
				 Date rrdate = rs.getDate("rrdate");
				 String rip = rs.getString("rip");
				dto =  new RhospitalDto(rnum, rcategoryid, mid, mname, rsubject, rcontent, rfilename, rfilename2, rfilename3, rhit, rrdate, rip);
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

//	SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=2;
	
	public RhospitalDto modifyView(int rnum){
		RhospitalDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 int rcategoryid = rs.getInt("rcategoryid");
				 String mid = rs.getString("mid");
				 String mname = rs.getString("mname");
				 String rsubject = rs.getString("rsubject");
				 String rcontent = rs.getString("rcontent");
				 String rfilename = rs.getString("rfilename");
				 String rfilename2 = rs.getString("rfilename2");
				 String rfilename3 = rs.getString("rfilename3");
				 int rhit = rs.getInt("rhit");
				 Date rrdate = rs.getDate("rrdate");
				 String rip = rs.getString("rip");
				dto =  new RhospitalDto(rnum, rcategoryid, mid, mname, rsubject, rcontent, rfilename, rfilename2, rfilename3, rhit, rrdate, rip);
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

	
//	DELETE FROM RHOSPITAL WHERE MID =?
	public void withdrawDeleteHboard(int mid){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RHOSPITAL WHERE MID =?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
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
	
	//북마크 리스트
		public ArrayList<RhospitalDto> listBmarkBoard(String mid, int startRow, int endRow) {
			ArrayList<RhospitalDto> dtos = new ArrayList<RhospitalDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from" + 
					"    (select rownum rn, a.* from (select b.rnum, rsubject, rrdate from bookmark b, RHOSPITAL r where b.rnum = r.rnum and b.mid = ? order by r.rnum desc)a)" + 
					"    where rn between ? and ? ";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					int rnum = rs.getInt("rnum");
					 String rsubject = rs.getString("rsubject");
					 Date rrdate = rs.getDate("rrdate");
					
					dtos.add(new RhospitalDto(rnum, mid,  rsubject, rrdate));
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
		
//탈퇴용 글삭제
		public void withdrawho(String mid){
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM RHOSPITAL WHERE MID =?";
			
			try { 
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);;
				pstmt.executeUpdate();
				System.out.println("병원 글 강제 삭제 성공");
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"병원 글 강제 삭제 실패");
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
