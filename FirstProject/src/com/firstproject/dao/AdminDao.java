package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.firstproject.bean.*;

public class AdminDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static AdminDao mDao = new AdminDao();

	private AdminDao() {

	}

	public static AdminDao getInstance() {
		if (mDao == null) {
			mDao = new AdminDao();
		}
		return mDao;
	}
	public int getNoticeSearchCount(String searchName){
		String sqlCount = "select count(*) from notice where noticename like ?";
		int count = 0;
		try {

			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			pstmt.setString(1, "%" + searchName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DBManage.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int getNoticeCount() {

		String sqlCount = "select count(*) from notice";
		int count = 0;
		try {

			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DBManage.close(conn, pstmt, rs);
		}
		return count;
	}
	public void getNoticeWrite(NoticeBoard notice){
		String insert = "insert into notice values (notice_seq.nextval,?,1000,?,sysdate,?,0)";
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, notice.getNoticeName());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticePassword());
			pstmt.executeQuery();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBManage.close(conn, pstmt, rs);
	}
	}
	public ArrayList<NoticeBoard> getNoticeSearch(String noticeSearch ,int startRow, int endRow) {
		String select = "SELECT noticenumber, noticename, m.name, noticecontent, noticedate, noticepassword, hit "
				+ "FROM member m, (SELECT ROWNUM num ,noticenumber, noticename, membernumber, noticecontent, "
				+ "noticedate, noticepassword, hit FROM (SELECT * FROM notice ORDER BY noticenumber DESC) where noticename like ?) "
				+ "sub where m.membernumber = sub.membernumber and num >= ? AND num <= ?";
		ArrayList<NoticeBoard> noticeList = new ArrayList<NoticeBoard>();
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setString(1, "%" + noticeSearch + "%");
			ResultSet rs = pstmt.executeQuery();
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
		String select = "SELECT noticenumber, LEAD(noticenumber, 1, '') OVER (ORDER BY noticenumber DESC) "
				+ "AS NEXT_noticenumber, LAG(noticenumber, 1, '') OVER (ORDER BY noticenumber DESC ) "
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
	
	public NextPrePageControll getDepartmentPageNumber(int pageNum, int departmentnum) {
		String select = "SELECT postnumber, LEAD(postnumber, 1, '') OVER (ORDER BY postnumber DESC) "
				+ "AS NEXT_postnumber, LAG(postnumber, 1, '') OVER (ORDER BY postnumber DESC ) "
				+ "AS  PRE_postnumber FROM departmentboard where departmentnumber = ? ";
		NextPrePageControll page = null;
		int nowPage, nextPage, prePage;
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, departmentnum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				nowPage = rs.getInt(1);
				if(pageNum == nowPage){
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
	
	public ArrayList<NoticeBoard> getNoticeList(int startRow, int endRow) {

		String select = "SELECT noticenumber, noticename, m.name, noticecontent, noticedate, noticepassword, hit "
				+ "FROM member m, (SELECT ROWNUM num ,noticenumber, noticename, membernumber, noticecontent, "
				+ "noticedate, noticepassword, hit FROM (SELECT * FROM notice ORDER BY noticenumber DESC)) "
				+ "sub where m.membernumber = sub.membernumber and num >= ? AND num <= ?";
		ArrayList<NoticeBoard> noticeList = new ArrayList<NoticeBoard>();

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			ResultSet rs = pstmt.executeQuery();
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

	public ArrayList<NoticeBoard> getNoticeReadList(NoticeBoard noticep) {
		String select = "select * from notice where noticenumber=?";
		ArrayList<NoticeBoard> noticeList = new ArrayList<NoticeBoard>();

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, noticep.getNoticeNumber());
			ResultSet rs = pstmt.executeQuery();
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

	public void getNoticeDelete(int noticeNumber) {
		String delete = "delete notice where noticenumber = ?";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, noticeNumber);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}
	public void getNoticeUpdate(NoticeBoard notice) {
		String update = "update notice set noticename = ?, noticecontent = ?, noticedate = sysdate"
				+ " WHERE noticenumber = ?";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, notice.getNoticeName());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNumber());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}

	public int getDepartmentCount(String departmentnum) {

		String sqlCount = "select count(*) from departmentboard d, member m, department de where m.membernumber = d.membernumber and m.departmentnumber = de.departmentnumber and de.departmentnumber = ?";
		int count = 0;
		try {

			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			pstmt.setString(1, departmentnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DBManage.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int getDepartmentSearchCount(String searchName){
		String sqlCount = "select count(*) from departmentboard where postname like ?";
		int count = 0;
		try {

			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			pstmt.setString(1, "%" + searchName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DBManage.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public ArrayList<DepartmentBoard> getDepartmentList(int startRow, int endRow, String departmentnum) {

		String select = "SELECT d.postnumber, m.name, de.dname, d.postname, d.content, d.hit, d.postdate, d.postpassword, d.departmentnumber "
				+ "FROM member m, department de, (SELECT ROWNUM num ,postnumber, postname, membernumber, content, hit, "
				+ "postpassword, postdate, departmentnumber FROM (SELECT * FROM departmentboard where departmentnumber = ? ORDER BY postnumber DESC)) d "
				+ "where m.membernumber = d.membernumber and de.departmentnumber = d.departmentnumber "
				+ "and num >= ? and num <= ? ";
		ArrayList<DepartmentBoard> departmentList = new ArrayList<DepartmentBoard>();

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setString(1, departmentnum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int postNumber = rs.getInt(1);
				String postCreater = rs.getString(2);
				String departmentName = rs.getString(3);
				String postName = rs.getString(4);
				String content = rs.getString(5);
				int postLookup = rs.getInt(6);
				String postDate = rs.getString(7);
				String postPassword = rs.getString(8);

				DepartmentBoard department = new DepartmentBoard(postNumber, departmentName, postName, postDate,
						content, postPassword, postCreater, postLookup);
				department.setDepartmentnum(rs.getInt(9));
				departmentList.add(department);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return departmentList;
	}

	public ArrayList<DepartmentBoard> getDepartmentReadList(DepartmentBoard noticep) {
		String select = "select d.postnumber, m.name, de.dname, d.postname, d.content, d.hit, d.postdate, d.postpassword, d.departmentnumber "
				+ "from departmentboard d, member m, department de "
				+ "where m.membernumber = d.membernumber and de.departmentnumber = d.departmentnumber and d.postnumber = ?";
		ArrayList<DepartmentBoard> departmentList = new ArrayList<DepartmentBoard>();

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, noticep.getPostNumber());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int postNumber = rs.getInt(1);
				String postCreater = rs.getString(2);
				String departmentName = rs.getString(3);
				String postName = rs.getString(4);
				String content = rs.getString(5);
				int postLookup = rs.getInt(6);
				String postDate = rs.getString(7);
				String postPassword = rs.getString(8);
				int departmentnum = rs.getInt(9);
				DepartmentBoard department = new DepartmentBoard(postNumber, departmentName, postName, postDate,
						content, postPassword, postCreater, postLookup);
				department.setDepartmentnum(departmentnum);
				departmentList.add(department);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return departmentList;
	}

	public void getDepartmentDelete(int postNumber) {
		String delete = "delete departmentboard where postnumber = ?";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, postNumber);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}

	public ArrayList<DepartmentBoard> getDepartmentSearch(String departmentSearch, int startRow, int endRow) {
		String select = "SELECT d.postnumber, m.name, de.dname, d.postname, d.content, d.hit, d.postdate, d.postpassword, d.departmentnumber "
				+ "FROM member m, department de, (SELECT ROWNUM num ,postnumber, postname, membernumber, content, hit, "
				+ "postpassword, postdate, departmentnumber FROM (SELECT * FROM departmentboard ORDER BY postnumber DESC) where postname like ?) d "
				+ "where m.membernumber = d.membernumber and d.departmentnumber = de.departmentnumber "
				+ "and num >= ? and num <= ?";
		ArrayList<DepartmentBoard> departmentList = new ArrayList<DepartmentBoard>();
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			pstmt.setString(1, "%" + departmentSearch + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int postNumber = rs.getInt(1);
				String postCreater = rs.getString(2);
				String departmentName = rs.getString(3);
				String postName = rs.getString(4);
				String content = rs.getString(5);
				int postLookup = rs.getInt(6);
				String postDate = rs.getString(7);
				String postPassword = rs.getString(8);
				int departmentnum = rs.getInt(9);
				if(postDate.length() > 10){
				postDate = postDate.substring(0, 10);
				}
				DepartmentBoard department = new DepartmentBoard(postNumber, departmentName, postName, postDate,
						content, postPassword, postCreater, postLookup);
				department.setDepartmentnum(departmentnum);
				departmentList.add(department);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return departmentList;
	}

	public int getDocumentCount() {

		String sqlCount = "select count(*) from notice";
		int count = 0;
		try {

			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlCount);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DBManage.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public ArrayList<DocumentApproval> getDocumentList(int startRow, int endRow) {
		String select = "SELECT d.documentnumber, d.documentname, m.name, d.content, de.dname, p.jobname, "
				+ "d.state, d.createdate, d.pass FROM member m, position p, department de, (SELECT ROWNUM num ,documentnumber, "
				+ "documentname, membernumber, content, createdate, state, pass FROM (SELECT * FROM document ORDER BY "
				+ "documentnumber DESC)) d where m.membernumber = d.membernumber and m.departmentnumber = de.departmentnumber "
				+ "and m.jobnumber = p.jobnumber and num >= ? AND num <= ?";
		ArrayList<DocumentApproval> documentList = new ArrayList<DocumentApproval>();
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int documentNumber = rs.getInt(1);
				String documentName = rs.getString(2);
				String documentCreater = rs.getString(3);
				String documentContent = rs.getString(4);
				String jobName = rs.getString(6);
				int state = rs.getInt(7);
				String createDate = rs.getString(8);
				String password = rs.getString(9);
				createDate = createDate.substring(0, 10);

				DocumentApproval document = new DocumentApproval(documentNumber, documentName, documentCreater,
						jobName ,documentContent, state, createDate, password);
				documentList.add(document);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return documentList;
	}

	public void getDocumentDelete(int documentNumber) {
		String delete = "delete document where documentnumber = ?";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, documentNumber);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}

	public ArrayList<DocumentApproval> getDocumentSearch(String documentSearch) {
		String select = "select d.documentnumber, d.documentname, m.name, d.content, de.dname, p.jobname, d.state, d.createdate, d.pass "
				+ "from document d, member m, position p, department de "
				+ "where d.membernumber = m.membernumber and m.jobnumber = p.jobnumber and m.departmentnumber = de.departmentnumber "
				+ "and d.documentname like ?";
		ArrayList<DocumentApproval> documentList = new ArrayList<DocumentApproval>();
		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(select);
			pstmt.setString(1, "%" + documentSearch + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int documentNumber = rs.getInt(1);
				String documentName = rs.getString(2);
				String documentCreater = rs.getString(3);
				String documentContent = rs.getString(4);
				String jobName = rs.getString(6);
				int state = rs.getInt(7);
				String createDate = rs.getString(8);
				String password = rs.getString(9);
				createDate = createDate.substring(0, 10);

				DocumentApproval document = new DocumentApproval(documentNumber, documentName, documentCreater,
						jobName ,documentContent, state, createDate, password);
				documentList.add(document);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return documentList;
	}
	public DepartmentBoard getDepartmentUpdate
	(String postName, String postPassword,String content,int postNumber) {
		String sql = "UPDATE departmentboard SET postname=?,"
				+ " content=?, postpassword=? "
				+ "WHERE postnumber=?";
		
		try {
			conn = DBManage.getConnection();
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, postName);
			pstmt.setString(2,content);
			pstmt.setString(3, postPassword);
			pstmt.setInt(4, postNumber);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
		return null;
		
	
	}
}
