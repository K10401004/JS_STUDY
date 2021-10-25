<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="java.io.Console"%>
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
	request.setCharacterEncoding("UTF-8"); // 한글 설정 하기
	
	String id = request.getParameter("id"); // 사용자가 입력한 값 가져오기
	String pw = request.getParameter("pw"); // 사용자가 입력한 값 가져오기
	
	String O_id = "test"; // 테스트용 ID
	String O_pw = "12345"; // 테스트용 PW
	
	if( O_id.equals(id)) {	// 사용자가 입력한 아이디와 테스트용 ID가 같다면
		if ( O_pw.equals(pw)) { // 테스트용 PW와 사용자입력 PW와 비교
			session.setAttribute("id", "어렵다");	// 세션 값 생성 : 입력 된 ID값을 Name으로
			session.setAttribute("pw", pw); // 세션 값 생성 : 입력 된 PW값을 Name으로
			%>
	<script> 
			alert("인증되었습니다.");	// 사용자가 입력한 ID,PW가 테스트용 ID,PW와 일치하면
			location.href = "main.jsp" // alert창 메시지 출력 후 main.jsp로 이동.
			</script>
	<%
		} else {
			%>

	<script> 
			alert("비밀번호가 틀렸습니다.");	// 테스트용 PW와 사용자입력 PW와 비교 불일치시
			location.href = "loginform.jsp" // alert창 출력 후 다시 초기 loginform으로
			</script>
	<% 
	}
	
	} else {
			%>
			
	<script> 
			alert("ID가 다릅니다."); // 사용자가 입력한 아이디와 테스트용 ID가 같지 않다면
			location.href = "loginform.jsp" // alert창 출력 후 다시 초기 loginform으로
			</script>
			
	<% 
		}
	%>


</body>
</html>