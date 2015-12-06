package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.firstproject.bean.Member;



public class LoginDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static LoginDao mDao = new LoginDao();

	private LoginDao() {

	}

	public static LoginDao getInstance() {
		if (mDao == null) {
			mDao = new LoginDao();
		}
		return mDao;
	}
	public int userCheck(int membernumber, String password) {
		int result = -1;
		String sql = "SELECT password FROM member where membernumber=?";
		try{
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  membernumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("password") != null && rs.getString("password").equals(password)) {
					result = 1;
					
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return result;
	}
}
