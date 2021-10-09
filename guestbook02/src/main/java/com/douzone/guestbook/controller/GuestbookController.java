package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestbookDAO;
import com.douzone.guestbook.vo.GuestbookVO;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("guest");
		if("deleteform".equals(action)) {  //삭제양식페이지로 이동시켜주는것
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
	         rd.forward(request, response);
		}else if("add".equals(action)){
		
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestbookVO vo = new GuestbookVO();
			
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookDAO().insert(vo);
			
			response.sendRedirect("/guestbook02/gb");
			
		}else if("delete".equals(action)) { // 실제로삭제하는거
			Long no = Long.parseLong(request.getParameter("no"));                         // request.getParameter("no");
		 	String password = request.getParameter("password");
		 	
		 	GuestbookVO vo = new GuestbookVO();
		 	
		 	vo.setNo(no);
		 	vo.setPassword(password);
		 	
		 	new GuestbookDAO().delete(vo);
		 	
		 	response.sendRedirect("/guestbook02/gb");
		}
		else { //gb뒤에 주소를 제대로 안쳐도 이쪽으로 갈 수있게
			GuestbookDAO dao = new GuestbookDAO();
			List<GuestbookVO> list = dao.findAll();
			
			request.setAttribute("list", list);  //다오리스트를가지고와서 이페이지에 뿌리러가겟다

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
	        rd.forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
