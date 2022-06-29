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
		String sql = "SELECT * FROM(SELECT ROWNUM RN, A.* FROM (SELECT FRNUM, FNUM, MNAME, AID, FRCONTENT,FRDATE, FRIP FROM FREPLY F, MEMBER M WHERE F.MID =M.MID AND FNUM=?)A)" + 
				"    WHERE rn between ? and ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				 int frnum = rs.getInt("frnum");
				 String mname = rs.getString("mname");
				 String aid = rs.getString("aid");
				 String frcontent = rs.getString("frcontent");
				 Date frdate = rs.getDate("frdate");
				 String frip = rs.getString("frip");
				
				dtos.add(new FreplyDto(frnum, fnum, mname, aid, frcontent, frdate, frip));
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
	
//	--´ñ±Û ÀÔ·Â
//	INSERT INTO FREPLY(fRNUM, fNUM, mID,fRCONTENT, FRDATE, FRIP ) VALUES(FREPLY_SEQ.NEXTVAL, 16, 'aaa', '´ñ±Û È®ÀÎ',SYSDATE, '127.10.25' );
//	--´ñ±Û ¼öÁ¤
//	UPDATE FREPLY SET fRCONTENT= '´ñ±ÛÈ®ÀÎ¼öÁ¤' WHERE fRNUM=1;
//	--´ñ±Û »èÁ¦
//	DELETE FROM FREPLY WHERE fRNUM='2'; 
//	--´ñ±Û ¼ö
}
