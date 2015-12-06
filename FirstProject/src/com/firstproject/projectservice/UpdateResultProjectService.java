package com.firstproject.projectservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.ProjectManager;
import com.firstproject.dao.ProjectDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class UpdateResultProjectService implements ERPServiceInterface {

		@Override
		public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			String projectName = request.getParameter("projectName");
			int projectNum = Integer.valueOf(request.getParameter("projectNumber"));
			String memberNum = request.getParameter("managernum");
			String startDate = request.getParameter("startdate");
			String endDate = request.getParameter("enddate");
			String comment = request.getParameter("comment");
			ProjectManager pm = new ProjectManager(projectNum, projectName, memberNum,comment , startDate, endDate);
			ProjectDao dao = ProjectDao.getInstance();
			dao.getUpdateProject(pm);
			ERPForwardService forward = new ERPForwardService();
			forward.setView("listProject.project");
			forward.setRedirect(true);

			return forward;
		}
}
