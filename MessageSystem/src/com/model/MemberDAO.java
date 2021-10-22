package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class MemberDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	boolean check = false;
	

	int cnt = 0;
	
	// DB연결 기능
	public void connection() {

		try {

			// 1. 드라이버 동적로딩 및 서버 주소와 ID,PW 변수로 지정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. 데이터 베이스 연결 객체 ( Connection) 생성
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}

	// 기능 종료
	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//회원가입 기능
	public int join(String email, String pw, String tel, String address) {

		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 1. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "insert into WEB_MEMBER values (?,?,?,?)";

			// 2. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 3. 바인드 변수 ( ? ) 채우기
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, tel);
			pst.setString(4, address);

			// 4. SQL문 실행 후 결과 처리
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("가입실패");
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}

	// 로그인 기능
	public MemberVO login(String email, String pw) {


		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 2. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "SELECT EMAIL, TEL, ADDRESS FROM WEB_MEMBER where email=? and pw=?";

			// 3. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드 변수 ( ? ) 채우기
			pst.setString(1, email);
			pst.setString(2, pw);

			// 5. SQL문 실행 후 결과 처리
			rs = pst.executeQuery();
			// rs.next() -> true / false

			if (rs.next()) {
				System.out.println("로그인성공");

				// 값 가져오기
				String get_email = rs.getString("EMAIL");
				String get_tel = rs.getString("TEL");
				String get_address = rs.getString("ADDRESS");

				vo = new MemberVO(get_email, get_tel, get_address);

			} else {
				System.out.println("로그인실패");
			}

		} catch (Exception e) {
			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {
			close();
		}
		return vo;
	}
	
	// 회원 정보 수정 기능
	public int update(String email, String pw, String tel, String address) {
		
		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 1. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "UPDATE web_member SET pw = ?, tel=?, address=? WHERE email = ?";

			// 2. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 3. 바인드 변수 ( ? ) 채우기
			pst.setString(1, pw);
			pst.setString(2, tel);
			pst.setString(3, address);
			pst.setString(4, email);

			// 4. SQL문 실행 후 결과 처리
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("수정실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//모드 회원 정보 가져오는 기능
	public ArrayList<MemberVO> selectAll() {

		al = new ArrayList <MemberVO>();
		
		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 2. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "SELECT EMAIL, TEL, ADDRESS FROM WEB_MEMBER";

			// 3. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. SQL문 실행 후 결과 처리
			rs = pst.executeQuery();

			while (rs.next()) {

				// 값 가져오기
				String get_email = rs.getString("EMAIL");
				String get_tel = rs.getString("TEL");
				String get_address = rs.getString("ADDRESS");

				vo = new MemberVO(get_email, get_tel, get_address);
				al.add(vo);	//vo가 멤버들의 정보를 하나로 묶어주고 그 묶어준 데이터를 al이라는 Arraylist안에 저장
				
			}

		} catch (Exception e) {
			System.out.println("조회실패");
			e.printStackTrace();

		} finally {
			close();
		} return al;
	}
	
	//선택 회원 삭제 기능
	public void delete(String email) {
		
		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 2. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "DELETE FROM WEB_MEMBER WHERE EMAIL = ?";

			// 3. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);
			
			// 4. 바인드 변수 ( ? ) 채우기
			pst.setString(1, email);

			// 5. SQL문 실행 후 결과 처리
			rs = pst.executeQuery();
			
			// 6. 예외상황 설정
		} catch (Exception e) {
			System.out.println("삭제실패");
			e.printStackTrace();

		} finally {
			close();
		}
	}
	
	//ID 중복체크 기능
	public boolean idcheck(String email) {
		try {

			// 1. DB연결 메서드 connection 호출
			connection();

			// 2. SQL문 정의 ( 실행할때마다 값이 달라지는 부분은 ?로 처리 )
			String sql = "SELECT EMAIL FROM WEB_MEMBER where email=?";

			// 3. SQL 실행객체 ( PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드 변수 ( ? ) 채우기
			pst.setString(1, email);
			
			// 5. SQL문 실행 후 결과 처리
			rs = pst.executeQuery();
			
			if (rs.next()) {
				//입력한 이메일을 사용할 수 없을때 ( RS에 값이 있는 경우이니.. )
				check = true ;
				
			} else {
				//입력한 이메일을 사용할 수 있을때
				check = false ;
			}

		} catch (Exception e) {
			System.out.println("로그인실패");
			e.printStackTrace();

		} finally {
			close();
		} return check;
	}
	
	
}