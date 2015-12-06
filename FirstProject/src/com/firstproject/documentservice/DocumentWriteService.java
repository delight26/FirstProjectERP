package com.firstproject.documentservice;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DocumentApproval;
import com.firstproject.dao.DocumentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DocumentWriteService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String filePath;
		ServletContext application = request.getServletContext();
		filePath = application.getInitParameter("filePath");
		
		String realPath = application.getRealPath(filePath);

		int maxFileSize = 10 * 1024 * 1024;

		String encoding = "UTF-8";
		DocumentApproval da = null;
		MultipartRequest multi = new MultipartRequest(request, realPath, maxFileSize, encoding,	new DefaultFileRenamePolicy());
		DocumentDao dao = DocumentDao.getInstance();
		int managernum=0;
		String managers ="";
		try{
			managernum = Integer.parseInt(multi.getParameter("manager"));
		}catch(Exception e){
			managers = multi.getParameter("manager");
			managernum = dao.getManagerNum(managers);
		}
		int membernum = Integer.valueOf(multi.getParameter("membernum"));
		String docname = multi.getParameter("doctitle");
		String pass = multi.getParameter("pass");
		String contnet = multi.getParameter("content");
		String fileName;
		String path;

		if (multi.getFilesystemName("filepath") != null) {
			fileName = multi.getFilesystemName("filepath");
			path = request.getContextPath()+filePath + "/" + fileName;
			da = new DocumentApproval(docname, managernum, membernum, contnet, pass, path);
			dao.getInsertDocument(da);
			ERPForwardService forward = new ERPForwardService();
			forward.setView("listdocument.doc");
			forward.setRedirect(true);
			
			return forward;
		}else{
			path = "";
			da = new DocumentApproval(docname, managernum, membernum, contnet, pass, path);
			dao.getInsertDocument(da);
			ERPForwardService forward = new ERPForwardService();
			forward.setView("listdocument.doc");
			forward.setRedirect(true);
			return forward;
		}
	}
}
