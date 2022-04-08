package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppRole {
	@Id
	private String roleName;
	
	
	
	

	public AppRole() {
		super();
	}

	public AppRole(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
