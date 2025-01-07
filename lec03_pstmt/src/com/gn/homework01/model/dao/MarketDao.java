package com.gn.homework01.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gn.homework01.model.vo.MarketUserVo;

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
	
	public MarketUserVo login(String loginId, String loginPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MarketUserVo smu = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from sm_user where u_id = ? and u_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				smu = new MarketUserVo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"), rs.getString("u_nick"), rs.getTimestamp("U_regdate").toLocalDateTime(), rs.getTimestamp("u_moddate").toLocalDateTime());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return smu;
	}
	
	public int editeNick(String uId, String newNick) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "update sm_user set u_nick = ? where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newNick);
			pstmt.setString(2, uId);
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
	
	public int deleteUser(String uId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "delete from sm_user where u_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
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
