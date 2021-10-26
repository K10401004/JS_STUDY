package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;


@WebServlet("/ex02Join")
public class ex02Join extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		// JDBC
		// 1. OJDBC6.jar 가져오기 ( WEB-INF -> lib )
		
		
		try {
		// 2. OracleDriver.class ( OJDBC6.jar 안에 존재 ) 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		// 3. Oracle로가서 DBID, DBPW를 인증
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			Connection conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}
			
			// 4. SQL문 준비
			String sql = "Insert into JDBC_member values(?,?,?)" ;
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);
			
			// 5. SQL문 명령 후 처리 
			int cnt = psmt.executeUpdate();
			
			if(cnt > 0) {
				response.sendRedirect("ex02login.html");
			}else {
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
