package com.quickpharma.services;

import java.util.List;

import com.quickpharma.entities.Pharmacist;

public interface PharmacistService {
	
	Pharmacist save(Pharmacist pharmacist);
	
	//User findPharmacistById(int id);

	List<Pharmacist> findAll();

	boolean deleteById(int id);

	Pharmacist findByEmail(String email);

	Integer pharmacistCount();

	Pharmacist authenticate(String email, String password);

	Pharmacist changePassword(String email, String password, String newPassword);
}
