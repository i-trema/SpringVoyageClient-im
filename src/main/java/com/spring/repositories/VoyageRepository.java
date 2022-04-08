package com.spring.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entities.Voyage;
@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Integer> {


//	@Modifying
//	@Query("DELETE Voyage v WHERE v.id = ?1")
//	void deleteById(int id);

}
