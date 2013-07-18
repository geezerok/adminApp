package com.geezer.adminapp.orm;

// default package
// Generated Jul 18, 2013 12:32:14 PM by Hibernate Tools 3.4.0.CR1

/**
 * Login generated by hbm2java
 */
public class Login implements java.io.Serializable {

	private Integer loginId;
	private User user;
	private String username;
	private String password;

	public Login() {
	}

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Login(User user, String username, String password) {
		this.user = user;
		this.username = username;
		this.password = password;
	}

	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
