package com.zohocrm.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entity.Contact;
import com.zohocrm.Entity.Lead;
import com.zohocrm.Service.ContactService;
import com.zohocrm.Service.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadservice;
	
	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/viewcreateleadpage")
	public String ViewcreateLead() {
		return "create_new_lead";
	}
	
	@PostMapping("/save")
	public String saveLead(@ModelAttribute("lead") Lead lead,Model model) {
		leadservice.saveoneLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	@PostMapping("/ConvertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		
		Lead lead=leadservice.findById(id);
		
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactservice.saveContact(contact);
		
		leadservice.deleteByid(id);
		
		List<Contact> Allcontacts = contactservice.getAllcontacts();
		model.addAttribute("Allcontacts", Allcontacts);
		return "contacts";
	
	}
	
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadservice.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	@RequestMapping("/leadInfo")
	public String leadinfo(@RequestParam("id") long id,Model model) {
		Lead lead = leadservice.findById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	
	
	
	
}
