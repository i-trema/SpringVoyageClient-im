package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	public Admin findByLogin(String login);
}
