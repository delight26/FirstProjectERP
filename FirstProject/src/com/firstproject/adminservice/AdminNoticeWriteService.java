package com.firstproject.adminservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.NoticeBoard;
import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminNoticeWriteService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		String noticeName = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		String noticePassword = request.getParameter("pass");
		NoticeBoard notice = new NoticeBoard(noticeName, noticeContent, noticePassword);

		dao.getNoticeWrite(notice);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("../NoticeList.admin");
		forward.setRedirect(true);

		return forward;
	}
}
