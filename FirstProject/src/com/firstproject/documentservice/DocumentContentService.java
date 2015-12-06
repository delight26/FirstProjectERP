package com.firstproject.documentservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.DocumentApproval;
import com.firstproject.dao.DocumentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DocumentContentService implements ERPServiceInterface {

	@Override
	public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int docnum = Integer.valueOf(request.getParameter("documentNumber"));
		DocumentApproval da = null;
		DocumentDao dao = DocumentDao.getInstance();
		da = dao.getContentDocument(docnum);
		request.setAttribute("dac", da);
		ERPForwardService forward = new ERPForwardService();
		forward.setView("./Document/DocumentContentForm.jsp");
		forward.setRedirect(false);

		return forward;
	}
}
