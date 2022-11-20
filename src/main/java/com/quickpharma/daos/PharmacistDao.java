package com.quickpharma.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickpharma.entities.Pharmacist;

public interface PharmacistDao extends  JpaRepository<Pharmacist, Integer>{
	
	 Pharmacist findByEmail(String email);
	 
	 @Query("select count(p.pharmacistId) from Pharmacist p ")
	 Integer pharmacistCount();

}
