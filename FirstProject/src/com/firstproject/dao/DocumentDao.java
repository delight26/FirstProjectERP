package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.firstproject.bean.DocumentApproval;
import com.firstproject.bean.ProjectManager;

public class DocumentDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static DocumentDao instance = new DocumentDao();

	private DocumentDao() {
	}

	public static DocumentDao getInstance() {
		if (instance == null) {
			instance = new DocumentDao();
		}
		return instance;
	}

	public ArrayList<DocumentApproval> getDocList(int membernum, int startRow, int endRow) {
		String select = "select * from (select rownum num, d.documentnumber, "
				+ "d.documentname, m.name, d.content, d.state, d.createdate,"
				+ " d.pass, m2.name as manager "
				+ "from document d, member m, member m2 "
				+ "where m.membernumber = d.managernumber "
				+ "and m2.membernumber = d.membernumber "
				+ "and d.managernumber= ? order by d.DOCUMENTNUMBER desc ) "
				+ "where num >= ? and num <= ?";
		ArrayList<DocumentApproval> docList = new ArrayList<DocumentApproval>();
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, membernum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cut=1;
				int docnum = rs.getInt(++cut);
				String docname = rs.getString(++cut);
				String creater = rs.getString(++cut);
				String content = rs.getString(++cut);
				int state = rs.getInt(++cut);
				String date = rs.getString(++cut);
				date = date.substring(0, 10);
				String pass = rs.getString(++cut);
				String manager = rs.getString(++cut);
				DocumentApproval da = new DocumentApproval(docnum, docname, creater, content, manager, state, date,
						pass);
				docList.add(da);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return docList;
	}

	public int getManagerNum(String membername) {
		String select = "select membernumber from member where name =?";
		int membernum = 0;
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, membername);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				membernum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return membernum;
	}

	public void getInsertDocument(DocumentApproval da) {
		String select = "insert into document values (document_seq.nextval, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, da.getDocumentName());
			pstmt.setInt(2, da.getMemberNumber());
			pstmt.setString(3, da.getDocumentContent());
			pstmt.setString(4, da.getPassword());
			pstmt.setInt(5, da.getManagerNumber());
			pstmt.setString(6, da.getFilePath());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}

	public DocumentApproval getContentDocument(int docnum) {
		String select = "select d.documentnumber, d.documentname, m.name, d.content, d.state, d.createdate, "
				+ "d.pass, m2.name, d.filepath from document d, member m, member m2 "
				+ "where m.membernumber = d.managernumber and m2.membernumber = d.membernumber "
				+ "and d.documentnumber= ?";
		DocumentApproval da = new DocumentApproval();
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, docnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				da.setDocumentNumber(rs.getInt(1));
				da.setDocumentName(rs.getString(2));
				da.setDocumentCreater(rs.getString(3));
				da.setDocumentContent(rs.getString(4));
				da.setState(rs.getInt(5));
				da.setCreateDate(rs.getString(6));
				da.setPassword(rs.getString(7));
				da.setManagerName(rs.getString(8));
				da.setFilePath(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return da;
	}

	public void getApprovalUpdate(int docnum) {
		String update = "update document set state=1 where documentnumber=?";
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, docnum);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}
	public int getDocumentCount(int membernum){
		int count=0;
		String query = "select count(*) from document where managernumber = ?";
		
		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(++count, membernum);
			rs = pstmt.executeQuery();
			if(rs.next()) count = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("SQLException : getDocumentCount");
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
	
		return count;
	}
	
	public void deleteDocument(int documentNumber){
		String query = "DELETE FROM document WHERE DOCUMENTNUMBER = ?";

		try {
			conn = DBManage.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, documentNumber);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQLException : deleteDocument");
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}
}
