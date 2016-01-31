package com.mysite.fitnesstracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="USER_ROLES")
public class UserRole {

	@Id
	@GeneratedValue
	@Column(name="USER_ROLE_ID")
	private Long userRoleId;
	
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	
	@Column(name="ROLE")
	private String role;

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
