package com.example.Hostel.ServiceImplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Exception.OrganizationServiceException;
import com.example.Hostel.dtos.OrganizationDto;
import com.example.Hostel.entity.Organization;
import com.example.Hostel.repository.OrganizationRepository;
import com.example.Hostel.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository orgRepo;

	@Override
	public void saveOrg(Organization org) {
		if (!org.getEmail().contains("@") || org.getPassword().length() < 8) {
			throw new OrganizationServiceException("Incorrect Email or Password", HttpStatus.BAD_REQUEST);
		}
		orgRepo.save(org);
	}

	@Override
	public void deleteOrg(int id) {
		if (orgRepo.findById(id).isEmpty()) {
			throw new OrganizationServiceException("This Organization Are Not Available ", HttpStatus.BAD_REQUEST);
		}

		orgRepo.deleteById(id);
	}

	@Override
	public void updateOrg(int id) {
		if (orgRepo.findById(id).isEmpty()) {
			throw new OrganizationServiceException("This Organization Are Not Available ", HttpStatus.BAD_REQUEST);
		}

		Organization o = new Organization();
		Organization existOrg = orgRepo.findById(id).get();

		existOrg.setEmail(o.getEmail());
		existOrg.setMobileNumber(o.getMobileNumber());
		existOrg.setName(o.getName());
		existOrg.setPassword(o.getPassword());
		orgRepo.save(existOrg);

	}

	@Override
	public Organization getOrg(int id) {
		if (orgRepo.findById(id).isEmpty()) {
			throw new OrganizationServiceException("This Organization Are Not Available ", HttpStatus.BAD_REQUEST);
		}
		return orgRepo.findById(id).get();
	}

	@Override
	public List<Organization> getOrgs() {
		if (orgRepo.findAll().isEmpty()) {
			throw new OrganizationServiceException("No Records Available", HttpStatus.BAD_REQUEST);
		}
		return orgRepo.findAll();
	}

	@Override
	public String LoginOrg(OrganizationDto dto) {
		Organization org = orgRepo.findbyemail(dto.getEmail())
				.orElseThrow(() -> new OrganizationServiceException("Email does not match", HttpStatus.BAD_REQUEST));

		if(!org.getPassword().equals(dto.getPassword())) {
			throw new OrganizationServiceException("password does not match", HttpStatus.BAD_REQUEST);	
			
			}
		
		return "login Sucessfull";
	}

}
