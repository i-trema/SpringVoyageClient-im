package com.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.entities.Admin;
import com.spring.entities.AppRole;
import com.spring.repositories.AdminRepository;
import com.spring.repositories.AppRoleRepository;


@Service
@Transactional
public class AccountServiceImplement implements AccountService{
	@Bean
	private BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	};
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	AppRoleRepository appRoleRepository;
	
	
	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		String hashPW=getBCPE().encode(admin.getPassword());
		System.out.println(hashPW);
		admin.setPassword(hashPW);
		return adminRepository.save(admin);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return appRoleRepository.save(role);
	}

	@Override
	public void addRoleToAdmin(String login, String roleName) {
		// TODO Auto-generated method stub
		AppRole role=appRoleRepository.findByRoleName(roleName);
		Admin admin=adminRepository.findByLogin(login);
		admin.getRoles().add(role);
	}

	@Override
	public Admin findByLogin(String login) {
		// TODO Auto-generated method stub
		return adminRepository.findByLogin(login);
	}

}
