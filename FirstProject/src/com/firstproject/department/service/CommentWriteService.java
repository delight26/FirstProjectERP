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

public class CommentWriteService  implements ERPServiceInterface {
	
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("asdfasdfasdfasdf");
		DepartmentDao dao = DepartmentDao.getInstance();
		String commentContent = request.getParameter("comment");
		String commentCreator = request.getParameter("creator");
		String commentReplyTo = request.getParameter("replyTo");
		
		String postNum = request.getParameter("postNumber");
		System.out.println(postNum+1);
		
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno+1);
		
		CommentBean comment = new CommentBean("", commentContent, commentCreator, "",
				commentReplyTo, postNum);
		
		dao.commentInsert(comment);
			ERPForwardService forward = new ERPForwardService();
			forward.setView("DepartmentRead.dept?postNumber=" + postNum+"&deptno="+deptno);
			forward.setRedirect(true);

			return forward;
	}
}
