package com.firstproject.department.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.CommentBean;
import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class CommentUpdateService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DepartmentDao dao = DepartmentDao.getInstance();
		
		String postNum = request.getParameter("postNumber");
		String commentNumber = request.getParameter("number"); 
		String commentContent = request.getParameter("content");
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		
		System.out.println(postNum);
		System.out.println(commentNumber);
		System.out.println(commentContent);
		
		CommentBean comment = new CommentBean();
		comment.setCommentNum(commentNumber);
		comment.setCommentContent(commentContent);
		
		dao.commentUpdate(comment);
	
		ERPForwardService forward = new ERPForwardService();
		forward.setView("DepartmentRead.dept?postNumber=" + postNum+"&deptno="+deptno);
		forward.setRedirect(true);

		return forward;
	}
}
