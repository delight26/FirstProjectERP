package com.firstproject.department.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.AdminDao;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DepartmentDeleteService implements ERPServiceInterface {
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DepartmentDao dao = DepartmentDao.getInstance();

		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		
		 dao.getDepartmentDelete(postNumber);

		
		ERPForwardService forward = new ERPForwardService();
		forward.setView("departmentList.dept");
		forward.setRedirect(false);

		return forward;
	}

}
