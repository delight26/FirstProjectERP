package com.firstproject.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.Member;
import com.firstproject.dao.LoginDao;
import com.firstproject.dao.MemberDao;

public class LoginService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		LoginDao lDao = LoginDao.getInstance();
		MemberDao mDao=MemberDao.getInstance();
		int membernumber=0;
		try{
		membernumber = Integer.valueOf(request.getParameter("membernumber"));
		}catch(Exception e){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('사원 번호를 확인해 주세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			ERPForwardService forward = new ERPForwardService();
			return forward;
		}
		String password = request.getParameter("password");
		ERPForwardService forward = new ERPForwardService();

		int result = lDao.userCheck(membernumber, password);
		if (result == 1) {
			Member member = mDao.getMember(membernumber);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			session.setAttribute("isLogin", true);
			if (membernumber == 1000) {
				forward.setView("/FirstProject/mainTemplateIndex.jsp");
				forward.setRedirect(true);
			} else {
				forward.setView("/FirstProject/mainTemplateIndex.jsp");
				forward.setRedirect(true);
			}
		} else if (result == 0) {
			forward.setView("/FirstProject/LoginMain/LoginForm.jsp");
			forward.setRedirect(true);
		} else if (result == -1) {
			forward.setView("/FirstProject/LoginMain/LoginForm.jsp");
			forward.setRedirect(true);
		}
		return forward;
	}
}
