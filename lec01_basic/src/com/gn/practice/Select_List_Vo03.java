package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Test;

public class Select_List_Vo03 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, id, pw);
			
			String sql = "select t_no ,t_name ,t_date from test";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			List<Test> list  = new ArrayList<Test>();
			
			while(rs.next()) {
				list.add(new Test(rs.getInt("t_no") , rs.getString("t_name"), rs.getTimestamp("t_date").toLocalDateTime()));
			}
			
			for(Test l : list) {
				System.out.println(l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
