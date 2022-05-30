<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.GuestVo" %>

<%
	GuestVo guestVo= (GuestVo)request.getAttribute("guestVo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="./gbc?action=delete" method ="post">
		비밀번호 <input type="password" name="password" value=""><button type ="submit">확인</button>
		<input type ="hidden" name="no" value="<%=guestVo.getNo()%>">
	</form>
	<a href="./addList.jsp">메인으로 돌아가기</a>
</body>
</html>