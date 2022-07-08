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

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL = 0;
	public static final int MEMBER_NONEXIST = 1;
	public static final int MEMBER_EXIST = 0;

	private DataSource ds;

	private MemberDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	//  SELECT * FROM MEMBER WHERE mID ='aaa' AND mPW ='111';
	public int memberLogin(String mid, String mpw) {
		int result = LOGIN_FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID= ?  AND mPW= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = LOGIN_SUCCESS;
			} else {
				result = LOGIN_FAIL;
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

		return result;
	}

	//  SELECT * FROM MEMBER WHERE mID='aaa';
	public int idCheck(String mid) {
		int result = MEMBER_EXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = MEMBER_EXIST;
			} else {
				result = MEMBER_NONEXIST;
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

		return result;
	}

	//  체크 SELECT * FROM MEMBER WHERE mEMAIL ='aaa@naver.com';

	public int emailCheck(String memail) {
		int result = MEMBER_EXIST;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mEMAIL = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = MEMBER_EXIST;
			} else {
				result = MEMBER_NONEXIST;
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

		return result;
	}

//	 SELECT * FROM MEMBER WHERE mID ='aaa';
	public MemberDto idDto(String mid) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE mID= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				Date mbirth = rs.getDate("mbirth");
				String mgender = rs.getString("mgender");
				String memail = rs.getString("memail");
				String mphone = rs.getString("mphone");
				String maddress = rs.getString("maddress");
				String maddress2 = rs.getString("maddress2");
				int mgrade = rs.getInt("mgrade");
				Date mrdate = rs.getDate("mrdate");
				dto = new MemberDto(mid, mpw, mname, mbirth, mgender, memail, mphone, maddress, maddress2, mgrade,
						mrdate);

			}
			System.out.println("id占쏙옙 占쏙옙占쏙옙占쏙옙 dto : " + dto);
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
	// INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,
	// mADDRESS, mADDRESS2)
	// VALUES ('aaa', '111', '', '95/01/01', 'M','bunny@naver.com',
	// '010-0000-1111', '', '') ;

	public int joinMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)"
				+ "	   VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setDate(4, member.getMbirth());
			pstmt.setString(5, member.getMgender());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getMphone());
			pstmt.setString(8, member.getMaddress());
			pstmt.setString(9, member.getMaddress2());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "가입 성공" : "가입실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

//		   
//       UPDATE MEMBER SET mPW='1111',
//       	 mNAME='',
//      	  mEMAIL='bny@naver.com',
//      	  mBIRTH='88/01/01',
//      	  mGENDER='F',
//       	 mPHONE='010-0101-0101',
//        	mADDRESS='',
//      	  mADDRESS2=''
//      	  WHERE mID='aaa';

	public int modifyMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "    UPDATE MEMBER SET mPW= ?," 
				+ "                mNAME=?," 
				+ "                mEMAIL=?,"
				+ "                mBIRTH=?," 
				+ "                mGENDER=?," 
				+ "                mPHONE=?,"
				+ "                mADDRESS=?,"
				+ "                mADDRESS2=?" 
				+ "                WHERE mID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMpw());
			pstmt.setString(2, member.getMname());
			pstmt.setString(3, member.getMemail());
			pstmt.setDate(4, member.getMbirth());
			pstmt.setString(5, member.getMgender());
			pstmt.setString(6, member.getMphone());
			pstmt.setString(7, member.getMaddress());
			pstmt.setString(8, member.getMaddress2());
			pstmt.setString(9, member.getMid());
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "정보 수정 성공" : "정보수정실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

	// 
	// SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER)M)
	// WHERE RN BETWEEN 1 AND 10
	// ORDER BY mGRADE DESC, mRDATE ;

	public ArrayList<MemberDto> listMember(int startRow, int endRow) {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER ORDER BY mGRADE DESC, mRDATE)M)" + 
				"    WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				Date mbirth = rs.getDate("mbirth");
				String mgender = rs.getString("mgender");
				String memail = rs.getString("memail");
				String mphone = rs.getString("mphone");
				String maddress = rs.getString("maddress");
				String maddress2 = rs.getString("maddress2");
				int mgrade = rs.getInt("mgrade");
				Date mrdate = rs.getDate("mrdate");
				dtos.add(new MemberDto(mid, mpw, mname, mbirth, mgender, memail, mphone, maddress, maddress2, mgrade, mrdate));
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


//		 SELECT COUNT(*) CNT FROM MEMBER;
	public int memberCnt() {
		int totalCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MEMBER ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalCnt = rs.getInt("CNT");

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

		return totalCnt;
	}
	
	
	//회占쏙옙 탈占쏙옙 DELETE FROM MEMBER WHERE MID = 'NNN';
	


	public int deleteMember(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE MID = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "멤버 삭제 성공" : "멤버삭제실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
	
	// UPDATE MEMBER SET mGRADE='2' WHERE mID='aaa';
	
	public int gradeUp(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET mGRADE='2' WHERE mID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "등급 업 성공" : "등급 업 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
    
	//
	public int gradeDown(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET mGRADE='1' WHERE mID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "등급 다운 성공" : "등급 다운 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}
    

	//
	
	public ArrayList<MemberDto> memberList(int startRow, int endRow) {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				"    (SELECT ROWNUM RN, M.* FROM" + 
				"        (SELECT MID, MNAME, MBIRTH, MEMAIL, MPHONE, MGRADE, MRDATE FROM MEMBER ORDER BY mRDATE DESC)M)" + 
				"             WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				Date mbirth = rs.getDate("mbirth");
				String memail = rs.getString("memail");
				String mphone = rs.getString("mphone");
				int mgrade = rs.getInt("mgrade");
				Date mrdate = rs.getDate("mrdate");
				dtos.add(new MemberDto(mid, mname, mbirth,  memail, mphone,mgrade, mrdate));
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
	
	public int withdrawal(String mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE MID = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "회원 탈퇴 성공" : "회원 탈퇴 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;

	}
	
	
	public String idFind(String memail) {
		String fmid = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MID FROM MEMBER WHERE MEMAIL= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				fmid = rs.getString("mid");
		
				

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

		return fmid;
	}
	
	public String pwFind(String memail) {
		String fmpw = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT MPW FROM MEMBER WHERE MEMAIL= ? ";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				fmpw = rs.getString("mpw");
		
				

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

		return fmpw;
	}
	
}
