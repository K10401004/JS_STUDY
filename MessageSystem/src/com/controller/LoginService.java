package com.controller;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.membership.MemberImpl;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	// 객체 -> 바이트코드 ( 직렬화 )
	// 바이트코드 -> 객체 ( 역직렬화 )

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.login(email, pw);

		if (vo != null) {
			// 새션 객체 생성
			HttpSession session = request.getSession();

			// 세션 값 설정
			session.setAttribute("member", vo);

			response.sendRedirect("main.jsp");

		} else {
			response.sendRedirect("main.jsp");
		}
	}
}