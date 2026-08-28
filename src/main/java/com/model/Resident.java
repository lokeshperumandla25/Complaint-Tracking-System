package com.model;

public class Resident {
	
	private int resId;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String role;

	public Resident(String name, String email,String password, String role) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public Resident(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}


	public Resident() {
		super();
	}
	
	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	

}
