package com.firstproject.department.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DepartmentUpdateFormService implements ERPServiceInterface {
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		String postName = request.getParameter("postName");
		String content = request.getParameter("content");
		String postPassword = request.getParameter("postPassword");
		
		int deptno=Integer.parseInt(request.getParameter("deptno"));
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		System.out.println(postName);
		DepartmentBoard departmentList = dao.getDepartmentUpdate(postName,postPassword, content, postNumber);

		request.setAttribute("departmentList", departmentList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("DepartmentRead.dept?postNumber="+postNumber+"&deptno="+deptno);
		forward.setRedirect(false);

		return forward;
	}
}
