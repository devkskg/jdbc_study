package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.ProjectVo;

public class ProjectDao {
	public int insertProjectOne(String projectName, String managerName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
//			미완성된 sql
			String sql = "INSERT INTO project(project_name ,project_manager) "
					+ "VALUES (?, (SELECT emp_id FROM employee WHERE emp_name = ?))";
			pstmt = conn.prepareStatement(sql);
			
//			미완성된 sql을 채워준다.
			pstmt.setString(1, projectName);
			pstmt.setString(2, managerName);
			
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
	
	public List<ProjectVo> selectProjectAll(){
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
//			String sql = "select * from project";
//			pstmt1 = conn.prepareStatement(sql);
//			rs = pstmt1.executeQuery();
			
			String sql = "SELECT p.* "
					+ ",e.emp_name "
//					+ ,ifnull(e.emp_name, '미정') 
//					ifnull과 concat을 사용하면 더 좋은 결과를 얻을 수 있을 것이다. 
//					별칭까지 한다면 while문 안에 rs 호출시에 컬럼명 작성하기 더 편할 것이다.
//					String이 null일 경우 ifnull 쓰면 좋다. int는 알아서 0 처리 한다.
					+ "FROM project p "
					+ "LEFT JOIN employee e on p.project_manager = e.emp_id";
			pstmt1 = conn.prepareStatement(sql);
			rs = pstmt1.executeQuery();
			
//			String findName = "SELECT e.emp_name "
//					+ "FROM project p "
//					+ "JOIN employee e on p.project_manager = e.emp_id "
//					+ "WHERE p.project_manager = ?";
//			pstmt2 = conn.prepareStatement(findName);
//			pstmt2.setInt(1, rs.getInt("project_manager"));
//			rs.get 이 부분에서 오류가 난다!
//			rs2 = pstmt2.executeQuery();
			
			while(rs.next()) {
//				list.add(new ProjectVo(rs.getInt("project_id"), rs.getString("project_name"), rs.getInt("project_manager")));
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setProjectManager(rs.getInt("project_manager"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				vo.setManagerName(rs.getString("emp_name"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<ProjectVo> selectProjectAllByName(String projectName){
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
			
			String sql = "SELECT p.* "
					+ ",e.emp_name "
					+ "FROM project p "
					+ "LEFT JOIN employee e on p.project_manager = e.emp_id "
					+ "WHERE project_name LIKE CONCAT('%',?,'%')";
//					+ "WHERE project_name LIKE '%?%'";
//					이렇게 해버리면 '%'name'%' 이렇게 되어버린다
//					? 물음표가 홑따옴표가 포함된 데이터로 들어가게 되어버림.(문자열일 경우) -> 해결법은 CONCAT!!
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, projectName);
			rs = pstmt1.executeQuery();
			
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setProjectManager(rs.getInt("project_manager"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				vo.setManagerName(rs.getString("emp_name"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public List<ProjectVo> selectProjectAllByManagerName(String managerName){

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<ProjectVo> list = new ArrayList<ProjectVo>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			
			
			String sql = "SELECT p.* "
					+ ",e.emp_name "
					+ "FROM project p "
					+ "LEFT JOIN employee e on p.project_manager = e.emp_id "
					+ "WHERE e.emp_name LIKE CONCAT('%',?,'%')";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.setString(1, managerName);
			rs = pstmt1.executeQuery();
			
			while(rs.next()) {
				ProjectVo vo = new ProjectVo();
				vo.setProjectId(rs.getInt("project_id"));
				vo.setProjectName(rs.getString("project_name"));
				vo.setProjectManager(rs.getInt("project_manager"));
				vo.setRegDate(rs.getTimestamp("reg_date").toLocalDateTime());
				vo.setModDate(rs.getTimestamp("mod_date").toLocalDateTime());
				vo.setManagerName(rs.getString("emp_name"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	
	}
	
	public int updateProjectOne(int projectNo, String projectName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "update project set project_name = ? "
					+ "where project_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, projectName);
			pstmt.setInt(2, projectNo);
			
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
	
	public int deleteProjectOne(int projectNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/company_project";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "delete from project "
					+ "where project_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectNo);
			
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
