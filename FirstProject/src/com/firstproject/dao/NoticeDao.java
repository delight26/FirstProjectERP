package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.firstproject.bean.*;

public class NoticeDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static NoticeDao instance = new NoticeDao();

	private NoticeDao() {
	}

	public static NoticeDao getInstance() {
		if (instance == null) {
			instance = new NoticeDao();
		}
		return instance;
	}

	public int getNoticeCount() {
		
		String countsql = "SELECT COUNT(*) FROM notice";
		int count = 0;
		
		try{
			
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList<NoticeBoard> getNoticeList(int startRow, int endRow) {
		
		String select = "SELECT noticenumber, noticename, m.name, noticecontent, noticedate, noticepassword, hit "
				+ "FROM member m, (SELECT ROWNUM num ,noticenumber, noticename, membernumber, noticecontent, "
				+ "noticedate, noticepassword, hit FROM (SELECT * FROM notice ORDER BY noticedate DESC)) "
				+ "sub where m.membernumber = sub.membernumber and num >= ? AND num <= ?";
		ArrayList<NoticeBoard> noticeList = new ArrayList<NoticeBoard>();

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int noticeNumber = rs.getInt(1);
				String noticeName = rs.getString(2);
				String noticeCreater = rs.getString(3);
				String noticeContent = rs.getString(4);
				String noticeDate = rs.getString(5);
				String noticePassword = rs.getString(6);
				int noticeLookup = rs.getInt(7);
				noticeDate = noticeDate.substring(0, 10);
				NoticeBoard notice = new NoticeBoard(noticeNumber, noticeName, noticeContent, noticePassword,
						noticeCreater, noticeDate, noticeLookup);
				noticeList.add(notice);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return noticeList;
	}

	public NextPrePageControll getNoticePageNumber(int pageNum) {
		String select = "SELECT noticenumber, LEAD(noticenumber, 1, '') OVER (ORDER BY noticedate DESC) "
				+ "AS NEXT_noticenumber, LAG(noticenumber, 1, '') OVER (ORDER BY noticedate DESC ) "
				+ "AS  PRE_noticenumber FROM notice";
		NextPrePageControll page = null;
		int nowPage, nextPage, prePage;
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nowPage = rs.getInt(1);
				if(nowPage == pageNum){
				 
				nextPage = rs.getInt(2);
				prePage = rs.getInt(3);
				page = new NextPrePageControll(nextPage, prePage);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return page;
	}
	
	public ArrayList<NoticeBoard> getNoticeRead(NoticeBoard noticep) {
		String select = "select * from notice where noticenumber=?";
		String update = "update notice set hit=? where noticenumber=?";
		ArrayList<NoticeBoard> noticeList = new ArrayList<NoticeBoard>();

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, noticep.getNoticeNumber());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int noticeNumber = rs.getInt(1);
				String noticeName = rs.getString(2);
				String noticeCreater = rs.getString(3);
				String noticeContent = rs.getString(4);
				String noticeDate = rs.getString(5);
				String noticePassword = rs.getString(6);
				int noticeLookup = rs.getInt(7);
				noticeDate = noticeDate.substring(0, 10);
				NoticeBoard notice = new NoticeBoard(noticeNumber, noticeName, noticeContent, noticePassword,
						noticeCreater, noticeDate, noticeLookup);
				noticeList.add(notice);
				pstmt = conn.prepareStatement(update);
				pstmt.setInt(1, noticeLookup+1);
				pstmt.setInt(2, noticep.getNoticeNumber());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return noticeList;
	}
	

	public void NoticeWriter(HttpServletRequest request) {
		
		String name = "\'" + request.getParameter("noticeName") +"\'";
		String content = "\'" + request.getParameter("noticeContent") +"\'";
		String password = request.getParameter("noticePassword");
		String creator = "\'" + request.getParameter("noticeCreator") +"\'";
		
		String insert = "insert into notice values(notice_sequence.NEXTVAL, "
				+ name +", " + content + ", " + password + ", " + creator + ", " + "sysdate" + ", " + 0 + ")";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(insert);
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}
	
	public NoticeBoard NoticeUpdate(HttpServletRequest request) {
		
		NoticeBoard notice = new NoticeBoard();
		
		notice.setNoticeNumber(Integer.valueOf(request.getParameter("number")));
		notice.setNoticeName(request.getParameter("name"));
		notice.setNoticeContent(request.getParameter("content"));
		notice.setNoticeCreater(request.getParameter("creator"));
		notice.setNoticeLookup(Integer.valueOf(request.getParameter("lookup")));
		
		return notice;
	}
	
	public NoticeBoard noticeUpdater(HttpServletRequest request) {
		
		int number = Integer.valueOf(request.getParameter("noticeNumber"));
		String name = "\'" + request.getParameter("noticeName") + "\'";
		String content = "\'" + request.getParameter("noticeContent") + "\'";
		String creator = "\'" + request.getParameter("noticeCreator") + "\'";
		int lookup = Integer.valueOf(request.getParameter("noticeLookup"));

		String update = "update notice set noticeName = " + name +
						" ,noticeContent = " + content + " ,noticeCreator = " + creator
						+" where noticeNumber = " + number;
		
		NoticeBoard notice = new NoticeBoard();
		notice.setNoticeNumber(number);
		notice.setNoticeName(name);
		notice.setNoticeContent(content);
		notice.setNoticeCreater(creator);
		notice.setNoticeLookup(lookup);
		
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		
		return notice;
	}
	
	public void NoticeDelete(HttpServletRequest request) {
		
		String number = (String) request.getParameter("number");
		System.out.println("number : " + number);
		String delete = "delete from notice where noticeNumber = " + number;

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(delete);
			
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}
	
	public ArrayList<NoticeBoard> mainNoticeList() {
		String select = "SELECT noticenumber, noticename, m.name, noticecontent, noticedate, noticepassword, hit "
				+ "FROM member m, (SELECT ROWNUM num ,noticenumber, noticename, membernumber, noticecontent, "
				+ "noticedate, noticepassword, hit FROM (SELECT * FROM notice ORDER BY noticedate DESC)) "
				+ "sub where m.membernumber = sub.membernumber and num >= 1 AND num <= 5";
		
		ArrayList<NoticeBoard> mainNoticeList = new ArrayList<NoticeBoard>();

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int noticeNumber = rs.getInt(1);
				String noticeName = rs.getString(2);
				String noticeCreater = rs.getString(3);
				String noticeContent = rs.getString(4);
				String noticeDate = rs.getString(5);
				String noticePassword = rs.getString(6);
				int noticeLookup = rs.getInt(7);
				noticeDate = noticeDate.substring(0, 10);
				NoticeBoard notice = new NoticeBoard(noticeNumber, noticeName, noticeContent, noticePassword,
						noticeCreater, noticeDate, noticeLookup);
				mainNoticeList.add(notice);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return mainNoticeList;
	}
}
