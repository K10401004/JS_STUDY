<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Session Test Login Page</title>
<style>

	form{
	text-align: center;
	}

</style>
</head>
<body>

<form action="logincheck.jsp" method="post">
	<div><br><br><br><br>
	<h1>Login Page</h1> <br><br><br><br><br>
	</div>
    <div>
      <label>���̵�:   &nbsp  </label>
      <input name="id" type="text"><br>
    </div><br>
    <div>
      <label>��й�ȣ: </label>
      <input name="pw" type="password">
    </div><br>
    <button type="submit">����</button>
  </form>

</body>
</html>