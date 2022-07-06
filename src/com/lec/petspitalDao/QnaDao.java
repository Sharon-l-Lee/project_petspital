package com.lec.petspitalDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	
	
	
}
