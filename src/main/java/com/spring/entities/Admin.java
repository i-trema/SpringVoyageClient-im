package com.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Admin {
	@Id
	private String login;
	private String password;
	private boolean active;
	@ManyToMany(fetch = FetchType.EAGER)		
	private List<AppRole> roles = new ArrayList<AppRole>();
	
	
	
	
	public Admin(String login, String password, boolean active, List<AppRole> roles) {
		super();
		this.login = login;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}
	public Admin() {
		super();
	}
	public Admin(String login, String password, List<AppRole> roles) {
		super();
		this.login = login;
		this.password = password;
		this.roles = roles;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(List<AppRole> roles) {
		this.roles = roles;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
