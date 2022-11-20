package com.quickpharma.services;

import java.util.List;

import com.quickpharma.entities.ContactUs;

public interface ContactUsService {
	
	ContactUs save(ContactUs contactus);
	List<ContactUs> findAll();
	boolean deleteById(int id);

}
