package com.gn.homework01.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarketDao {
	public int createUser(String createId, String createPw, String createNick) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "insert into sm_user(u_id, u_pw, u_nick) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, createId);
			pstmt.setString(2, createPw);
			pstmt.setString(3, createNick);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	
}
