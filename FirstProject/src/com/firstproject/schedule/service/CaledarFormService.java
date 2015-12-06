package com.firstproject.schedule.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.Member;
import com.firstproject.bean.ScheduleBean;
import com.firstproject.dao.ScheduleDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class CaledarFormService implements ERPServiceInterface {
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
		Member  member = (Member)session.getAttribute("loginUser");
		int memberNumber = member.getMembernumber();
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		scheduleList = scheduleDao.getCalendarForm(memberNumber);
		request.setAttribute("scheduleList", scheduleList);

		ERPForwardService forward = new ERPForwardService();
		forward.setRedirect(false);
		forward.setView("./Calendar/calendarForm.jsp");
		return forward;
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('로그아웃 되었습니다.')");
			out.println("parent.location = './LoginMain/LoginForm.jsp';");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			ERPForwardService forward = new ERPForwardService();
			forward.setRedirect(true);
			forward.setView("/index.login");
			return forward;
		}
	}
}
