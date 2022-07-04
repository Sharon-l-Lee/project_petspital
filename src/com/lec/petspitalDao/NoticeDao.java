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

import com.lec.petspitalDto.NoticeDto;
import com.lec.petspitalDto.RhospitalDto;

public class NoticeDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 1;
	
	private DataSource ds;
	
	private NoticeDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;
	}
	
	
//	
//	--�������� �Խ��� ����Ʈ
//	SELECT * FROM 
//	        (SELECT ROWNUM RN, B.* FROM 
//	            (SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE N.AID = A.AID ORDER BY NRDATE DESC)B)
//	    WHERE RN BETWEEN 1 AND 30;
//	    
	public ArrayList<NoticeDto> listNboard(int startRow, int endRow) {
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + 
				"        (SELECT ROWNUM RN, B.* FROM " + 
				"            (SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE N.AID = A.AID ORDER BY NRDATE DESC)B)" + 
				"    WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				 int nnum  = rs.getInt("nnum");
				 String aid = rs.getString("aid");
				 String aname = rs.getString("aname");
				 String nsubject = rs.getString("nsubject");
				 String ncontent = rs.getString("ncontent");
				 String nfilename = rs.getString("nfilename");
				 Date nrdate = rs.getDate("nrdate");
				 int nhit = rs.getInt("nhit");
				 String nip = rs.getString("nip");
		
				dtos.add(new NoticeDto(nnum, aid, aname, nsubject, ncontent, nfilename, nrdate, nhit, nip));
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
	
	//메인용 1~4줄 공지사항
	
	public ArrayList<NoticeDto> mainListnboard() {
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + 
				"        (SELECT ROWNUM RN, B.* FROM " + 
				"            (SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE N.AID = A.AID ORDER BY NRDATE DESC)B)" + 
				"    WHERE RN BETWEEN 1 AND 4";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				 int nnum  = rs.getInt("nnum");
				 String aid = rs.getString("aid");
				 String aname = rs.getString("aname");
				 String nsubject = rs.getString("nsubject");
				 String ncontent = rs.getString("ncontent");
				 String nfilename = rs.getString("nfilename");
				 Date nrdate = rs.getDate("nrdate");
				 int nhit = rs.getInt("nhit");
				 String nip = rs.getString("nip");
		
				dtos.add(new NoticeDto(nnum, aid, aname, nsubject, ncontent, nfilename, nrdate, nhit, nip));
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
//	--�������� �Խ��� �۾���
//	INSERT INTO NOTICE (nNUM, aID, nSUBJECT, nCONTENT, nFILENAME, nIP)
//	    VALUES(NOTICE_SEQ.NEXTVAL, 'admin1', '��1', '��1�Դϴ�', 'noImg.png', '127.10.26');
//
	public int writeNboard(String aid, String nsubject, String ncontent, String nfilename, String nip ) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO NOTICE (nNUM, aID, nSUBJECT, nCONTENT, nFILENAME, nIP)" + 
				"    VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try { //���۾���� step�� ���� ��� 0����
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.setString(2, nsubject);
			pstmt.setString(3, ncontent);
			pstmt.setString(4, nfilename);
			pstmt.setString(5, nip);
			result = pstmt.executeUpdate();
			System.out.println("���� �۾��� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"���� �۾������");
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
	
//	--�������� �Խ��� ����
//	UPDATE NOTICE SET nSUBJECT ='��1(����)',
//	                nCONTENT='��1(����)�Դϴ�',
//	                nFILENAME='noImg.png'
//	                WHERE nNUM ='1';
	public int modifyNBoard(String nsubject, String ncontent, String nfilename, int nnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NOTICE SET nSUBJECT = ?," + 
				"                nCONTENT= ?," + 
				"                nFILENAME= ?" + 
				"                WHERE nNUM =? ";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nsubject);
			pstmt.setString(2, ncontent);
			pstmt.setString(3, nfilename);
			pstmt.setInt(4, nnum);
			result = pstmt.executeUpdate();
			System.out.println(result ==SUCCESS ? "���� ���� ����" : "���� ��������");
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
	
//	--�������� ��ȸ�� �ø���
//	UPDATE NOTICE SET nHIT = nHIT+1
//	                WHERE nNUM='1';
	
	private void hitUp(int nnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE NOTICE SET nHIT = nHIT+1" + 
				"	                WHERE nNUM=?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
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
//	                
//	--�������� �� �����
//	DELETE FROM NOTICE WHERE nNUM='1';
//
	public int deleteNBoard(int nnum){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM NOTICE WHERE nNUM= ?";
		
		try { 
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
			result = pstmt.executeUpdate();
			System.out.println("���� ���� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"���� ��������");
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
	
	//�� ����
	

	public int countNboard() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT COUNT(*) FROM NOTICE";

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
	
//	--�� ��ȣ�� dto�������� (��ȸ�� up)
//	SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE A.AID = N.AID AND NNUM=1;
	public NoticeDto getnBoard(int nnum){
		hitUp(nnum);
		NoticeDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE A.AID = N.AID AND NNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 
				
				 String nsubject = rs.getString("nsubject");
				 String ncontent = rs.getString("ncontent");
				 String nfilename = rs.getString("nfilename");
				 Date nrdate = rs.getDate("nrdate");
				 int nhit = rs.getInt("nhit");
				 String nip = rs.getString("nip");
				dto =  new NoticeDto(nnum, nsubject, ncontent, nfilename, nrdate, nhit, nip);
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
	
//	--�� ��ȣ�� dto �������� (������)
//	SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE A.AID = N.AID AND NNUM=1;
	public NoticeDto getnBoardModify(int nnum){
		NoticeDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT N.*, ANAME FROM NOTICE N, ADMIN A WHERE A.AID = N.AID AND NNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 
				 String aid = rs.getString("aid");
				 String aname = rs.getString("aname");
				 String nsubject = rs.getString("nsubject");
				 String ncontent = rs.getString("ncontent");
				 String nfilename = rs.getString("nfilename");
				 Date nrdate = rs.getDate("nrdate");
				 int nhit = rs.getInt("nhit");
				 String nip = rs.getString("nip");
				dto =  new NoticeDto(nnum, aid, aname, nsubject, ncontent, nfilename, nrdate, nhit, nip);
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
