package com.firstproject.schedule.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.dao.ScheduleDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DeleteScheduleService implements ERPServiceInterface{
	
	public DeleteScheduleService() {}
	
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		String number = request.getParameter("number");
		
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		scheduleDao.getDeleteSchedule(number);
		
		String year = request.getParameter("date").substring(0, 4);
		String month = request.getParameter("date").substring(4, 6);
		int imonth = Integer.parseInt(month);
		imonth--;
		
		ERPForwardService forward = new ERPForwardService();	
		forward.setRedirect(false);
		forward.setView("calendarForm.schedul?year=" + year + "&month=" + imonth);
		return forward;
	}
}
