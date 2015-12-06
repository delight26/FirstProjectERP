package com.firstproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.department.service.*;
import com.firstproject.noticeservice.*;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

@WebServlet({ "*.notice", "*.dept" })
public class NoticeDepartmentServlet extends HttpServlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String result = "";
		ERPForwardService forward = null;
		ERPServiceInterface service = null;
		switch (command) {
		case "/noticeBoardList.notice":
			result = "/noticeBoardList.notice";
			service = new NoticeListService();
			forward = service.Process(request, response);
			break;
		case "/noticeRead.notice":
			result = "/noticeRead.notice";
			service = new NoticeReadService();
			forward = service.Process(request, response);
			break;
		case "/nextNotice.notice":
			result = "nextNotice.notice";
			service = new NoticeNextService();
			forward = service.Process(request, response);
			break;
		case "/preNotice.notice":
			result = "preNotice.notice";
			service = new NoticePreService();
			forward = service.Process(request, response);
			break;
		case "/NoticeSearch.notice":
			result = "SearchNotice.notice";
			service = new NoticeSearchService();
			forward = service.Process(request, response);
			break;
		case "/mainNotice.notice":
			result = "mainNotice.notice";
			service = new MainNoticeService();
			forward = service.Process(request, response);
			break;
		}
		
		
		switch (command) {
		case "/departmentList.dept":
			result="departmentList.dept";
			service = new DepartmentListService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentDelete.dept":
			result="departmentList.dept";
			service = new DepartmentDeleteService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentRead.dept":
			result = "departmentList.dept";
			service = new DepartmentReadService();
			forward = service.Process(request, response);
			break;
		case "/nextDepartment.dept":
			result = "departmentList.dept";
			service = new DepartmentNextService();
			forward = service.Process(request, response);
			break;
		case "/preDepartment.dept":
			result = "departmentList.dept";
			service = new DepartmentPreService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentSearch.dept":
			result = "DepartmentSearch.dept";
			service = new DepartmentSearchService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentWrite.dept":
			forward = new ERPForwardService();
			forward.setView("./Department/DepartmentWriteForm.jsp");
			forward.setRedirect(false);
			break;
		case "/DepartmentWriteResult.dept":
			result = "DepartmentWriteResult.dept";
			service = new DepartmentWriteResult();
			forward = service.Process(request, response);
			break;
		case "/CommentWriteService.dept":
			result = "CommentWriteService.dept";
			service = new CommentWriteService();
			forward = service.Process(request, response);
			break;
		case "/CommentDeleteService.dept":
			result = "CommentDeleteService.dept";
			service = new CommentDeleteService();
			forward = service.Process(request, response);
			break;
		case "/CommentUpdateService.dept":
			result = "CommentUpdateService.dept";
			service = new CommentUpdateService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentUpdate.dept":
			result = "departmentList.dept";
			service = new DepartmentUpdateService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentUpdateForm.dept":
			result = "departmentList.dept";
			service = new DepartmentUpdateFormService();
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
