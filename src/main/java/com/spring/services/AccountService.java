package com.spring.services;

import com.spring.entities.Admin;
import com.spring.entities.AppRole;

public interface AccountService {
 public Admin saveAdmin(Admin admin);
 public AppRole saveRole(AppRole role);
 public void addRoleToAdmin(String login, String roleName);
 public Admin findByLogin(String login);
}
