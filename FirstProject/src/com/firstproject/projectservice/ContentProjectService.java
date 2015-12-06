package com.firstproject.projectservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.ProjectManager;
import com.firstproject.dao.ProjectDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class ContentProjectService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ProjectDao dao = ProjectDao.getInstance();
		ProjectManager pm = new ProjectManager();
		int projectnum = Integer.valueOf(request.getParameter("projectnum"));
		pm = dao.getReadProject(projectnum);
		request.setAttribute("pm", pm);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Project/ProjectContentForm.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
