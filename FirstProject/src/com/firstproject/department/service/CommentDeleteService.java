package com.firstproject.department.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.bean.*;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class CommentDeleteService  implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Member member = (Member) request.getSession().getAttribute("loginUser");
		int memberNumber = member.getMembernumber();
		int id = Integer.parseInt(request.getParameter("id"));
		
		ERPForwardService forward = new ERPForwardService();
		String postNum = request.getParameter("postNumber");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		if(id == memberNumber) {
			DepartmentDao dao = DepartmentDao.getInstance();
			
			String commentNum = request.getParameter("number");
			dao.commentDelete(commentNum);
			
			
			
			forward.setView("DepartmentRead.dept?postNumber=" + postNum +"&deptno=" + deptno);
			forward.setRedirect(true);
			
		} else {
			
			forward.setView("./Department/DepartmentDeleteException.jsp");
			forward.setRedirect(true);
			
		}
		
		return forward;
		
	}
}




