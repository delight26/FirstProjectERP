package com.firstproject.memberservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.Member;
import com.firstproject.dao.MemberDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberRegistrationResultService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String pImages;
		ServletContext application = request.getServletContext();
		pImages = application.getInitParameter("pImages");
		
		String realPath = application.getRealPath(pImages);

		int maxFileSize = 10 * 1024 * 1024;

		String encoding = "UTF-8";
		Member m = null;
		int membernumber = 0;
		MultipartRequest multi = new MultipartRequest(request, realPath, maxFileSize, encoding,
				new DefaultFileRenamePolicy());
		MemberDao dao = MemberDao.getInstance();
		try{
			membernumber = Integer.parseInt(multi.getParameter("membernumber"));
		} catch(Exception e){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('사원 번호를 숫자로 입력하지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			ERPForwardService forward = new ERPForwardService();
			return forward;
		}
		String name = multi.getParameter("name");
		String password = multi.getParameter("password");
		String phonenumber1 = multi.getParameter("phonenumber1");
		String phonenumber2 = multi.getParameter("phonenumber2");
		String phonenumber3 = multi.getParameter("phonenumber3");
		String phonenumber = phonenumber1 + "-" + phonenumber2 + "-" + phonenumber3;
		String birthday = multi.getParameter("birthday");
		String hiredate = multi.getParameter("hiredate");
		String adress = multi.getParameter("adress");
		int departmentnumber = Integer.parseInt(multi.getParameter("departmentnumber")); 
		int managernumber = Integer.parseInt(multi.getParameter("managernumber")); 
		int jobnumber = Integer.parseInt(multi.getParameter("jobnumber"));
		String fileName;
		String photo;

		if (multi.getFilesystemName("photo") != null) {
			fileName = multi.getFilesystemName("photo");
			photo = fileName.length() > 0 ? request.getContextPath()+pImages + "/" + fileName : "";
			m = new Member(membernumber, name, password, phonenumber, birthday, hiredate, adress, departmentnumber, managernumber, jobnumber, photo);
			
			dao.memberAdd(m);
		
			ERPForwardService forward = new ERPForwardService();
			forward.setView("memberList.member");
			forward.setRedirect(true);
			
			return forward;
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('사진을 등록하지 않았습니다.')");
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
