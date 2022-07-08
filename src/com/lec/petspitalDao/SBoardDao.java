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

import com.lec.petspitalDto.MemberDto;
import com.lec.petspitalDto.RhospitalDto;
import com.lec.petspitalDto.SBoardDto;

public class SBoardDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private DataSource ds;

	private SBoardDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static SBoardDao instance = new SBoardDao();

	public static SBoardDao getInstance() {
		return instance;
	}
	
//	
//	SELECT * FROM SYBOARD WHERE sCATEGORYNAME='1';
	
	public ArrayList<SBoardDto> listSboard() {
		ArrayList<SBoardDto> dtos = new ArrayList<SBoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT S.*, sCATEGORYNAME FROM SYBOARD S, SCATEGORY C WHERE S.sCATEGORYID = C.sCATEGORYID";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int snum = rs.getInt("snum");
				 String aid = rs.getString("aid");
				 int scategoryid = rs.getInt("scategoryid");
				 String scategoryname = rs.getString("scategoryname");
				 String ssubject = rs.getString("ssubject");
				 String scontent = rs.getString("scontent");
				dtos.add(new SBoardDto(snum, aid, scategoryid, scategoryname, ssubject, scontent));
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
//
// sCATEGORYNAME FROM SCATEGORY;
////
//	INSERT INTO SYBOARD (sNUM, sCATEGORYID, aID, sSUBJECT, sCONTENT)
//    VALUES (SYB_SEQ.NEXTVAL, 1,'admin1','');
//	    

	public int writeSboard(int scategoryid, String aid, String ssubject, String scontent ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO SYBOARD (sNUM, sCATEGORYID, aID, sSUBJECT, sCONTENT)" + 
				"    VALUES (SYB_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scategoryid);
			pstmt.setString(2, aid);
			pstmt.setString(3, ssubject);
			pstmt.setString(4, scontent);
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
//	DELETE FROM SYBOARD WHERE sNUM ='1';
//
	

	public int deleteSBoard(int snum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM SYBOARD WHERE sNUM = ? ";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
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
//	UPDATE SYBOARD SET sCATEGORYID = 2,
//	                sSUBJECT ='',
//	                sCONTENT=''
//	                WHERE sNUM = '1';
	

	public int modifySBoard(int scategoryid, String ssubject, String scontent, int snum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE SYBOARD SET sCATEGORYID = ?," + 
				"	                sSUBJECT = ?," + 
				"	                sCONTENT= ?" + 
				"	                WHERE sNUM = ?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scategoryid);
			pstmt.setString(2, ssubject);
			pstmt.setString(3, scontent);
			pstmt.setInt(4, snum);
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
	
	
	public SBoardDto numDto(int snum) {
		SBoardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT S.*, sCATEGORYNAME FROM SYBOARD S, SCATEGORY C WHERE S.sCATEGORYID = C.sCATEGORYID AND SNUM=? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				 String aid = rs.getString("aid");
				 int scategoryid = rs.getInt("scategoryid");
				 String scategoryname = rs.getString("scategoryname");
				 String ssubject = rs.getString("ssubject");
				 String scontent = rs.getString("scontent");
				dto = new SBoardDto(snum, aid, scategoryid, scategoryname, ssubject, scontent);

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
