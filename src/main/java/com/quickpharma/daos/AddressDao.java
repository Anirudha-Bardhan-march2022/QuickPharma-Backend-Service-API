package com.quickpharma.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.quickpharma.entities.Address;




public interface AddressDao  extends JpaRepository<Address, Integer>{

	
	Address getByUserId(int id);
}
