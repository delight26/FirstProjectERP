package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.firstproject.bean.ProjectManager;

public class ProjectDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static ProjectDao instance = new ProjectDao();

	private ProjectDao() {
	}

	public static ProjectDao getInstance() {
		if (instance == null) {
			instance = new ProjectDao();
		}
		return instance;
	}
	public ArrayList<ProjectManager> getListProject(){
		ArrayList<ProjectManager> projectList = new ArrayList<ProjectManager>();
		String select = "select p.projectnumber, p.projectname, m.name, p.content, p.startdate, p.enddate, "
				+ "round((sysdate-startdate)/(enddate-startdate)*100) from project p, member m "
				+ "where p.manager = m.membernumber and enddate >= sysdate";
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int projectNumber = rs.getInt(1);
				String projectName = rs.getString(2);
				String manager = rs.getString(3);
				String content = rs.getString(4);
				String startDate = rs.getString(5);
				String endDate = rs.getString(6);
				int percent = rs.getInt(7);
				ProjectManager pm = new ProjectManager(projectNumber, projectName, manager, content, startDate
						,endDate ,percent);
				projectList.add(pm);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return projectList;
	}
	public ProjectManager getReadProject(int projectnum){
		String select = "select p.projectnumber, p.projectname, m.name, p.content, p.startdate, p.enddate, "
				+ "round((sysdate-startdate)/(enddate-startdate)*100) from project p, member m "
				+ "where p.manager = m.membernumber and enddate >= sysdate and p.projectnumber =?";
		ProjectManager pm =null;
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, projectnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int projectNumber = rs.getInt(1);
				String projectName = rs.getString(2);
				String manager = rs.getString(3);
				String content = rs.getString(4);
				String startDate = rs.getString(5);
				String endDate = rs.getString(6);
				int percent = rs.getInt(7);
				pm = new ProjectManager(projectNumber, projectName, manager, content, startDate
						,endDate ,percent);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return pm;
	}
	public void getInsertProject(ProjectManager pm){
		String select = "insert into project values (project_seq.nextval, ?, ?, ?, ?, ?)";
		System.out.println(pm.getEndDate());
		System.out.println(pm.getStartDate());
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, pm.getProjectName());
			pstmt.setString(2, pm.getManager());
			pstmt.setString(3, pm.getComment());
			pstmt.setString(4, pm.getStartDate());
			pstmt.setString(5, pm.getEndDate());
			pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}
	public void getUpdateProject(ProjectManager pm){
		String update = "update project set projectname=?, content=?, startdate=?, enddate=? where projectnumber=?";
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, pm.getProjectName());
			pstmt.setString(2, pm.getComment());
			pstmt.setString(3, pm.getStartDate());
			pstmt.setString(4, pm.getEndDate());
			pstmt.setInt(5, pm.getProjectNumber());
			pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}
}
