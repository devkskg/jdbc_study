package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_One_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("조회하고자 하는 행의 번호를 입력하세요.");
		System.out.print("번호 : ");
		int num = sc.nextInt();
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
			String sql = "select t_no ,t_name ,t_date from test where t_no = " + num;
			
			rs = stmt.executeQuery(sql);
			
			Vo v = new Vo();
			if(rs.next()) {
				v.setNo(rs.getInt("t_no"));
				v.setName(rs.getString("t_name"));
				v.setDate(rs.getTimestamp("t_date").toLocalDateTime());
			}
			System.out.println(v);
			
			
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
		
		sc.close();
		
	}
}
