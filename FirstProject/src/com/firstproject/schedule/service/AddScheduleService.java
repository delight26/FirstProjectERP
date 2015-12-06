package com.firstproject.schedule.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.Member;
import com.firstproject.bean.ScheduleBean;
import com.firstproject.dao.ScheduleDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AddScheduleService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		String scheduleDate = request.getParameter("scheduleDate");
		String scheduleTitle = request.getParameter("scheduleTitle");
		String scheduleContent = request.getParameter("scheduleContent");
		Member  member = (Member)session.getAttribute("loginUser");
		int memberNumber = member.getMembernumber();
		ScheduleBean schedule = new ScheduleBean();
		
		schedule.setScheduleDate(scheduleDate);
		schedule.setScheduleTitle(scheduleTitle);
		schedule.setScheduleContent(scheduleContent);
		schedule.setMemberNumber(memberNumber);
		
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		scheduleDao.addSchedule(schedule);
		
		String year = schedule.getScheduleDate().substring(0, 4);
		String month = schedule .getScheduleDate().substring(4, 6);
		int imonth = Integer.parseInt(month);
		imonth--;
		
		ERPForwardService forward = new ERPForwardService();	
		forward.setRedirect(true);
		forward.setView("calendarForm.schedul?year=" + year + "&month=" + imonth);
		return forward;
	}
}
