package com.example.Hostel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.dtos.HostelDto;
import com.example.Hostel.entity.Hostel;
import com.example.Hostel.service.HostelService;

@RestController
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class HostelCotroller {
	@Autowired
	HostelService service;

	@PostMapping("hostel")
	public ResponseEntity saveHostel(@RequestBody HostelDto h) {

		service.saveHostel(h);
		return new ResponseEntity(Successfull.SAVE_DATA, HttpStatus.CREATED);
	}

	@DeleteMapping("hostel/delete/{id}")
	public ResponseEntity deleteHostel(@PathVariable int id) {
		service.deleteHOstel(id);
		return new ResponseEntity(Successfull.DELETE, HttpStatus.OK);
	}

	@GetMapping("hostels")
	public ResponseEntity getHostels() {
		return new ResponseEntity(service.getHostels(), HttpStatus.OK);
	}

	@GetMapping("hostel/{id}")
	public ResponseEntity getHostels(@PathVariable int id) {
		return new ResponseEntity(service.getHostel(id), HttpStatus.OK);
	}

	@PutMapping("hostel/update/{id}")
	public ResponseEntity Update(@PathVariable int id, @RequestBody Hostel hostel) {
		service.updateHostel(id, hostel);
		return new ResponseEntity(Successfull.UPDATE, HttpStatus.OK);

	}
}
