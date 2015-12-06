package com.firstproject.department.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.CommentBean;
import com.firstproject.bean.DepartmentBoard;
import com.firstproject.bean.NextPrePageControll;
import com.firstproject.dao.AdminDao;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DepartmentNextService  implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao daoad = AdminDao.getInstance();
		DepartmentDao daode = DepartmentDao.getInstance();
		int pageNum = Integer.valueOf(request.getParameter("postNumber"));
		int departmentnum = Integer.valueOf(request.getParameter("departmentNum"));
		NextPrePageControll pagenum = daoad.getDepartmentPageNumber(pageNum, departmentnum);
		int nextPage = pagenum.getNextPage();
		if (nextPage != 0) { 
		DepartmentBoard departmentp = new DepartmentBoard(nextPage);
		ArrayList<DepartmentBoard> departmentList = daode.getDepartmentReadList(departmentp);
		
		ArrayList<CommentBean> commentList = daode.getCommentReadList(nextPage);
	      request.setAttribute("commentList", commentList);
		
		request.setAttribute("departmentList", departmentList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Department/DepartmentContentForm.jsp");
		forward.setRedirect(false);

		return forward;
		}else{
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
