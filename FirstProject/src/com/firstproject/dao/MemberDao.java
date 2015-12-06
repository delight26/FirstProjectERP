package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.firstproject.bean.Member;

public class MemberDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static MemberDao mDao = new MemberDao();

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (mDao == null) {
			mDao = new MemberDao();
		}
		return mDao;
	}

	public int getMemberCount() {

		String countsql = "SELECT COUNT(*) FROM member";
		int count = 0;

		try {

			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(countsql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return count;
	}
	public int getMemberSearcgCount(String search) {

		String countsql = "SELECT COUNT(*) FROM member where name like ?";
		int count = 0;

		try {

			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(countsql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return count;
	}

	public Member getMember(int membernumber) {

		String sql = "select m.name, m.birthday, m.hiredate, m.password, m.phonenumber, "
				+ "m.adress, d.dname, p.jobname, m.managernumber from member m, department d, position p "
				+ "where m.jobnumber = p.jobnumber and m.departmentnumber = d.departmentnumber "
				+ "and membernumber=?";
		Member member = new Member();
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, membernumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setMembernumber(membernumber);
				member.setName(rs.getString(1));
				String birthday = rs.getString(2);
				birthday = birthday.substring(0, 10);
				member.setBirthday(birthday);
				String hiredate = rs.getString(3);
				hiredate = hiredate.substring(0, 10);
				member.setHiredate(hiredate);
				member.setPassword(rs.getString(4));
				member.setPhonenumber(rs.getString(5));
				member.setAdress(rs.getString(6));
				member.setDname(rs.getString(7));
				member.setManagernumber(rs.getInt(9));
				member.setJobname(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return member;
	}

	public void updateMember(Member mVo) {
		String sql = "update member set " + "password=?, phoneNumber=?, adress=?, photo= ? where membernumber = ?";
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPassword());
			pstmt.setString(2, mVo.getPhonenumber());
			pstmt.setString(3, mVo.getAdress());
			pstmt.setString(4, mVo.getPhoto());
			pstmt.setInt(5, mVo.getMembernumber());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}

	public ArrayList<Member> getMemberList(int startRow,int endRow) {

		//String select = "SELECT m.membernumber, m.name, d.dname, p.jobname, m.phonenumber, m.adress FROM member m, department d, position p WHERE m.departmentnumber = d.departmentnumber and m.jobnumber = p.jobnumber";
		String select = "select * from (SELECT rownum num, m.membernumber, "
				+ "m.name, d.dname, p.jobname, m.phonenumber, m.adress "
				+ "FROM member m, department d, position p "
				+ "WHERE m.departmentnumber = d.departmentnumber and m.jobnumber = p.jobnumber) "
				+ "where num>=? and num <=?";
		ArrayList<Member> memberList = new ArrayList<Member>();

		try {
			conn = DBManage.getConnection();

			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);			

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int cut = 1;
				int membernumber = rs.getInt(++cut);
				String name = rs.getString(++cut);
				String dname = rs.getString(++cut);
				String jobname = rs.getString(++cut);
				String phonenumber = rs.getString(++cut);
				String adress = rs.getString(++cut);
				Member member = new Member(membernumber, name, dname, jobname, phonenumber, adress);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return memberList;
	}

	public ArrayList<Member> getMemberSearchList(int startRow,int endRow, String search) {

		//String select = "SELECT m.membernumber, m.name, d.dname, p.jobname, m.phonenumber, m.adress FROM member m, department d, position p WHERE m.departmentnumber = d.departmentnumber and m.jobnumber = p.jobnumber";
		String select = "select * from (SELECT rownum num, m.membernumber, "
				+ "m.name, d.dname, p.jobname, m.phonenumber, m.adress "
				+ "FROM member m, department d, position p "
				+ "WHERE m.departmentnumber = d.departmentnumber and m.jobnumber = p.jobnumber and m.name like  ?) "
				+ "where num>=? and num <=?";
		ArrayList<Member> memberList = new ArrayList<Member>();

		try {
			conn = DBManage.getConnection();

			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);			

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int cut = 1;
				int membernumber = rs.getInt(++cut);
				String name = rs.getString(++cut);
				String dname = rs.getString(++cut);
				String jobname = rs.getString(++cut);
				String phonenumber = rs.getString(++cut);
				String adress = rs.getString(++cut);
				Member member = new Member(membernumber, name, dname, jobname, phonenumber, adress);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
	public void memberAdd(Member member) {

		String insert = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, member.getMembernumber());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getBirthday());
			pstmt.setString(4, member.getHiredate());
			pstmt.setString(5, member.getPassword());
			pstmt.setString(6, member.getPhonenumber());
			pstmt.setString(7, member.getAdress());
			pstmt.setInt(8, member.getDepartmentnumber());
			pstmt.setInt(9, member.getManagernumber());
			pstmt.setInt(10, member.getJobnumber());
			pstmt.setString(11, member.getPhoto());
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}

	public void memberDelete(int membernumber) {

		String delete = "DELETE member WHERE membernumber = ?";

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, membernumber);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	}

	public ArrayList<Member> getGroupChartList(int departmentnumber) {

		String departmentSelect = "SELECT m.name, m.phonenumber, d.dname, p.jobname, m.photo "
				+ "FROM member m, department d, position p "
				+ "WHERE m.departmentnumber = d.departmentnumber AND m.jobnumber = p.jobnumber "
				+ "AND d.departmentnumber = ? ORDER BY p.jobnumber";

		ArrayList<Member> memberList = new ArrayList<Member>();

		try {
			conn = DBManage.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(departmentSelect);
			pstmt.setInt(1, departmentnumber);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				String phonenumber = rs.getString(2);
				String dname = rs.getString(3);
				String jobname = rs.getString(4);
				String photo = rs.getString(5);
				Member member = new Member(name, phonenumber, dname, jobname, photo);
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return memberList;
	}
}
