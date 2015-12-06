package com.firstproject.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.adminservice.*;
import com.firstproject.memberservice.*;
import com.firstproject.service.*;

@WebServlet({ "*.admin", "*.login", "*.member" })
public class MemberLoginAdminServlet extends HttpServlet {

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String command = uri.substring(uri.lastIndexOf("/"));
		String result = "";
		ERPForwardService forward = null;
		ERPServiceInterface service = null;
		switch (command) {
		case "/AdminMain.admin":
			result = "AdminMain.admin";
			forward = new ERPForwardService();
			forward.setView("/FirstProject/Admin/AdminMainForm.jsp");
			forward.setRedirect(false);
			break;
		case "/NoticeList.admin":
			result = "NoticeList.admin";
			service = new AdminNoticeListService();
			forward = service.Process(request, response);
			break;
		case "/NoticeRead.admin":
			result = "NoticeRead.admin";
			service = new AdminNoticeReaderService();
			forward = service.Process(request, response);
			break;
		case "/NoticeDelete.admin":
			result = "NoticeDelete.admin";
			service = new AdminNoticeDeleteService();
			forward = service.Process(request, response);
			break;
		case "/nextNotice.admin":
			result = "nextNotice.admin";
			service = new AdminNoticeNextService();
			forward = service.Process(request, response);
			break;
		case "/preNotice.admin":
			result = "preNotice.admin";
			service = new AdminNoticePreService();
			forward = service.Process(request, response);
			break;
		case "/NoticeSearch.admin":
			result = "SearchNotice.admin";
			service = new AdminNoticeSearchService();
			forward = service.Process(request, response);
			break;
		case "/NoticeUpdate.admin":
			result = "NoticeUpdate.admin";
			service = new AdminNoticeUpdateService();
			forward = service.Process(request, response);
			break;
		case "/NoticeUpdateResult.admin":
			result = "NoticeUpdate.admin";
			service = new AdminNoticeUpdateResultService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentList.admin":
			result = "DepartmentList.admin";
			service = new AdminDepartmentListService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentRead.admin":
			result = "DepartmentRead.admin";
			service = new AdminDepartmentReadService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentDelete.admin":
			result = "DepartmentDelete.admin";
			service = new AdminDepartmentDeleteService();
			forward = service.Process(request, response);
			break;
		case "/nextDepartment.admin":
			result = "nextDepartment.admin";
			service = new AdminDepartmentNextService();
			forward = service.Process(request, response);
			break;
		case "/preDepartment.admin":
			result = "preDepartment.admin";
			service = new AdminDepartmentPreService();
			forward = service.Process(request, response);
			break;
		case "/DepartmentSearch.admin":
			result = "DepartmentSearch.admin";
			service = new AdminDepartmentSearchService();
			forward = service.Process(request, response);
			break;
		case "/NoticeWrite.admin":
			result = "NoticeWrite.admin";
			service = new AdminNoticeWriteService();
			forward = service.Process(request, response);
			break;
		}
		switch (command) {
		case "/index.login":
			forward = new ERPForwardService();
			forward.setView("/LoginMain/LoginForm.jsp");
			forward.setRedirect(false);
			break;
		case "/login.login":
			result = "login.login";
			service = new LoginService();
			forward = service.Process(request, response);
			break;
		case "/logout.login":
			result = "logout.login";
			HttpSession session = request.getSession();
			session.invalidate();
			forward = new ERPForwardService();
			forward.setView("/FirstProject/LoginMain/LoginForm.jsp");
			forward.setRedirect(true);
			break;
		}
		switch (command) {
		case "/memberupdatepage.member":
			result = "memberupdatepage.member";
			service = new MemberUpdatePageService();
			forward = service.Process(request, response);
			break;
		case "/memberupdate.member":
			result = "memberupdatepage.member";
			service = new MemberUpdateService();
			forward = service.Process(request, response);
			break;
		case "/memberDeleteList.member":
			result = "memberDeleteList.member";
			service = new MemberDeleteListService();
			forward = service.Process(request, response);
			break;
		case "/memberDeleteResult.member":
			result = "memberDeleteResult.member";
			service = new MemberDeleteService();
			forward = service.Process(request, response);
			break;
		case "/memberRegistrationResult.member":
			result = "memberRegistrationResult.member";
			service = new MemberRegistrationResultService();
			forward = service.Process(request, response);
			break;
		case "/memberList.member":
			result = "memberList.member가 요청됨";
			service = new MemberListService();
			forward = service.Process(request, response);
			break;
		case "/groupChartList.member":
			result = "groupChartList.member";
			service = new groupChartListService();
			forward = service.Process(request, response);
			break;
		case "/groupChart.member":
			forward = new ERPForwardService();
			forward.setView("./Member/groupChart.jsp");
			forward.setRedirect(false);
			break;
		case "/memberSearch.member":
			result = "memberSearch.member";
			service = new MemberSearchService();
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
