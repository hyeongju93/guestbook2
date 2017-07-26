package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.guestbookDao;
import com.javaex.vo.guestbookVo;

/**
 * Servlet implementation class guestservlet
 */
/*
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String password=request.getParameter("pass");
String content=request.getParameter("content");

guestbookVo vo = new guestbookVo(name,password,content);
guestbookDao dao = new guestbookDao();
count=dao.add(vo);

response.sendRedirect("list.jsp");
*/



@WebServlet("/gs")
public class guestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action=request.getParameter("a");
		
		
		
		if("add".equals(action)) {
			int count=0;
			System.out.println("add문으로 go");
			//request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String password=request.getParameter("pass");
			String content=request.getParameter("content");

			guestbookVo vo = new guestbookVo(name,password,content);
			guestbookDao dao = new guestbookDao();
			count=dao.add(vo);

			response.sendRedirect("/guestbook2/gs");
			
		} else if("delete".equals(action)) {
			System.out.println("deleteform으로 go");
			
			String num=request.getParameter("no");
			request.setAttribute("num", num);
			RequestDispatcher rd=request.getRequestDispatcher("deleteform.jsp");
			rd.forward(request, response);
		} else if("deleteform".equals(action)){
			System.out.println("delete실행");
			int count=0;
			//request.setCharacterEncoding("UTF-8");
			String password=request.getParameter("pass");
			String no=request.getParameter("id");


			guestbookVo vo = new guestbookVo(no,password);
			guestbookDao dao = new guestbookDao();
			count=dao.sub(vo);	//여기가 문제

			response.sendRedirect("/guestbook2/gs");
		} else {
			//request.setCharacterEncoding("UTF-8");
			System.out.println("list로 go");
			guestbookDao dao=new guestbookDao();
			List<guestbookVo> list=dao.getlist();
			request.setAttribute("list", list);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		}
			
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
