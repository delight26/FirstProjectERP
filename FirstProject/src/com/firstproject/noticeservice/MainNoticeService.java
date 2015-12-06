package com.firstproject.noticeservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.NoticeBoard;
import com.firstproject.dao.NoticeDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class MainNoticeService implements ERPServiceInterface {
	
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		ERPForwardService forward = new ERPForwardService();
		NoticeDao dao = NoticeDao.getInstance();
		ArrayList<NoticeBoard> MainNoticeList = dao.mainNoticeList();
		request.setAttribute("MainNoticeList", MainNoticeList);
		forward.setView("./Notice/MainNotice.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
