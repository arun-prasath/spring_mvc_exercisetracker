package com.mysite.fitnesstracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_PERMISSIONS")
public class UserPermission {

	@Id
	@Column(name="USER_PERMISSION_ID")
	private Long userPermissionId;
	
	@ManyToOne
	@JoinColumn(name="USERNAME")
	private User user;
	
	@Column(name="TARGET")
	private String target;
	
	@Column(name="PERMISSION")
	private String permission;

	public Long getUserPermissionId() {
		return userPermissionId;
	}

	public void setUserPermissionId(Long userPermissionId) {
		this.userPermissionId = userPermissionId;
	}

	public User getUser() {
		return user;
	}

	public void setUsername(User user) {
		this.user = user;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
