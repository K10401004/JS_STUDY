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

	String id = (String) session.getAttribute("id"); // ���� �� ��������
	
	%>
		<%-- ������ ���� �� ��� --%>
		<%=id %> ���� �α����Ͽ����ϴ�. <br><br><br> 
		
		<%-- �α׾ƿ� ����: ����ڰ� �α׾ƿ� ��ư�� Ŭ���ϸ� �ʱ�ȭ�� logout.jsp���� --%>
	<input type="button" onclick="location.href='logout.jsp'" value="LogOut" >

</body>
</html>