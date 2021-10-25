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

	String id = (String) session.getAttribute("id"); // 세션 값 가져오기
	
	%>
		<%-- 가져온 세션 값 출력 --%>
		<%=id %> 님이 로그인하였습니다. <br><br><br> 
		
		<%-- 로그아웃 설정: 사용자가 로그아웃 버튼을 클릭하면 초기화면 logout.jsp실행 --%>
	<input type="button" onclick="location.href='logout.jsp'" value="LogOut" >

</body>
</html>