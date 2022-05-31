package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.BookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestVo;


@WebServlet("/gbc")
public class GuestController extends HttpServlet {
	//필드
	private static final long serialVersionUID = 1L;
       
	//생성자
	
	//메소드 gs
	
	//메소드 일반


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if("list".equals(action)) {
			BookDao bookDao = new BookDao();
			List<GuestVo> guestList = bookDao.getGuestList();
			System.out.println(guestList);
			
			request.setAttribute("gList", guestList);
			
			
			WebUtil.forward(request, response, "/WEB-INF/addList.jsp");
			
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("/addList.jsp");
			 * rd.forward(request, response);
			 */
		} else if ("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			String regDate = request.getParameter("reg_date");
			BookDao bookDao = new BookDao();
			GuestVo guestVo = new GuestVo(name,password,content,regDate);
			
			bookDao.bookInsert(guestVo);
			
			response.sendRedirect("./gbc?action=list");
			
		}else if("deleteForm".equals(action)) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			BookDao bookDao = new BookDao();
			GuestVo guestVo = bookDao.getGuest(no);
			
			request.setAttribute("guestVo", guestVo);
			
			WebUtil.forward(request, response, "/WEB-INF/deleteForm.jsp");
			
		}else if ("delete".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			
			BookDao bookDao = new BookDao();
			int count = bookDao.bookDelete(no);
			System.out.println(count);
			
			response.sendRedirect("./gbc?action=list");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
