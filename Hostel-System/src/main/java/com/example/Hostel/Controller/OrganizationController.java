package com.example.Hostel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.Hostel.dtos.OrganizationDto;
import com.example.Hostel.entity.Organization;
import com.example.Hostel.service.OrganizationService;

@RestController
@CrossOrigin
public class OrganizationController {

	@Autowired
	OrganizationService service;
	
	@PostMapping("organization/save")
	public ResponseEntity saveOrg(@RequestBody Organization org) {
		service.saveOrg(org);
		return new ResponseEntity("Organization Are Saved", HttpStatus.CREATED);
	}
	
	@DeleteMapping("organization/delete/{id}")
	public ResponseEntity deleteOrg(@PathVariable int id) {
		service.deleteOrg(id);
		return new ResponseEntity("Organization Are Deleted" , HttpStatus.OK);
	}
	
	@PutMapping("organization/update/{id}")
	public ResponseEntity<String> updateOrg(@PathVariable int id) {
		service.updateOrg(id);
		return new ResponseEntity("Organization Are Updated", HttpStatus.OK);
	}
	
	@GetMapping("organization/{id}")
	public ResponseEntity gteOrgnization(@PathVariable int id) {
		return new ResponseEntity(service.getOrg(id), HttpStatus.OK);
	}
	
	@GetMapping("organizations")
	public ResponseEntity getOrganizations() {
		return new ResponseEntity(service.getOrgs(), HttpStatus.OK);
	}
	@PostMapping("Org/login")
	public ResponseEntity loginOrg(@RequestBody OrganizationDto dto) {
		service.LoginOrg(dto);
		return new ResponseEntity("Login are Sucessfull" , HttpStatus.OK);
		
		
	}
}
