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
		// 1. 삭제할 쿠키의 동일한 name값을 가진 쿠키 객체 생성 ( value는 상관없음)
		Cookie cookie = new Cookie("testcookie","");
		
		// 2. 유효기간을 0으로 설정
		cookie.setMaxAge(0);
		
		// 3. 쿠키를 클라이언트에게 전송 ( 응답 )
		response.addCookie(cookie);	
	
	%>
	
	<a href="Ex02GetCookie.jsp"> 쿠키 확인 </a>


</body>
</html>