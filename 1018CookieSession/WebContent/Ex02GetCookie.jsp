<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// 1. 쿠키 객체를 반환 받기
		Cookie[] cookies = request.getCookies();
	
		// 2. 쿠키 정보 출력
		for(Cookie c : cookies){
			out.print(c.getName() + " : " + c.getValue() + "<br>");
		}
	
	
	%>

	<a href = "Ex03RemoveCookie.jsp">쿠키삭제</a>


</body>
</html>