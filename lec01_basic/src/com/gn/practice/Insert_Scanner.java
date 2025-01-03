package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Insert_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.println("===== test =====");
		
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
			
			
			conn.setAutoCommit(false);
			
			
//			INSERT를 먼저 -> SELECT를 나중 /  문제라서 같은 name이 들어가면 PK가 달라서 중복된 이름을 가지는 row가 여러개 생김
//			그래서 두번 실행시 이름이 두번 들어가고 PK가 낮은 name이 결과값에 나옴
			
//			보통 SELECT를 먼저해서 중복을 확인하고 중복시 실패 뜨게 만들고
//			이후에 INSERT를 통하여 name을 넣으니 중복된 name을 가지는 row가 안 만들어질텐데..
			
//			문제가 원하는 DB사용자(입력자)는 항상 이름을 다르게 입력하는 사람이라고 생각하면 될거같다.
			
			String sql1 = "insert into test(t_name) values('" + name + "')";
			int result = stmt.executeUpdate(sql1);
			
			
			
			if(result > 0) {
				String sql2 = "select t_no ,t_name ,t_date from test where t_name = '" + name + "'";
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					int tno = rs.getInt("t_no");
					String tname = rs.getString("t_name");
					LocalDateTime tdate = rs.getTimestamp("t_date").toLocalDateTime();
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
					System.out.println("번호:" + tno + ", 이름:" + tname + ", 등록일:" + tdate.format(dtf));
				} else {
					System.out.println("조회 실패");
				}
				
			} else {
				System.out.println("INSERT 실패"); // Insert를 실패할 수가 없다.
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
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
}
