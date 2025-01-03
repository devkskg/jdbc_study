package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Insert_Scanner02 {
	public static void main(String[] args) {
//		강사님 풀이
		Connection conn = null;
		Statement stmt = null;
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			String sql = "insert into test(t_name) values('" + str + "')";
			int cnt = stmt.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("성공");
				System.out.println("=== test ===");
//				
				List<Test> list = new ArrayList<Test>();
				String sql2 = "select * from test where t_name = '" + str + "'";
				rs = stmt.executeQuery(sql2);
				while(rs.next()) {
					
					Test t = new Test(rs.getInt("t_no"), rs.getString("t_name"), rs.getTimestamp("t_date").toLocalDateTime());
					list.add(t);
					
				}
				System.out.println(list);
//				동명이인을 확인할 수 있는 List
				
			} else {
				System.out.println("실패");
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
