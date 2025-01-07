package com.gn.homework01.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework01.model.vo.MarketBuyVo;
import com.gn.homework01.model.vo.MarketUserVo;

public class MarketBuyDao {
	private MarketUserVo muv = new MarketUserVo();
	
	public List<MarketBuyVo> searchBuyTable(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MarketBuyVo> list = new ArrayList<MarketBuyVo>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from sm_buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add( new MarketBuyVo(rs.getInt("b_no"), rs.getInt("b_u_no"), rs.getInt("b_p_no"), rs.getInt("b_sales")));
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
		return list;
	}
	
	public int userBuyProduct(int userpNo, int userpSales, int uNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		int cnt = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			conn.setAutoCommit(false);
			String sql1 = "update sm_product set p_amount = p_amount - ? where p_no = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, userpSales);
			pstmt.setInt(2, userpNo);
			cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				String sql2 = "insert into sm_buy(b_u_no, b_p_no, b_sales) values(?, ?, ?)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, uNo);
				pstmt.setInt(2, userpNo);
				pstmt.setInt(3, userpSales);
				result = pstmt.executeUpdate();
			} else {
				return -10;
			}
			conn.commit();
			
			
			
		} catch (Exception e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				conn.setAutoCommit(true);
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
}
