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
	
	// DB���� ���
	public void connection() {

		try {

			// 1. ����̹� �����ε� �� ���� �ּҿ� ID,PW ������ ����
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			// 2. ������ ���̽� ���� ��ü ( Connection) ����
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������");
		}
	}

	// ��� ����
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

	//ȸ������ ���
	public int join(String email, String pw, String tel, String address) {

		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 1. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "insert into WEB_MEMBER values (?,?,?,?)";

			// 2. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 3. ���ε� ���� ( ? ) ä���
			pst.setString(1, email);
			pst.setString(2, pw);
			pst.setString(3, tel);
			pst.setString(4, address);

			// 4. SQL�� ���� �� ��� ó��
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("���Խ���");
			e.printStackTrace();
		} finally {
			close();

		}
		return cnt;
	}

	// �α��� ���
	public MemberVO login(String email, String pw) {


		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 2. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "SELECT EMAIL, TEL, ADDRESS FROM WEB_MEMBER where email=? and pw=?";

			// 3. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε� ���� ( ? ) ä���
			pst.setString(1, email);
			pst.setString(2, pw);

			// 5. SQL�� ���� �� ��� ó��
			rs = pst.executeQuery();
			// rs.next() -> true / false

			if (rs.next()) {
				System.out.println("�α��μ���");

				// �� ��������
				String get_email = rs.getString("EMAIL");
				String get_tel = rs.getString("TEL");
				String get_address = rs.getString("ADDRESS");

				vo = new MemberVO(get_email, get_tel, get_address);

			} else {
				System.out.println("�α��ν���");
			}

		} catch (Exception e) {
			System.out.println("�α��ν���");
			e.printStackTrace();

		} finally {
			close();
		}
		return vo;
	}
	
	// ȸ�� ���� ���� ���
	public int update(String email, String pw, String tel, String address) {
		
		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 1. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "UPDATE web_member SET pw = ?, tel=?, address=? WHERE email = ?";

			// 2. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 3. ���ε� ���� ( ? ) ä���
			pst.setString(1, pw);
			pst.setString(2, tel);
			pst.setString(3, address);
			pst.setString(4, email);

			// 4. SQL�� ���� �� ��� ó��
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	//��� ȸ�� ���� �������� ���
	public ArrayList<MemberVO> selectAll() {

		al = new ArrayList <MemberVO>();
		
		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 2. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "SELECT EMAIL, TEL, ADDRESS FROM WEB_MEMBER";

			// 3. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. SQL�� ���� �� ��� ó��
			rs = pst.executeQuery();

			while (rs.next()) {

				// �� ��������
				String get_email = rs.getString("EMAIL");
				String get_tel = rs.getString("TEL");
				String get_address = rs.getString("ADDRESS");

				vo = new MemberVO(get_email, get_tel, get_address);
				al.add(vo);	//vo�� ������� ������ �ϳ��� �����ְ� �� ������ �����͸� al�̶�� Arraylist�ȿ� ����
				
			}

		} catch (Exception e) {
			System.out.println("��ȸ����");
			e.printStackTrace();

		} finally {
			close();
		} return al;
	}
	
	//���� ȸ�� ���� ���
	public void delete(String email) {
		
		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 2. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "DELETE FROM WEB_MEMBER WHERE EMAIL = ?";

			// 3. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);
			
			// 4. ���ε� ���� ( ? ) ä���
			pst.setString(1, email);

			// 5. SQL�� ���� �� ��� ó��
			rs = pst.executeQuery();
			
			// 6. ���ܻ�Ȳ ����
		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();

		} finally {
			close();
		}
	}
	
	//ID �ߺ�üũ ���
	public boolean idcheck(String email) {
		try {

			// 1. DB���� �޼��� connection ȣ��
			connection();

			// 2. SQL�� ���� ( �����Ҷ����� ���� �޶����� �κ��� ?�� ó�� )
			String sql = "SELECT EMAIL FROM WEB_MEMBER where email=?";

			// 3. SQL ���ఴü ( PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε� ���� ( ? ) ä���
			pst.setString(1, email);
			
			// 5. SQL�� ���� �� ��� ó��
			rs = pst.executeQuery();
			
			if (rs.next()) {
				//�Է��� �̸����� ����� �� ������ ( RS�� ���� �ִ� ����̴�.. )
				check = true ;
				
			} else {
				//�Է��� �̸����� ����� �� ������
				check = false ;
			}

		} catch (Exception e) {
			System.out.println("�α��ν���");
			e.printStackTrace();

		} finally {
			close();
		} return check;
	}
	
	
}