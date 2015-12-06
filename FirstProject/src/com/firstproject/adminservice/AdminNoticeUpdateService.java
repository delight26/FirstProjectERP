package com.firstproject.adminservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.NoticeBoard;
import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminNoticeUpdateService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		NoticeBoard noticep = new NoticeBoard(noticeNumber);
		ArrayList<NoticeBoard> noticeList = dao.getNoticeReadList(noticep);
		
		request.setAttribute("noticeList", noticeList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Admin/AdminNotieUpdateForm.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
