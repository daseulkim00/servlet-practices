<%@page import="com.douzone.guestbook.dao.GuestbookDAO"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
 	Long no = Long.parseLong(request.getParameter("no"));                         // request.getParameter("no");
 	String password = request.getParameter("password");
 	
 	GuestbookVO vo = new GuestbookVO();
 	
 	vo.setNo(no);
 	vo.setPassword(password);
 	
 	new GuestbookDAO().delete(vo);
 	
 	response.sendRedirect("/guestbook01");

%>
