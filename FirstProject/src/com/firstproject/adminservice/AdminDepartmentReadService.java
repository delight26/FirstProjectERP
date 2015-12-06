package com.firstproject.adminservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminDepartmentReadService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int postNumber = Integer.parseInt(request.getParameter("postNumber"));
		DepartmentBoard noticep = new DepartmentBoard(postNumber);
		ArrayList<DepartmentBoard> departmentList = dao.getDepartmentReadList(noticep);
		
		request.setAttribute("departmentList", departmentList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Admin/AdminDepartmentContentForm.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
