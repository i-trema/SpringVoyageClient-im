package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entities.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
