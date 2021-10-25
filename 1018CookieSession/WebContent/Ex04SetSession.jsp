<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Session Example</title>
</head>
<body>

	<%
		// session 내장객체 사용
		// 1. 세션 값 설정 setAttribute(name(String), value(object))- value는 문자열이 아니여도 됨
		session.setAttribute("id", "test");
		session.setAttribute("pw", "12345");
		session.setAttribute("age", 25);
	%>
	


</body>
</html>