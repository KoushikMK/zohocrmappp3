package com.zohocrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entity.Contact;
import com.zohocrm.Service.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping("/generateBill")
	public String viewBillingpage(@RequestParam("id") long id,Model model) {
		Contact contact=contactservice.getContactByid(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
}
