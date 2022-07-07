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
	
	
	//QNA異쒕젰
		public ArrayList<QnaDto> listQnA(int startRow, int endRow) {
			ArrayList<QnaDto> dtos = new ArrayList<QnaDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM" + 
					"    (SELECT ROWNUM RN, A.*" + 
					"    FROM(SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.mID=M.mID ORDER BY qGROUP DESC, qSTEP)A)" + 
					"    WHERE RN BETWEEN ? AND ?";

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
					 int qstep= rs.getInt("qstep");
					 int qindent= rs.getInt("qindent");
					 String qip = rs.getString("qip");
					 

					dtos.add(new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit, qip));
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
			String sql = "SELECT * FROM" + 
					"    (SELECT ROWNUM RN, A.*" + 
					"    FROM(SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.mID=M.mID and qGroup = ? and qstep > 0 ORDER by qSTEP)A)" + 
					"    WHERE RN BETWEEN ? AND ?";

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
					 int qstep= rs.getInt("qstep");
					 int qindent= rs.getInt("qindent");
					 String qip = rs.getString("qip");
					 

					dtos.add(new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit, qip));
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

//		湲� 媛��닔
//		SELECT COUNT(*) FROM FILEBOARD;
		public int countQnA() {
			int cnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql =  "SELECT COUNT(*) FROM QNA";

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
		
//		qna吏덈Ц�벐湲�
		
		public int writeQ(String mid, String qsubject, String qcontent, String qfilename, String qip ) {
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) " + 
					"    VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, QNA_SEQ.CURRVAL, 0, 0, ?)";
			
			try { 
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				pstmt.setString(2, qsubject);
				pstmt.setString(3, qcontent);
				pstmt.setString(4, qfilename);
				pstmt.setString(5, qip);
				result = pstmt.executeUpdate();
				System.out.println("q�벐湲곗꽦怨�");
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"q�벐湲곗떎�뙣");
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

	
//		 �떟蹂� �벐湲� �쟾

		private void preReply(int qgroup, int qstep){
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE QNA SET qSTEP =qSTEP +1 WHERE qGROUP = ? AND qSTEP > ?";
			
			try { //占쏙옙占쌜억옙占쏙옙占� step占쏙옙 占쏙옙占쏙옙 占쏙옙占� 0占쏙옙占쏙옙
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qgroup);
				pstmt.setInt(2, qstep);
				
				 int result = pstmt.executeUpdate();
				System.out.println(result == 0? "�떟蹂�湲� �쟾 議곗젙 �셿猷�" : result +"�떟蹂�湲� �쟾 議곗젙 �떎�뙣");
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
		
		
//		�떟蹂�
		public int replyA(String mid, String qsubject, String qcontent, String qfilename, int qgroup, int qstep, int qindent, String qip){
			
			preReply(qgroup, qstep); 
			int result =FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) " + 
					"    VALUES (QNA_SEQ.NEXTVAL, ? , ?, ?, ?, SYSDATE, ?, ?, ?, ?)";
				
			
			try { 
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				
				pstmt.setString(1, mid);
				pstmt.setString(2, qsubject);
				pstmt.setString(3, qcontent);
				pstmt.setString(4, qfilename);
				pstmt.setInt(5, qgroup);
				pstmt.setInt(6, qstep+1); 
				pstmt.setInt(7, qindent+1);
				pstmt.setString(8, qip);
				result = pstmt.executeUpdate();
				System.out.println("�떟蹂�湲��셿猷�");
			} catch (SQLException e) {
				
				System.out.println(e.getMessage()+"�떟蹂�湲� �떎�뙣");
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
		public int modifyQNA(int qnum, String qsubject, String qcontent, String qfilename, String qip){
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE QNA SET qSUBJECT= ?," + 
					"                qCONTENT= ?," + 
					"                qIP= ?," + 
					"                qFILENAME = ?," + 
					"                qRDATE = SYSDATE" + 
					"                WHERE qNUM= ?";
			
			try { 
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, qsubject);
				pstmt.setString(2, qcontent);
				pstmt.setString(3, qfilename);
				pstmt.setString(4, qip);
				pstmt.setInt(5, qnum);
				result = pstmt.executeUpdate();
				System.out.println(result ==SUCCESS ? "�닔�젙�셿猷�" : "�닔�젙�떎�뙣");
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

		//吏덈Ц�궘�젣
		public int deleteQ(int qnum, int qgroup){
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
				System.out.println("吏덈Ц �궘�젣 �꽦怨�");
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"吏덈Ц �궘�젣�떎�뙣");
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

		//吏덈Ц �궘�젣 �쟾
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
						if(pstmt!=null)
						pstmt.close();
						if(conn!=null)
						conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					
					}
			}
		}
		
		
		//�떟蹂� �궘�젣
		public int deleteA(int qnum){
			int result = FAIL;
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM QNA WHERE QNUM =?";
			
			try { 
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qnum);
				result = pstmt.executeUpdate();
				System.out.println("�떟蹂� �궘�젣 �궘�젣 �꽦怨�");
			} catch (SQLException e) {
				System.out.println(e.getMessage()+"�떟蹂� �궘�젣 �떎�뙣");
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
		
		
		//議고쉶�닔

		
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
						if(pstmt!=null)
						pstmt.close();
						if(conn!=null)
						conn.close();
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					
					}
			}
		}
		
		
