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
session.invalidate(); // 세션 초기화
	%>
	
<script>
// alert 창 메시지로 "로그아웃 되었습니다." 출력 후 초기화면 loginform.jsp로 이동 
alert("로그아웃 되었습니다.");
location.href='loginform.jsp';
</script>


</body>
</html>