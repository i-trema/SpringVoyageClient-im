package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.AppRole;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);

}
