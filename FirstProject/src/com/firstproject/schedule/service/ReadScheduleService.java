package com.firstproject.schedule.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.ScheduleBean;
import com.firstproject.dao.ScheduleDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class ReadScheduleService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		
		ScheduleBean schedule = new ScheduleBean();
		
		ScheduleDao scheduleDao = ScheduleDao.getInstance();
		schedule = scheduleDao.getReadSchedule(request.getParameter("number"));
		
		request.setAttribute("schedule", schedule);
		
		ERPForwardService forward = new ERPForwardService();	
		forward.setRedirect(false);
		forward.setView("./Calendar/readSchedule.jsp");
		return forward;
	}
}

