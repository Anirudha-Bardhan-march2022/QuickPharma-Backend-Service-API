package com.quickpharma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quickpharma.daos.AddressDao;
import com.quickpharma.entities.Address;

@Transactional
@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao addressDao;

	@Override
	public Address save(Address address) {
		
		return addressDao.save(address);
	}

	@Override
	public Address getByUserID(int id) {
		return addressDao.getByUserId(id);
	}

	@Override
	public void deleteById(int id) {
		addressDao.deleteById(id);
		
	}

	@Override
	public Address update(Address address) {
	
		return addressDao.save(address);
	}

}