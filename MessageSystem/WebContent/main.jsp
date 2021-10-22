<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
<%@page import="com.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSP Test Web Page</title>
<meta charset="EUC-KR" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<%
		// 로그인 상태 판별을 해줄 세션 키 불러오기 ( vo == null -> 로그인하지 않은 상태.)
		MemberVO vo = (MemberVO) session.getAttribute("member");
	%>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt"> <a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a> <nav> 
		
		<%-- 우측 상단에 로그인 전 : 로그인 : 로그인 후 : 사용자가 정보수정과 로그아웃할 수 있는 메뉴  --%> 
		<%if (vo==null){ %> 
		<a href="#menu">로그인</a> 
		<%} else { %> 
		
		<%if(vo.getEmail().equals("admin@test.com")){ %>
		<a href="selectMember.jsp">전체 회원 정보</a>
		<% } %>
		<a href="update.jsp">개인정보수정</a> 
		<a href="LogoutService">로그아웃</a> 
		<% } %> 
		</nav> 
		</header>

		<!-- Menu -->
		<nav id="menu">
		<ul class="links">
			<li><h5>로그인</h5></li>
			<form action="LoginService" method="post">
				<li><input name=email type="text" placeholder="Email을 입력하세요"></li>
				<li><input name=pw type="password" placeholder="PW를 입력하세요"></li>
				<li><input type="submit" value="LogIn" class="button fit"></li>
			</form>
		</ul>
		<ul class="actions vertical">
			<li><h5>회원가입</h5></li>
			<form action="JoinService" method="post">
				<li><input name="email" id="input_id" type="text" placeholder="Email을 입력하세요">
				<input type="button" value="ID중복체크" onclick="idCheck()"><br><br>
				</li>	<span id=sp_result></span>
				<li><input name="pw" type="password" placeholder="PW를 입력하세요"></li>
				<li><input name="tel" type="text" placeholder="전화번호를 입력하세요"></li>
				<li><input name="address" type="text" placeholder="집주소를 입력하세요"></li>
				<li><input type="submit" value="JoinUs" class="button fit"></li>
			</form>
		</ul>
		</nav>
		<!-- Banner -->
		<section id="banner" class="major">
		<div class="inner">
			<header class="major"> <%-- 로그인 후 로그인 사용자 메일주소로 변경 + 환영메시지  --%> <%if (vo==null){ %>
			<h1>환영합니다.</h1>
			<%} else { %>
			<h1><%=vo.getEmail() %>님 환영합니다.
			</h1>
			<% } %> </header>
			<div class="content">
				<p>
					아래는 지금까지 배운 웹 기술들입니다.<br>
				</p>
				<ul class="actions">
					<li><a href="#one" class="button next scrolly">확인하기</a></li>
				</ul>
			</div>
		</div>
		</section>

		<!-- Main -->
		<div id="main">

			<!-- One -->
			<section id="one" class="tiles"> <article> <span class="image"> <img src="images/pic01.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">HTML</a>
			</h3>
			<p>홈페이지를 만드는 기초 언어</p>
			</header> </article> <article> <span class="image"> <img src="images/pic02.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">CSS</a>
			</h3>
			<p>HTML을 디자인해주는 언어</p>
			</header> </article> <article> <span class="image"> <img src="images/pic03.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Servlet/JSP</a>
			</h3>
			<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
			</header> </article> <article> <span class="image"> <img src="images/pic04.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">JavaScript</a>
			</h3>
			<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
			</header> </article> <article> <span class="image"> <img src="images/pic05.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">MVC</a>
			</h3>
			<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
			</header> </article> <article> <span class="image"> <img src="images/pic06.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Web Project</a>
			</h3>
			<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
			</header> </article> </section>
			<!-- Two -->
			<section id="two">
			<div class="inner">
				<header class="major">
				<h2>나에게 온 메세지 확인하기</h2>
				</header>
				<p></p>
				<ul class="actions">
					<%if (vo==null){ %>
					<li>로그인을 하세요.</li>
					<%} else { %>
					<li><%=vo.getEmail() %></li>
					<br>
					<li>새로운 메시지</li>
					<br>
					<li>읽은 메시지</li>
					<% } %>

				</ul>
			</div>
			</section>

		</div>

		<!-- Contact -->
		<section id="contact">
		<div class="inner">
			<section>
			<form>
				<div class="field half first">
					<label for="name">Name</label> <input type="text" id="name" placeholder="보내는 사람 이름" />
				</div>
				<div class="field half">
					<label for="email">Email</label> <input type="text" id="email" placeholder="보낼 사람 이메일" />
				</div>

				<div class="field">
					<label for="message">Message</label>
					<textarea id="message" rows="6"></textarea>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send Message" class="special" /></li>
					<li><input type="reset" value="Clear" /></li>
				</ul>
			</form>
			</section>

			<section class="split"> <section>
			<div class="contact-method">
				<span class="icon alt fa-envelope"></span>

				<%-- 사용자의 Email정보를 보여주는 부분 - 로그인후 사용자 email입력  --%>
				<h3>Email</h3>
				<%if (vo==null){ %>
				<a href="#">로그인 한 사람의 이메일을 출력</a>
				<%} else { %>
				<h1><%=vo.getEmail() %></h1>
				<% } %>


			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-phone"></span>
				<%-- 사용자의 TEL정보를 보여주는 부분 - 로그인후 사용자 Tel입력  --%>
				<h3>Phone</h3>
				<%if (vo==null){ %>
				<span>로그인 한 사람의 전화번호를 출력</span>
				<%} else { %>
				<h1><%=vo.getTel() %>
				</h1>
				<% } %>


			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-home"></span>
				<%-- 사용자의 주소 정보를 보여주는 부분 - 로그인후 사용자 주소 입력  --%>
				<h3>Address</h3>
				<%if (vo==null){ %>
				<span>로그인 한 사람의 집주소를 출력</span>
				<%} else { %>
				<h1><%=vo.getAddress() %></h1>
				<% } %>


			</div>
			</section> </section>
		</div>
		</section>

		<!-- Footer -->
		<footer id="footer">
		<div class="inner">
			<ul class="icons">
				<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
				<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Untitled</li>
				<li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	
	<script>
	
		function idCheck() {
			
			// 요소의 실제 값을 가지고 오는 방법
			// 1. innerText : 태그 사이에 텍스트를 가지고 오는 방법
			// 2. innerHTML : 태그 사이에 모든 요소를 가지고 오는 방법
			
			let input = document.getElementById("input_id");
			
			//alert(input.value); <-- vanilla방식
			//alert($('#input_id'),val());  <-- J쿼리방식
			
			//ajax방식
			$.ajax({
				
				type: "post", //데이터 전송 ( 요청 ) 방식 지정
				data: {"email" : input.value}, //전송 데이터 지정
				url: "IdCheckService", // 데이터를 전송하는 ( 요청하는 ) 서버페이지 URL
				datatype: "text", //응답데이터의 형식
				
				success: function(data){
					let sp_result = document.getElementById("sp_result");
					
					// alert(data)
					if(data=="true"){
						sp_result.innerText = "사용 불가능한 아이디 입니다."
					}else{
						$("#sp_result").text("사용 가능한 아이디 입니다.");
					}
				},
				
				error: function () {
					alert("통신실패!")
				}
				
			});
			
		}
	
	</script>




</body>
</html>

















