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
		// session ���尴ü ���
		// 1. ���� �� ���� setAttribute(name(String), value(object))- value�� ���ڿ��� �ƴϿ��� ��
		session.setAttribute("id", "test");
		session.setAttribute("pw", "12345");
		session.setAttribute("age", 25);
	%>
	


</body>
</html>