<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="/guestbook02/gb?guest=delete">	
	<input type="text" name="no" value ="<%=request.getParameter("no")%>">  <!-- 삭제되는 글번호(no)를 넘겨받음 -->  
	<input type="password" name="password">
	<input type="submit" value="확인">
	</form>
    <br>
    <a href="/guestbook01">메인으로 돌아가기</a>

</body>
</html>