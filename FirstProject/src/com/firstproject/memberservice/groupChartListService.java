package com.firstproject.memberservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.Member;
import com.firstproject.dao.MemberDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class groupChartListService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int departmentnumber;
		MemberDao dao = MemberDao.getInstance();
		if(request.getParameter("departmentnumber")==null){
			departmentnumber = 10;
		}
		departmentnumber = Integer.parseInt(request.getParameter("departmentnumber"));
		
		ArrayList<Member> memberList = dao.getGroupChartList(departmentnumber);
		request.setAttribute("memberList", memberList);
		
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Member/groupChartResult.jsp");
		forward.setRedirect(false); 
		return forward;
	}

}
