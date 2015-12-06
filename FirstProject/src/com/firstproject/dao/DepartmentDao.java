package com.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.firstproject.bean.CommentBean;
import com.firstproject.bean.DepartmentBoard;
import com.firstproject.bean.NoticeBoard;

public class DepartmentDao {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	private static DepartmentDao instance = new DepartmentDao();

	private DepartmentDao() {
	}

	public static DepartmentDao getInstance() {
		if (instance == null) {
			instance = new DepartmentDao();
		}
		return instance;
	}
	public void DepartmentInsert(DepartmentBoard dept){
			String insert = "insert into departmentboard values (departmentboard_seq.nextval, ?, ?, ?, 0, sysdate, ?, ?)";
			try {
				conn = DBManage.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insert);
				pstmt.setInt(1, dept.getMemberNumber());
				pstmt.setString(2, dept.getPostName());
				pstmt.setString(3, dept.getContent());
				pstmt.setString(4, dept.getPostPassword());
				pstmt.setInt(5, dept.getDepartmentnum());
				pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt);
		}
	}
	public ArrayList<DepartmentBoard> getDepartmentReadList(DepartmentBoard noticep) {
		String select = "select d.postnumber, m.name, de.dname, d.postname, d.content, d.hit, d.postdate, d.postpassword, d.departmentnumber "
				+ "from departmentboard d, member m, department de "
				+ "where m.membernumber = d.membernumber and d.departmentnumber = de.departmentnumber and d.postnumber = ?";
		String update = "update departmentboard set hit=? where postnumber=?";
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
				pstmt = conn.prepareStatement(update);
				pstmt.setInt(1, postLookup+1);
				pstmt.setInt(2, noticep.getPostNumber());
				pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManage.close(conn, pstmt, rs);
		}
		return departmentList;
	}
	public void commentInsert(CommentBean comment){
	      String insert = "insert into comments values (departmentboard_seq.nextval, ?, ?, sysdate, ?, ?)";
	      try {
	         conn = DBManage.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(insert);
	         pstmt.setString(1, comment.getCommentContent());
	         pstmt.setString(2, comment.getCommentCreator());
	         pstmt.setString(3, comment.getCommentReplyTo());
	         pstmt.setString(4, comment.getPostNum());
	         pstmt.executeQuery();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManage.close(conn, pstmt);
	      }
	   }
	   
	   public ArrayList<CommentBean> getCommentReadList(int postNumber) {
	      String select = "select c.commentNum, c.commentContent, c.commentCreator, "
	            + " (select m.name from member m where c.commentCreator = m.memberNumber), "
	            + " c.commentDate, c.commentReplyTo, "
	            + " (select m.name from member m where c.commentReplyTo = m.memberNumber),"
	            + " c.postNum"
	            + " from comments c where postNum = ?"
	            + " order by c.commentNum";
	      
	      ArrayList<CommentBean> commentList = new ArrayList<CommentBean>();

	      try {
	         
	         conn = DBManage.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(select);
	         pstmt.setInt(1, postNumber);
	         ResultSet rs = pstmt.executeQuery();
	         
	         while (rs.next()) {
	            
	            CommentBean comment = new CommentBean();
	            
	            comment.setCommentNum(rs.getString(1)); 
	            comment.setCommentContent(rs.getString(2));
	            comment.setCommentCreator(rs.getString(3));
	            comment.setCreatorName(rs.getString(4));
	            comment.setCommentDate(rs.getString(5).substring(0, 10));
	            comment.setCommentReplyTo(rs.getString(6));
	            comment.setReplyToName(rs.getString(7));
	            comment.setPostNum(rs.getString(8));
	            
	            commentList.add(comment);
	            
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManage.close(conn, pstmt, rs);
	      }
	      return commentList;
	   }
	   
	   public void commentDelete(String commentNum){
	      String delete = "delete from comments where commentNum = ?";
	      
	      try {
	         conn = DBManage.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(delete);
	         pstmt.setString(1, commentNum);
	         pstmt.executeQuery();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManage.close(conn, pstmt);
	      }
	   }
	   
	   public void commentUpdate(CommentBean comment){
	      String delete = "update comments set commentContent = ?"
	            + " where commentNum = ?";
	      
	      try {
	         conn = DBManage.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(delete);
	         pstmt.setString(1, comment.getCommentContent());
	         pstmt.setString(2, comment.getCommentNum());
	         pstmt.executeQuery();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManage.close(conn, pstmt);
	      }
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
	
}























