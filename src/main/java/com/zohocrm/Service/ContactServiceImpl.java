package com.zohocrm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entity.Contact;
import com.zohocrm.Repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactrepo;
	
	
	@Override
	public void saveContact(Contact contact) {
		contactrepo.save(contact);

	}


	@Override
	public List<Contact> getAllcontacts() {
		List<Contact> Allcontacts = contactrepo.findAll();
		return Allcontacts;
	}


	@Override
	public Contact getContactByid(long id) {
		Optional<Contact> findById = contactrepo.findById(id);
		Contact contact = findById.get();
		return contact;
	}

}
