package com.firstproject.noticeservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.NextPrePageControll;
import com.firstproject.bean.NoticeBoard;
import com.firstproject.dao.NoticeDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class NoticeNextService implements ERPServiceInterface {
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		NoticeDao dao = NoticeDao.getInstance();
		int pageNum = Integer.parseInt(request.getParameter("noticeNumber"));
		NextPrePageControll pagenum = dao.getNoticePageNumber(pageNum);
		int nextPage = pagenum.getNextPage();
		if (nextPage != 0) { 
			NoticeBoard noticep = new NoticeBoard(nextPage);
			ArrayList<NoticeBoard> noticeList = dao.getNoticeRead(noticep);

			request.setAttribute("noticeList", noticeList);
			ERPForwardService forward = new ERPForwardService();
			forward.setView("./Notice/NoticeContentForm.jsp");
			forward.setRedirect(false);

			return forward;
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('마지막 글 입니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			ERPForwardService forward = new ERPForwardService();
			return forward;
		}
	}
}
