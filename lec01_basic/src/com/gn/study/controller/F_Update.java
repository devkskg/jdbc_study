package com.gn.study.controller;

import java.sql.Connection;
import java.sql.SQLException;

import org.mariadb.jdbc.Statement;

public class F_Update {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
