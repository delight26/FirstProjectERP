package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.connector.Request;

import com.firstproject.bean.ScheduleBean;

public class ScheduleDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static ScheduleDao mDao = new ScheduleDao();

	private ScheduleDao() {

	}

	public static ScheduleDao getInstance() {
		if (mDao == null) {
			mDao = new ScheduleDao();
		}
		return mDao;
	}

	public void addSchedule(ScheduleBean schedule) {

		String insert = "INSERT INTO schedule (scheduleNumber, scheduleDate, scheduleTitle, scheduleContent, membernum)"
				+ "VALUES(schedule_seq.nextval, ?, ?, ?, ?)";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, schedule.getScheduleDate());
			pstmt.setString(2, schedule.getScheduleTitle());
			pstmt.setString(3, schedule.getScheduleContent());
			pstmt.setInt(4, schedule.getMemberNumber());
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException se) {
			}
		}
	}

	public ArrayList<ScheduleBean> getCalendarForm(int memberNumber) {

		ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
		String select = "select * from schedule where membernum = ?";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, memberNumber);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String scheduleNumber = rs.getString(1);
				String scheduleDate = rs.getString(2);
				String scheduleTitle = rs.getString(3);
				String scheduleContent = rs.getString(4);
				String noticeCreator = "";

				ScheduleBean schedule = new ScheduleBean(scheduleNumber, scheduleDate, noticeCreator, scheduleTitle,
						scheduleContent, noticeCreator);
				scheduleList.add(schedule);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException se) {
			}
		}

		return scheduleList;
	}

	public ScheduleBean getReadSchedule(String number) {

		ScheduleBean schedule = null;
		String select = "select * from schedule where scheduleNumber = ?";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String scheduleNumber = rs.getString(1);
				String scheduleDate = rs.getString(2);
				String scheduleTitle = rs.getString(3);
				String scheduleContent = rs.getString(4);
				String noticeCreator = "";

				schedule = new ScheduleBean(scheduleNumber, scheduleDate, noticeCreator, scheduleTitle, scheduleContent,
						noticeCreator);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException se) {
			}
		}

		return schedule;
	}

	public void getUpdateSchedule(String title, String content, String number) {

		ScheduleBean schedule = null;
		int tempScheduleNumber = Integer.parseInt(number);

		System.out.println(title);
		System.out.println(content);
		System.out.println("number : " + tempScheduleNumber);
		String update = "update schedule set scheduleTitle = ?, scheduleContent = ? where SCHEDULENUMBER = ?";
		System.out.println(Integer.parseInt(number));
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, tempScheduleNumber);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException se) {
			}
		}

	}

	public void getDeleteSchedule(String number) {

		String delete = "DELETE FROM schedule WHERE scheduleNumber = ?";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException se) {
			}
		}
	}
}
