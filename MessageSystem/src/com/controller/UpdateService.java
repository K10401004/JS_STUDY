package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.MemberDAO;
import com.model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr"); // 한국어 설정
		
		HttpSession session = request.getSession(); //세션 객체 생성
		MemberVO vo = (MemberVO)session.getAttribute("member"); // 로그인한 사용자 정보 ( 수정전 )
		MemberDAO dao = new MemberDAO();
		String email = vo.getEmail();
		
		// 수정에 사용할 정보
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		//dao 기능 호출 -> 수정여부를 판단할 수 있는 값 반환
		//수정 성공 or 실패 결과를 콘솔로 출력
		
		int cnt = dao.update(email, pw, tel, address);
		
		if (cnt > 0) {
			System.out.println("수정성공");
			
			MemberVO vo2 = new MemberVO(email, tel, address);
			
			session.setAttribute("member", vo2);
			
			response.sendRedirect("main.jsp");
			
		}else {
			
			System.out.println("수정실패");
			response.sendRedirect("update.jsp");
		}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
