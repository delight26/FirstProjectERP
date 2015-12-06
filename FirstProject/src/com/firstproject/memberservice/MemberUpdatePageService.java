package com.firstproject.memberservice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.Member;
import com.firstproject.dao.MemberDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class MemberUpdatePageService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		ERPForwardService forward = new ERPForwardService();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null){
			forward.setView("index.login");
			forward.setRedirect(false);
		}else{
		Member member1 = (Member) session.getAttribute("loginUser");
		int membernumber = member1.getMembernumber();
		MemberDao mDao = MemberDao.getInstance();

		Member member = mDao.getMember(membernumber);
		request.setAttribute("member", member);
		forward.setView("./Member/MemberUpdateForm.jsp");
		forward.setRedirect(false);
		}
		return forward;
	}
}
