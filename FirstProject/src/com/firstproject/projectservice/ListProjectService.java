package com.firstproject.projectservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.ProjectManager;
import com.firstproject.dao.ProjectDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class ListProjectService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ArrayList<ProjectManager> projectList = null;
		ProjectDao dao = ProjectDao.getInstance();
		projectList = dao.getListProject();
		request.setAttribute("projectList", projectList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Project/ProjectShowForm.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
