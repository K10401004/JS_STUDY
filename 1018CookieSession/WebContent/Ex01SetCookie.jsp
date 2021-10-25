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
		// 1. 쿠키 객체 생성
		
		// Cookie (name(String만 가능), value(String만 가능));
		Cookie cookie = new Cookie("testcookie","firstcookie");
		
		// 2. 유효기간 설정 (초단위 설정 - 연산으로 적어도 됨)
		cookie.setMaxAge(365*24*60*60); //1년
		
		// 3. 클라이언트에게 쿠키 전송 ( 응답 - response)
		response.addCookie(cookie);
		
		// 4. 추가 생성한 후 바로 클라이언트에게 전송
		response.addCookie(new Cookie("id", "test"));
	
	%>
		<a href="Ex02GetCookie.jsp">쿠키확인</a>

</body>
</html>