package com.zohocrm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.Entity.Contact;

import com.zohocrm.Service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	
		
	@RequestMapping("/listcontacts")
	public String listAllContacts(Model model) {
		List<Contact> Allcontacts = contactservice.getAllcontacts();
		model.addAttribute("Allcontacts", Allcontacts);
		return "contacts";
	}
}
