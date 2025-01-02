package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class A_Select_Many_List_Map02 {

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
			
			stmt = conn.createStatement();
			String sql = "select t_no, t_name ,t_date from test";
			rs = stmt.executeQuery(sql);
			
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			while(rs.next()) {
				Map<String, Object> map = new TreeMap<String, Object>();
				map.put("넘버요", rs.getInt("t_no"));
				map.put("이름이요", rs.getString("t_name"));
				map.put("날짜요", rs.getDate("t_date").toLocalDate());
				list.add(map);
			}
			for(Map<String, Object> m : list) {
				System.out.println(m);
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
