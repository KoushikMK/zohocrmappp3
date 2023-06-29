package com.zohocrm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entity.Lead;
import com.zohocrm.Repositories.LeadRepository;

@Service
public class LeadServiceimpl implements LeadService {

	@Autowired
	private LeadRepository leadrepo;
	
	@Override
	public void saveoneLead(Lead lead) {
		leadrepo.save(lead);

	}

	@Override
	public Lead findById(long id) {
		Optional<Lead> findById = leadrepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteByid(long id) {
		leadrepo.deleteById(id);
		
	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadrepo.findAll();
		return leads;
	}

}
