package com.firstproject.documentservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.DocumentApproval;
import com.firstproject.bean.Member;
import com.firstproject.dao.DocumentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DocumentListService implements ERPServiceInterface {
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
		ArrayList<DocumentApproval> docList = null;
		ERPForwardService forward = new ERPForwardService();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('로그아웃 되었습니다.')");
			out.println("parent.location = './LoginMain/LoginForm.jsp';");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			forward.setRedirect(true);
			forward.setView("/index.login");	
		}else{
		Member member = (Member)session.getAttribute("loginUser");
		int membernum = member.getMembernumber();
		DocumentDao dao = DocumentDao.getInstance();
		listCount = dao.getDocumentCount(membernum);
		if(listCount > 0)	docList = dao.getDocList(membernum,startRow,endRow);
		
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endpage = 0;
		if((listCount % PAGE_SIZE) == 0){
				endpage = listCount / PAGE_SIZE;
			}else {
				endpage = listCount / PAGE_SIZE + 1;
			}				
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endpage);
		request.setAttribute("pageGroup", PAGE_GROUP);
		request.setAttribute("listCount", listCount);
		request.setAttribute("docList", docList);				
		forward.setView("./Document/DocumentListForm.jsp");
		forward.setRedirect(false); 		
		}
		return forward;
	}
}
