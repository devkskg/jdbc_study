package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
//	Static Method를 Import하는 방법
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

//	DB에 접속 -> Connection 객체 생성하는 역할
public class Service {
	private Dao dao = new Dao();
	
	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(conn, car);
		close(conn);
		return result;
		
//		Connection conn = null;
//		int result = 0;
//		
//		try {
//			
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String id = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url, id, pw);
//			
//			result = dao.insertCarOne(conn, car);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//				try {
//					if(conn != null) conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		
//		return result;
	}
	
	public List<Car> selectCarAll(){
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
//	public List<Car> searchCarList(int option, Object obj){
//		Connection conn = getConnection();
//		List<Car> list = dao.seachCarList(option, obj);
//		close(conn);
//		return list;
//	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
	public Car selectCarOneByNo(int no) {
		Connection conn = getConnection();
		Car selectCar = dao.selectCarOneByNo(conn, no);
		close(conn);
		return selectCar;
	}
	public Car selectCarOneByName(String name) {
		Connection conn = getConnection();
		Car selectCar = dao.selectCarOneByName(conn, name);
		close(conn);
		return selectCar;
	}
	public Car selectCarOneByPrice(int price) {
		Connection conn = getConnection();
		Car selectCar = dao.selectCarOneByPrice(conn, price);
		close(conn);
		return selectCar;
	}
	public Car selectCarOneByDate(String date) {
		Connection conn = getConnection();
		Car selectCar = dao.selectCarOneByDate(conn, date);
		close(conn);
		return selectCar;
	}
	
	public int deleteCarOne(int no) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(conn, no);
		close(conn);
		return result;
	}
	
	public int editCarOne(int no, Object newName, Object newPrice, Object newDate) {
		Connection conn = getConnection();
		int result = dao.editCarOne(conn, no, newName, newPrice, newDate);
		close(conn);
		return result;
	}
}
