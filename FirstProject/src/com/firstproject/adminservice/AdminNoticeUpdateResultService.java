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

public class AdminNoticeUpdateResultService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		String noticeName = request.getParameter("noticeName");
		String noticeContent = request.getParameter("noticeContent");
		String noticePassword = request.getParameter("noticePassword");
		NoticeBoard notice = new NoticeBoard(noticeName, noticeContent, noticeNumber);
		NoticeBoard noticep = new NoticeBoard(noticeNumber);
		ArrayList<NoticeBoard> noticeList = dao.getNoticeReadList(noticep);
		if(noticeList.get(0).getNoticePassword().equals(noticePassword)){
			dao.getNoticeUpdate(notice);
		}
		
		
		ERPForwardService forward = new ERPForwardService();
		forward.setView("NoticeRead.admin?noticeNumber="+noticeNumber);
		forward.setRedirect(true);

		return forward;
	}
}
