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
session.invalidate(); // ���� �ʱ�ȭ
	%>
	
<script>
// alert â �޽����� "�α׾ƿ� �Ǿ����ϴ�." ��� �� �ʱ�ȭ�� loginform.jsp�� �̵� 
alert("�α׾ƿ� �Ǿ����ϴ�.");
location.href='loginform.jsp';
</script>


</body>
</html>