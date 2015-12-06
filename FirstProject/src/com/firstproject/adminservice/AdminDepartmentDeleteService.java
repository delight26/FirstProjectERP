package com.firstproject.adminservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminDepartmentDeleteService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		 dao.getDepartmentDelete(postNumber);
		 ERPForwardService forward = new ERPForwardService();
		forward.setView("DepartmentList.admin");
		forward.setRedirect(true);
		
		return forward;
	}
}
