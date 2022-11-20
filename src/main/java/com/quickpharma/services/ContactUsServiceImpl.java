package com.quickpharma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quickpharma.daos.ContactUsDao;
import com.quickpharma.entities.ContactUs;

@Transactional
@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	private ContactUsDao contactusDao;
	
	@Override
	public ContactUs save(ContactUs contactus) {
		return contactusDao.save(contactus);
	}

	@Override
	public List<ContactUs> findAll() {
		return contactusDao.findAll();
	}

	@Override
	public boolean deleteById(int id) {
		if(contactusDao.existsById(id)) {
			contactusDao.deleteById(id);
			return true;
		}
		return false;
	}

}