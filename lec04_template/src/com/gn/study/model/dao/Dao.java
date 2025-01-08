package com.gn.study.model.dao;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Car;

public class Dao {
	
	
	public int insertCarOne(Connection conn, Car car) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			
			String sql = "insert into car(car_model, car_price, car_date) "
					+ "values(?, ?, str_to_date(?, '%Y-%m-%d'))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getCarModel());
			pstmt.setInt(2, car.getCarPrice());
			pstmt.setString(3, car.getCarDate());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			close(pstmt);
		}
		return result;
	}
	
	public List<Car> selectCarAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Car> list = new ArrayList<Car>();
		try {
			String sql = "select * from car";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				
//				Car car = new Car(rs.getInt("car_no"), rs.getString("car_model"), rs.getInt("car_price"), sdf.format(rs.getDate("car_date")));
				Car car = new Car();
				car.setCarNo(rs.getInt("car_no"));
				car.setCarModel(rs.getString("car_model"));
				car.setCarPrice(rs.getInt("car_price"));
				
				if(rs.getDate("car_date") != null) {
					car.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					car.setCarDate("-미정-");
				}
				list.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
//	public List<Car> searchCarList(int option, Object obj){
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Car> list = new ArrayList<Car>();
//		try {
//			String sql = "select * from car";
//			switch(option){
//				case 1 : sql += "where car_no = ?" + (Integer)obj; break;
//				//이런식으로~
//			}
//			pstmt = conn.prepareStatement(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//	}
//	주석 강사님 수업||주석 강사님 수업||주석 강사님 수업||
	
	public Car selectCarOneByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car selectCar = null;
		
		try {
			String sql = "select * from car where car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				selectCar = new Car();
				selectCar.setCarNo(rs.getInt("car_no"));
				selectCar.setCarModel(rs.getString("car_model"));
				selectCar.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					selectCar.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					selectCar.setCarDate("--미정--");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return selectCar;
	}
	
	public Car selectCarOneByName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car selectCar = null;
		
		try {
			String sql = "select * from car where car_model = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				selectCar = new Car();
				selectCar.setCarNo(rs.getInt("car_no"));
				selectCar.setCarModel(rs.getString("car_model"));
				selectCar.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					selectCar.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					selectCar.setCarDate("--미정--");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return selectCar;
	}
	
	public Car selectCarOneByPrice(Connection conn, int price) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car selectCar = null;
		
		try {
			String sql = "select * from car where car_price = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				selectCar = new Car();
				selectCar.setCarNo(rs.getInt("car_no"));
				selectCar.setCarModel(rs.getString("car_model"));
				selectCar.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					selectCar.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					selectCar.setCarDate("--미정--");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectCar;
	}
	
	public Car selectCarOneByDate(Connection conn, String date) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Car selectCar = null;
		try {
			String sql = "select * from car where car_date = str_to_date(?, '%Y-%m-%d')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(rs.next()) {
				selectCar = new Car();
				selectCar.setCarNo(rs.getInt("car_no"));
				selectCar.setCarModel(rs.getString("car_model"));
				selectCar.setCarPrice(rs.getInt("car_price"));
				if(rs.getDate("car_date") != null) {
					selectCar.setCarDate(sdf.format(rs.getDate("car_date")));
				} else {
					selectCar.setCarDate("--미정--");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return selectCar;
	}
	
	public int deleteCarOne(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "delete from car where car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public int editCarOne(Connection conn, int no, Object newName, Object newPrice, Object newDate) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sqlName = " ";
			String sqlPrice = " ";
			String sqlDate = " ";
			String sql = "update car set" + sqlName + sqlPrice + sqlDate + "where car_no = ?";
//					+ "set car_model = "
//					+ ",car_price = ? "
//					+ ",car_date = str_to_date(?, '%Y-%m-%d') "
//					+ "where car_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
//			콤마콤마 어덯게 할지 !!!!!
			if(newName != null) {
				sqlName = " car_model = " + (String)newName + " ";
			} 
			if(newPrice != null) {
				sqlPrice = " car_price = " + (Integer)newPrice + " ";
			}
			if(newDate != null) {
				sqlDate = " car_date = str_to_date(" + (String)newDate + ", '%Y-%m-%d') ";
			}
			
			result = pstmt.executeUpdate();
//			if(newName != null) {
//				sqlName = "set car_model = ? ";
//				pstmt.setString(1, newName);
//			}
//			pstmt.setInt(2, newPrice);
//			pstmt.setString(3, newDate);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

}
