package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.OrganizationDto;
import com.example.Hostel.entity.Organization;

public interface OrganizationService {

	public void saveOrg(Organization org);

	public void deleteOrg(int id);

	public void updateOrg(int id);

	public Organization getOrg(int id);

	public List<Organization> getOrgs();
	
	public String LoginOrg(OrganizationDto dto);
}
