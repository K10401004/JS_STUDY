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
	request.setCharacterEncoding("UTF-8"); // �ѱ� ���� �ϱ�
	
	String id = request.getParameter("id"); // ����ڰ� �Է��� �� ��������
	String pw = request.getParameter("pw"); // ����ڰ� �Է��� �� ��������
	
	String O_id = "test"; // �׽�Ʈ�� ID
	String O_pw = "12345"; // �׽�Ʈ�� PW
	
	if( O_id.equals(id)) {	// ����ڰ� �Է��� ���̵�� �׽�Ʈ�� ID�� ���ٸ�
		if ( O_pw.equals(pw)) { // �׽�Ʈ�� PW�� ������Է� PW�� ��
			session.setAttribute("id", "��ƴ�");	// ���� �� ���� : �Է� �� ID���� Name����
			session.setAttribute("pw", pw); // ���� �� ���� : �Է� �� PW���� Name����
			%>
	<script> 
			alert("�����Ǿ����ϴ�.");	// ����ڰ� �Է��� ID,PW�� �׽�Ʈ�� ID,PW�� ��ġ�ϸ�
			location.href = "main.jsp" // alertâ �޽��� ��� �� main.jsp�� �̵�.
			</script>
	<%
		} else {
			%>

	<script> 
			alert("��й�ȣ�� Ʋ�Ƚ��ϴ�.");	// �׽�Ʈ�� PW�� ������Է� PW�� �� ����ġ��
			location.href = "loginform.jsp" // alertâ ��� �� �ٽ� �ʱ� loginform����
			</script>
	<% 
	}
	
	} else {
			%>
			
	<script> 
			alert("ID�� �ٸ��ϴ�."); // ����ڰ� �Է��� ���̵�� �׽�Ʈ�� ID�� ���� �ʴٸ�
			location.href = "loginform.jsp" // alertâ ��� �� �ٽ� �ʱ� loginform����
			</script>
			
	<% 
		}
	%>


</body>
</html>