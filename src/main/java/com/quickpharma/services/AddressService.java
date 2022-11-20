package com.quickpharma.services;

import com.quickpharma.entities.Address;

public interface AddressService {
	
	Address save(Address address);
	Address getByUserID(int id);
	void deleteById(int id);
	Address update(Address address);

}

