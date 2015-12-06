package com.firstproject.department.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.firstproject.bean.CommentBean;
import com.firstproject.bean.DepartmentBoard;
import com.firstproject.dao.DepartmentDao;
import com.firstproject.service.ERPForwardService;
import com.firstproject.service.ERPServiceInterface;

public class DepartmentReadService implements ERPServiceInterface{
	  @Override
	   public ERPForwardService Process(HttpServletRequest request, HttpServletResponse response)
	         throws IOException, ServletException {
	      DepartmentDao dao = DepartmentDao.getInstance();
	      int postNumber = Integer.parseInt(request.getParameter("postNumber"));
	      int deptno = Integer.parseInt(request.getParameter("deptno"));
	      DepartmentBoard noticep = new DepartmentBoard(postNumber, deptno);
	      ArrayList<DepartmentBoard> departmentList = dao.getDepartmentReadList(noticep);
	      request.setAttribute("departmentList", departmentList);
	      
	      ArrayList<CommentBean> commentList = dao.getCommentReadList(postNumber);
	      request.setAttribute("commentList", commentList);
	      
	      ERPForwardService forward = new ERPForwardService();
	      forward.setView("./Department/DepartmentContentForm.jsp");
	      forward.setRedirect(false);

	      return forward;
	   }
	}