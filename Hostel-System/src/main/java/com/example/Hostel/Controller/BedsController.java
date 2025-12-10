package com.example.Hostel.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.ServiceImplementations.BedServiceImpl;
import com.example.Hostel.dtos.BedsDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.service.BedsService;

@RestController
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class BedsController {

	@Autowired
	private BedsService bedsService;

	@PostMapping("saveBeds")
	public ResponseEntity saveBeds(@RequestBody BedsDto beds) {
		bedsService.saveBeds(beds);
		return new ResponseEntity(Successfull.SAVE_DATA, HttpStatus.CREATED);
	}

	@GetMapping("availableBeds/{shearing}/{hostelId}")
	public ResponseEntity<String> getAvailableBeds(@PathVariable int shearing, @PathVariable int hostelId) {
		return new ResponseEntity(bedsService.getAvaiableBeds(shearing, hostelId), HttpStatus.OK);

	}

	@DeleteMapping("delete/bed/{id}")
	public ResponseEntity<String> deleteBeds(@PathVariable int id) {
		bedsService.deleteBeds(id);
		return new ResponseEntity<String>(Successfull.DELETE, HttpStatus.OK);
	}

	@PutMapping("bed/update/{id}")
	public ResponseEntity<String> update(@PathVariable int id) {
		bedsService.updateBeds(id);
		return new ResponseEntity<String>(Successfull.UPDATE, HttpStatus.OK);

	}

	@GetMapping("bed/get/{id}")
	public ResponseEntity<Beds> getBed(@PathVariable int id) {
		return new ResponseEntity<Beds>(bedsService.getBed(id), HttpStatus.OK);
	}

	@GetMapping("getBeds")
	public ResponseEntity<List> getBeds() {
		return new ResponseEntity<List>(bedsService.getBeds(), HttpStatus.OK);

	}

}
