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

import com.lec.petspitalDto.QnaDto;

public class QnaDao {

	public static final int SUCCESS = 1;
	public static final int FAIL = 1;

	private DataSource ds;

	private QnaDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static QnaDao instance = new QnaDao();

	public static QnaDao getInstance() {
		return instance;
	}

	public ArrayList<QnaDto> listQnA(int startRow, int endRow) {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + "    (SELECT ROWNUM RN, A.*"
				+ "    FROM(SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.mID=M.mID ORDER BY qGROUP DESC, qSTEP)A)"
				+ "    WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int qnum = rs.getInt("qnum");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String qsubject = rs.getString("qsubject");
				String qcontent = rs.getString("qcontent");
				String qfilename = rs.getString("qfilename");
				Date qrdate = rs.getDate("qrdate");
				int qhit = rs.getInt("qhit");
				int qgroup = rs.getInt("qgroup");
				int qstep = rs.getInt("qstep");
				int qindent = rs.getInt("qindent");
				String qip = rs.getString("qip");

				dtos.add(new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent,
						qhit, qip));
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

	public ArrayList<QnaDto> listA(int qgroup, int startRow, int endRow) {
		ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + "    (SELECT ROWNUM RN, A.*"
				+ "    FROM(SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.mID=M.mID and qGroup = ? and qstep > 0 ORDER by qSTEP)A)"
				+ "    WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qgroup);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int qnum = rs.getInt("qnum");
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String qsubject = rs.getString("qsubject");
				String qcontent = rs.getString("qcontent");
				String qfilename = rs.getString("qfilename");
				Date qrdate = rs.getDate("qrdate");
				int qhit = rs.getInt("qhit");
				int qstep = rs.getInt("qstep");
				int qindent = rs.getInt("qindent");
				String qip = rs.getString("qip");

				dtos.add(new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent,
						qhit, qip));
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

//		SELECT COUNT(*) FROM FILEBOARD;
	public int countQnA() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA";

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

	public int writeQ(String mid, String qsubject, String qcontent, String qfilename, String qip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) "
				+ "    VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, QNA_SEQ.CURRVAL, 0, 0, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, qsubject);
			pstmt.setString(3, qcontent);
			pstmt.setString(4, qfilename);
			pstmt.setString(5, qip);
			result = pstmt.executeUpdate();
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

	private void preReply(int qgroup, int qstep) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE QNA SET qSTEP =qSTEP +1 WHERE qGROUP = ? AND qSTEP > ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qgroup);
			pstmt.setInt(2, qstep);

			int result = pstmt.executeUpdate();
			System.out.println(result == 0 ? "답글 전" : result + "답글 전 실패");
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
	}

	public int replyA(String mid, String qsubject, String qcontent, String qfilename, int qgroup, int qstep,
			int qindent, String qip) {

		preReply(qgroup, qstep);
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) "
				+ "    VALUES (QNA_SEQ.NEXTVAL, ? , ?, ?, ?, SYSDATE, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mid);
			pstmt.setString(2, qsubject);
			pstmt.setString(3, qcontent);
			pstmt.setString(4, qfilename);
			pstmt.setInt(5, qgroup);
			pstmt.setInt(6, qstep + 1);
			pstmt.setInt(7, qindent + 1);
			pstmt.setString(8, qip);
			result = pstmt.executeUpdate();
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
	public int modifyQNA(int qnum, String qsubject, String qcontent, String qfilename, String qip) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE QNA SET qSUBJECT= ?," + "                qCONTENT= ?," + "                qIP= ?,"
				+ "                qFILENAME = ?," + "                qRDATE = SYSDATE"
				+ "                WHERE qNUM= ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qsubject);
			pstmt.setString(2, qcontent);
			pstmt.setString(3, qfilename);
			pstmt.setString(4, qip);
			pstmt.setInt(5, qnum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "QNA수정" : "QNA수정실패");
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

	public int deleteQ(int qnum, int qgroup) {
		predeleteA(qgroup);
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM QNA WHERE QNUM =? AND QGROUP = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			pstmt.setInt(2, qgroup);
			result = pstmt.executeUpdate();
			System.out.println("질문 삭제");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "질문 삭제 실패");
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

	private void predeleteA(int qgroup) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM QNA WHERE qGROUP=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qgroup);
			pstmt.executeUpdate();

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
	}

	public int deleteA(int qnum) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM QNA WHERE QNUM =?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			result = pstmt.executeUpdate();
			System.out.println("답변 삭제");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "답변 삭제 실패");
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

	private void hitUp(int qnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE QNA SET qHIT = qHIT+1 WHERE qNUM= ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			pstmt.executeUpdate();

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
	}

//	

	public QnaDto getQna(int qnum) {
		hitUp(qnum);
		QnaDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM= ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String qsubject = rs.getString("qsubject");
				String qcontent = rs.getString("qcontent");
				String qfilename = rs.getString("qfilename");
				Date qrdate = rs.getDate("qrdate");
				int qhit = rs.getInt("qhit");
				int qgroup = rs.getInt("qgroup");
				int qstep = rs.getInt("qstep");
				int qindent = rs.getInt("qindent");
				String qip = rs.getString("qip");

				dto = new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit,
						qip);
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

	public QnaDto reply_modifyView(int qnum) {
		QnaDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM= ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String qsubject = rs.getString("qsubject");
				String qcontent = rs.getString("qcontent");
				String qfilename = rs.getString("qfilename");
				Date qrdate = rs.getDate("qrdate");
				int qhit = rs.getInt("qhit");
				int qgroup = rs.getInt("qgroup");
				int qstep = rs.getInt("qstep");
				int qindent = rs.getInt("qindent");
				String qip = rs.getString("qip");
				dto = new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit,
						qip);
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

	// SELECT COUNT(*) FROM QNA WHERE qGROUP = 5;
	public int countA(int qgroup) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM QNA WHERE qGROUP = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qgroup);
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

}
