package com.zohocrm.Service;

import java.util.List;

import com.zohocrm.Entity.Contact;

public interface ContactService {
	public void saveContact(Contact contact);
	public List<Contact> getAllcontacts();
	public Contact getContactByid(long id);
}
