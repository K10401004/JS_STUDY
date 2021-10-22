package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��û ������ ���ڵ� ��� ����
		request.setCharacterEncoding("EUC-KR");

		// ��û ������ �޾��ֱ�
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.join(email, pw, tel, address);

		if (cnt > 0) {
			System.out.println("���Լ���");
			
			//foward ������� ������ �̵� ( �����̷�Ʈ ������ �۵���Ķ����� ��� )
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
			
			//request ������ ����ؾ� �� ������ ����
			request.setAttribute("email", email);
			
			// ������ �̵��� request, response ��ü ����
			rd.forward(request, response);
			
		} else {
			System.out.println("���Խ���");
			response.sendRedirect("main.jsp");
		}

	}

}
