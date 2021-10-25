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
		// 가져올 세션 정보가 네임값은 string이지만 값이 오브젝트이기에 오류가 나므로 강제 형 변환
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pw");
		Integer age = (Integer) session.getAttribute("age");
		
	%>
		아이디: <%=id %> <br>
		비밀번호: <%=pw %><br>
		나이: <%=age %><br>
		
		<a href="Ex06RemoveSession.jsp">세션삭제</a>
		<a href="Ex07InvalidateSession.jsp">세션 모두 삭제</a>
	

</body>
</html>