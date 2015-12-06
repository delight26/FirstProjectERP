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

public class AdminNoticeListService implements ERPServiceInterface {
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = currentPage * PAGE_SIZE - (PAGE_SIZE - 1);
		int endRow = startRow + PAGE_SIZE - 1;
		int listCount = 0;
		ArrayList<NoticeBoard> noticeList = null;
		AdminDao dao = AdminDao.getInstance();
		listCount = dao.getNoticeCount();
		if (listCount > 0) {
			noticeList = dao.getNoticeList(startRow, endRow);
		}
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endpage = startPage + PAGE_GROUP - 1;
		if (endpage > pageCount) {
			endpage = pageCount;
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endpage);
		request.setAttribute("pageGroup", PAGE_GROUP);
		request.setAttribute("listCount", listCount);
		request.setAttribute("noticeList", noticeList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Admin/AdminNoticeForm.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
