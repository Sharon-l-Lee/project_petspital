package com.lec.petspitalDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.petspitalDto.RcategoryDto;
import com.lec.petspitalDto.ScategoryDto;

public class RcategoryDao {


		private DataSource ds;

		private RcategoryDao() {
			Context ctx;
			try {
				ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			} catch (NamingException e) {
				System.out.println(e.getMessage());
			}
		}

		private static RcategoryDao instance = new RcategoryDao();

		public static RcategoryDao getInstance() {
			return instance;
		}
		
		
		public ArrayList<RcategoryDto> listAnimal() {
			ArrayList<RcategoryDto> dtos = new ArrayList<RcategoryDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from RCATEGORY";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					
					int rcategoryid = rs.getInt("rcategoryid");
					String rcategoryname = rs.getString("rcategoryname");
					
					dtos.add(new RcategoryDto(rcategoryid, rcategoryname));
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

