package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02LoginCheck")
public class ex02LoginCheck extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자가 입력한 ID, PW를 가져오시오
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// 2. ID가 'smart'이고, PW가 '123'일때,
		// 일치하면, 'ex02LoginS.jsp'이동하고
		// 불일치하면, 'ex02LoginF.jsp'이동하시오

		if (id.equals("smart") && pw.equals("123")) {
			response.sendRedirect("ex02LoginS.jsp");
		} else {
			response.sendRedirect("ex02LoginF.jsp");
		}
	}

}
