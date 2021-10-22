package com.model;

public class MemberVO {
	
	//필드 (속성)
	private String email;
	private String tel;
	private String address;
	
	
	// 생성자
	public MemberVO (String email, String tel, String address) {
		this.email = email;
		this.tel = tel;
		this.address = address;
		
	}
	
	// 메서드 (GET)
	public String getEmail() {
		return email;
		
	}
	public String getTel() {
		return tel;
		
	}
	public String getAddress() {
		return address;
		
	}
	
	
	

}
