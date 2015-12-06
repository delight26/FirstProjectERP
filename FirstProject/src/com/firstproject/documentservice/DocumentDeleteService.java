package com.firstproject.documentservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.dao.DepartmentDao;
import com.firstproject.dao.DocumentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

	public class DocumentDeleteService implements ERPServiceInterface {
		
		public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
		
			//DepartmentDao dao = DepartmentDao.getInstance();
			DocumentDao dao = DocumentDao.getInstance();
			
			int documentNumber = Integer.parseInt(request.getParameter("documentNumber"));
			
			 dao.deleteDocument(documentNumber);
			
			ERPForwardService forward = new ERPForwardService();
			forward.setView("listdocument.doc");
			forward.setRedirect(false);

			return forward;
		}

}