//		�쟾泥� 媛��졇�삤湲�(議고쉶�닔�슜)
		
		public QnaDto getQna(int qnum){
			hitUp(qnum);
			QnaDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql =  "SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM= ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qnum);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					 String mid = rs.getString("mid");
					 String mname = rs.getString("mname");
					 String qsubject = rs.getString("qsubject");
					 String qcontent = rs.getString("qcontent");
					 String qfilename = rs.getString("qfilename");
					 Date qrdate = rs.getDate("qrdate");
					 int qhit = rs.getInt("qhit");
					 int qgroup = rs.getInt("qgroup");
					 int qstep= rs.getInt("qstep");
					 int qindent= rs.getInt("qindent");
					 String qip = rs.getString("qip");
					 
					dto = new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit, qip);
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
		
		public QnaDto reply_modifyView(int qnum){
			QnaDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql =  "SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM= ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qnum);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					 String mid = rs.getString("mid");
					 String mname = rs.getString("mname");
					 String qsubject = rs.getString("qsubject");
					 String qcontent = rs.getString("qcontent");
					 String qfilename = rs.getString("qfilename");
					 Date qrdate = rs.getDate("qrdate");
					 int qhit = rs.getInt("qhit");
					 int qgroup = rs.getInt("qgroup");
					 int qstep= rs.getInt("qstep");
					 int qindent= rs.getInt("qindent");
					 String qip = rs.getString("qip");
					dto = new QnaDto(qnum, mid, mname, qsubject, qcontent, qfilename, qrdate, qgroup, qstep, qindent, qhit, qip);
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
		
		//�떟蹂� 媛��닔
		//SELECT COUNT(*) FROM QNA WHERE qGROUP = 5;
		public int countA(int qgroup) {
			int cnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql =  "SELECT COUNT(*) FROM QNA WHERE qGROUP = ?";

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
		
		//답변글 리스트
//		select * from 
//	    (select rownum rn, a.*
//	    from(select * from qna where qgroup =1 and qstep >0)a)
//	    where rn between 1 and 10
		

//	//
//		public void withdrawDeleteBoard(int mid){
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			String sql = "DELETE FROM QNA WHERE MID =?";
//			
//			try { 
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1, mid);
//				pstmt.executeUpdate();
//				System.out.println("qna�궘�젣�꽦怨�");
//			} catch (SQLException e) {
//				System.out.println(e.getMessage()+"qna�궘�젣�꽦怨�");
//			} finally {
//				
//					try {
//						if(pstmt!=null)
//						pstmt.close();
//						if(conn!=null)
//						conn.close();
//					} catch (SQLException e) {
//						System.out.println(e.getMessage());
//					
//					}
//			}
//			
//
//		}
//		
//		//SELECT * 
////	    FROM(SELECT ROWNUM RN, A.*
////	            FROM(SELECT * FROM FILEBOARD WHERE MID='aaa' order by frdate desc)A)
////	       WHERE RN BETWEEN  1 AND 10
//		
//		public ArrayList<FileboardDto> listMyFboard(String mid, int startRow, int endRow) {
//			ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql = "SELECT * " + 
//					"    FROM(SELECT ROWNUM RN, A.*" + 
//					"         FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND M.MID= ? order by frdate desc)A)" + 
//					"    WHERE RN BETWEEN  ? AND ?";
//
//			try {
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, mid);
//				pstmt.setInt(2, startRow);
//				pstmt.setInt(3, endRow);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					 int fnum = rs.getInt("fnum");
//					 String mname = rs.getString("mname");
//					 String fsubject = rs.getString("fsubject");
//					 String fcontent = rs.getString("fcontent");
//					 String ffilename = rs.getString("ffilename");
//					 String ffilename2 = rs.getString("ffilename2");
//					 String ffilename3 = rs.getString("ffilename3");
//					 Date frdate = rs.getDate("frdate");
//					 int fhit = rs.getInt("fhit");
//					 int fgroup = rs.getInt("fgroup");
//					 int fstep= rs.getInt("fstep");
//					 int findent= rs.getInt("findent");
//					 String fip = rs.getString("fip");
//					
//					dtos.add(new FileboardDto(fnum, mid,mname, fsubject, fcontent, ffilename, ffilename2, ffilename3, frdate, fhit, fgroup, fstep, findent, fip));
//				}
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			} finally {
//
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//
//				}
//			}
//			return dtos;
//
//		}
//		//占쏙옙 占쏙옙 占쏙옙占쏙옙
//		//SELECT COUNT(*) FROM FILEBOARD WHERE MID='aaa';
//		
//		public int countMyBoard(String mid) {
//			int cnt = 0;
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql =  "SELECT COUNT(*) FROM FILEBOARD WHERE MID= ? ";
//
//			try {
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, mid);
//				rs = pstmt.executeQuery();
//				rs.next();
//				cnt = rs.getInt(1);
//				
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			} finally {
//
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//
//				}
//			}
//			return cnt;
//		}
//		
//		//寃��깋
//		
//		public ArrayList<FileboardDto> searchList(String fsubject, int startRow, int endRow) {
//			ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql = "SELECT * " + 
//					"    FROM(SELECT ROWNUM RN, A.* " + 
//					"        FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fSUBJECT LIKE '%'||?||'%' ORDER BY fGROUP DESC, FSTEP)A)" + 
//					"				WHERE RN BETWEEN ? AND ?";
//
//			try {
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, fsubject);
//				pstmt.setInt(2, startRow);
//				pstmt.setInt(3, endRow);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					 int fnum = rs.getInt("fnum");
//					 String mid = rs.getString("mid");
//					 String mname = rs.getString("mname");
//					 fsubject = rs.getNString("fsubject");
//					 String fcontent = rs.getString("fcontent");
//					 String ffilename = rs.getString("ffilename");
//					 String ffilename2 = rs.getString("ffilename2");
//					 String ffilename3 = rs.getString("ffilename3");
//					 Date frdate = rs.getDate("frdate");
//					 int fhit = rs.getInt("fhit");
//					 int fgroup = rs.getInt("fgroup");
//					 int fstep= rs.getInt("fstep");
//					 int findent= rs.getInt("findent");
//					 String fip = rs.getString("fip");
//					
//					dtos.add(new FileboardDto(fnum, mid,mname, fsubject, fcontent, ffilename, ffilename2, ffilename3, frdate, fhit, fgroup, fstep, findent, fip));
//				}
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			} finally {
//
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//
//				}
//			}
//			return dtos;
//
//		}
//		
//		//寃��깋�맂 湲� 媛��닔
//		public int countSearch(String fsubject) {
//			int cnt = 0;
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			String sql =  "SELECT COUNT(*) FROM FILEBOARD WHERE fSUBJECT LIKE '%'||?||'%'";
//
//			try {
//				conn = ds.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, fsubject);
//				rs = pstmt.executeQuery();
//				rs.next();
//				cnt = rs.getInt(1);
//				
//			} catch (SQLException e) {
//				System.out.println(e.getMessage());
//			} finally {
//
//				try {
//					if (rs != null)
//						rs.close();
//					if (pstmt != null)
//						pstmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//
//				}
//			}
//			return cnt;
//		}
//		
//		//�깉�눜�슜 湲��궘�젣
//				public int withdrawfb(String mid){
//					int result = FAIL;
//					Connection conn = null;
//					PreparedStatement pstmt = null;
//					String sql = "DELETE FROM FILEBOARD WHERE MID =?";
//					
//					try { 
//						conn = ds.getConnection();
//						pstmt = conn.prepareStatement(sql);
//						pstmt.setString(1, mid);;
//						result = pstmt.executeUpdate();
//						System.out.println("�옄�쑀寃뚯떆�뙋 湲� 媛뺤젣 �궘�젣 �꽦怨�");
//					} catch (SQLException e) {
//						System.out.println(e.getMessage()+"�옄�쑀寃뚯떆�뙋 湲� 媛뺤젣 �궘�젣 �떎�뙣");
//					} finally {
//						
//							try {
//								if(pstmt!=null)
//								pstmt.close();
//								if(conn!=null)
//								conn.close();
//							} catch (SQLException e) {
//								System.out.println(e.getMessage());
//							
//							}
//					}
//					return result;
//					
//				}

	
}
