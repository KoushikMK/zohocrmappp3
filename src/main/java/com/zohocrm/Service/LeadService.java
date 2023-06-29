package com.zohocrm.Service;

import java.util.List;

import com.zohocrm.Entity.Lead;

public interface LeadService {
	public void saveoneLead(Lead lead);

	public Lead findById(long id);

	public void deleteByid(long id);

	public List<Lead> getAllLeads();
}
