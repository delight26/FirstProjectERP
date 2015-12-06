package com.firstproject.memberservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.dao.MemberDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class MemberDeleteService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		MemberDao dao = MemberDao.getInstance();
		int membernumber = Integer.parseInt(request.getParameter("membernumber"));
		dao.memberDelete(membernumber);
		
		ERPForwardService forward = new ERPForwardService();
		forward.setView("/memberDeleteList.member");
		forward.setRedirect(false);
		
		return forward;
	}
	
}
