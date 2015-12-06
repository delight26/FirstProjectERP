package com.firstproject.department.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DepartmentWriteResult implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DepartmentDao dao = DepartmentDao.getInstance();
		String title = request.getParameter("txtTitle");
		int membernum = Integer.parseInt(request.getParameter("membernum"));
		int deptno = Integer.parseInt(request.getParameter("dept"));
		ERPForwardService forward = new ERPForwardService();		
		if(deptno == 0){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('부서를 입력해주세요.')");
			out.println("history.back();");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			forward.setRedirect(true);
			forward.setView("/departmentList.dept");
		}else{
		String pass = request.getParameter("pass");
		String content = request.getParameter("content");
		DepartmentBoard dept = new DepartmentBoard(title, membernum, deptno, content, pass);
		dao.DepartmentInsert(dept);
			
			forward.setView("departmentList.dept");
			forward.setRedirect(true);
		}
			return forward;
		}
	}
