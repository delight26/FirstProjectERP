package com.firstproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.documentservice.*;
import com.firstproject.projectservice.*;
import com.firstproject.schedule.service.*;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

@WebServlet({ "*.schedul","*.project", "*.doc" })
public class ScheduleProjectServlet extends HttpServlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String result = "";
		ERPForwardService forward = null;
		ERPServiceInterface service = null;
		switch (command) {
		case "/calendarForm.schedul":
			result = "calendarForm.schedul";
			service = new CaledarFormService();
			forward = service.Process(request, response);
			break;
		case "/addSchedule.schedul":
			result = "addSchedule.schedul";
			forward = new ERPForwardService();
			forward.setRedirect(false);
			forward.setView("./Calendar/addScheduleForm.jsp");
			break;
		case "/addScheculeService.schedul":
			result = "addScheduleService.schedul";
			service = new AddScheduleService();
			forward = service.Process(request, response);
			break;
		case "/readSchedule.schedul":
			result = "readSchedule.schedul";
			service = new ReadScheduleService();
			forward = service.Process(request, response);
			break;
		case "/updateSchedule.schedul":
			result = "updateSchedule.schedul";
			service = new ReadScheduleService();
			forward = service.Process(request, response);
			forward.setView("./Calendar/updateScheduleForm.jsp");
			break;
		case "/updateScheculeService.schedul":
			result = "updateScheculeService.schedul";
			service = new UpdateScheduleService();
			forward = service.Process(request, response);
			break;
		case "/deleteSchedule.schedul":
			result = "deleteSchedule.schedul";
			service= new DeleteScheduleService();
			forward = service.Process(request, response);
			break;
		case "/todaySchedule.schedul":
			result = "todaySchedule.schedul";
			service = new CaledarFormService();
			forward = service.Process(request, response);
			forward.setView("./Calendar/todaySchedule.jsp");
			break;
		}
		switch (command) {
		case "/listProject.project":
			result = "listProject.project";
			service= new ListProjectService();
			forward = service.Process(request, response);
			break;
		case "/ProjectRead.project":
			result = "ProjectRead.project";
			service= new ContentProjectService();
			forward = service.Process(request, response);
			break;
		case "/ProjectWrite.project":
			result = "ProjectWrite.project";
			forward = new ERPForwardService();
			forward.setRedirect(false);
			forward.setView("./Project/ProjectWriteForm.jsp");
			break;
		case "/ProjectWriteResult.project":
			result = "ProjectWriteResult.project";
			service= new WriteProjectService();
			forward = service.Process(request, response);
			break;
		case "/ProjectUpdate.project":
			result = "ProjectUpdate.project";
			service= new UpdateProjectService();
			forward = service.Process(request, response);
			break;
		case "/ProjectUpdateResult.project":
			result = "ProjectUpdateResult.project";
			service= new UpdateResultProjectService();
			forward = service.Process(request, response);
			break;
		case "/mainProject.project":
			result = "mainProject.project";
			service= new MainProjectService();
			forward = service.Process(request, response);
			break;
		}
		switch (command) {
		case "/listdocument.doc":
			result = "listdocument.doc";
			service= new DocumentListService();
			forward = service.Process(request, response);
			break;
		case "/writedocument.doc":
			result = "writedocument.doc";
			forward = new ERPForwardService();
			forward.setRedirect(false);
			forward.setView("./Document/DocumentWriteForm.jsp");
			break;
		case "/writedocumentresult.doc":
			result = "writedocumentresult.doc";
			service= new DocumentWriteService();
			forward = service.Process(request, response);
			break;
		case "/DocumentRead.doc":
			result = "DocumentRead.doc";
			service= new DocumentContentService();
			forward = service.Process(request, response);
			break;
		case "/DocumentApproval.doc":
			result = "DocumentApproval.doc";
			service= new DocumentApprovalService();
			forward = service.Process(request, response);
			break;
		case "/DocumentDelete.doc":
			result = "DocumentDelete.doc";
			service= new DocumentDeleteService();
			forward = service.Process(request, response);
			break;
		}
		System.out.println(result);
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getView());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getView());
				rd.forward(request, response);
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('페이지가 비었습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
