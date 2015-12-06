package com.firstproject.adminservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminNoticeDeleteService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		 dao.getNoticeDelete(noticeNumber);
		 ERPForwardService forward = new ERPForwardService();
		forward.setView("/FirstProject/NoticeList.admin");
		forward.setRedirect(true);
		
		return forward;
	}
}
