package com.firstproject.memberservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstproject.bean.Member;
import com.firstproject.dao.MemberDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberUpdateService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String pImages;
		ServletContext application = request.getServletContext();
		pImages = application.getInitParameter("pImages");

		String realPath = application.getRealPath(pImages);

		int maxFileSize = 10 * 1024 * 1024;

		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, realPath, maxFileSize, encoding,
				new DefaultFileRenamePolicy());
		ERPForwardService forward = new ERPForwardService();
		request.setCharacterEncoding("UTF-8");
		String photo, fileName;
		int memberNumber = Integer.valueOf(multi.getParameter("membernumber"));
		String password = multi.getParameter("password");
		String phoneNumber1 = multi.getParameter("phonenumber1");
		String phoneNumber2 = multi.getParameter("phonenumber2");
		String phoneNumber3 = multi.getParameter("phonenumber3");
		String adress = multi.getParameter("adress");
		String phoneNumber = phoneNumber1 + "-" + phoneNumber2 + "-" + phoneNumber3;
		if (multi.getFilesystemName("photo") == null) {
			fileName = "";
			photo = fileName.length() > 0 ? request.getContextPath() + pImages + "/" + fileName : "";
		} else {
			fileName = multi.getFilesystemName("photo");
			photo = fileName.length() > 0 ? request.getContextPath() + pImages + "/" + fileName : "";
		}

		if (photo.equals("")) {
			System.out.println("파일이 업로드 되지 않았음");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("alert('사진을 선택하지 않았습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			return forward;
		} else {

			Member member = new Member();
			member.setMembernumber(memberNumber);
			member.setPassword(password);
			member.setPhonenumber(phoneNumber);
			member.setAdress(adress);
			member.setPhoto(photo);

			MemberDao mDao = MemberDao.getInstance();

			mDao.updateMember(member);

			forward.setView("mainTemplateIndex.jsp");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("parent.location = 'mainTemplateIndex.jsp'");
			out.println("</script>");
			out.println("</head>");
			out.println("</html>");
			out.close();
			forward.setRedirect(true);
			return forward;
		}
	}
}
