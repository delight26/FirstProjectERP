package com.firstproject.adminservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.bean.NextPrePageControll;
import com.firstproject.dao.AdminDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class AdminDepartmentPreService implements ERPServiceInterface{
	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		AdminDao dao = AdminDao.getInstance();
		int pageNum = Integer.parseInt(request.getParameter("postNumber"));
		int departmentnum = Integer.parseInt(request.getParameter("departmentNum"));
		NextPrePageControll pagenum = dao.getDepartmentPageNumber(pageNum, departmentnum);
		int prePage = pagenum.getPrePage();
		if (prePage != 0) { 
		DepartmentBoard departmentp = new DepartmentBoard(prePage);
		ArrayList<DepartmentBoard> departmentList = dao.getDepartmentReadList(departmentp);
		
		request.setAttribute("departmentList", departmentList);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Admin/AdminDepartmentContentForm.jsp");
		forward.setRedirect(false);

		return forward;
		}
		else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('최신 글 입니다.')");
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
