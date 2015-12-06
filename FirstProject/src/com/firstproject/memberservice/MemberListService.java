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

public class MemberListService extends MemberDeleteListService implements ERPServiceInterface {

}


/*
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
	ArrayList<Member> memberList = null;
	MemberDao dao = MemberDao.getInstance();
	listCount = dao.getMemberCount();
	if (listCount > 0) {
		memberList = dao.getMemberList(startRow,endRow);
	}
	request.setAttribute("memberList", memberList);
	
	ERPForwardService forward = new ERPForwardService();
	forward.setView("../Admin/AdminMemberListForm.jsp");
	forward.setRedirect(false); 
	return forward;
}
*/