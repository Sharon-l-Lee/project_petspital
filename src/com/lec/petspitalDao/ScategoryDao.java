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
import com.lec.petspitalDto.ScategoryDto;

public class ScategoryDao {
	private DataSource ds;

	private ScategoryDao() {
		Context ctx;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	}

	private static ScategoryDao instance = new ScategoryDao();

	public static ScategoryDao getInstance() {
		return instance;
	}
	
	
	public ArrayList<ScategoryDto> listSymptom() {
		ArrayList<ScategoryDto> dtos = new ArrayList<ScategoryDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from SCATEGORY";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int scategoryid = rs.getInt("scategoryid");
				String scategoryname = rs.getString("scategoryname");
				
				dtos.add(new ScategoryDto(scategoryid, scategoryname));
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
}
