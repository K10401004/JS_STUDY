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
		// 세션 모두 제거
		session.invalidate();
	%>
	
	<a href="Ex05GetSession.jsp">세션 확인</a>


</body>
</html>