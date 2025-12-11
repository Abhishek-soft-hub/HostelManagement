package com.example.Hostel.Controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.dtos.PaymentDto;
import com.example.Hostel.entity.Payment;
import com.example.Hostel.service.PayementService;

@RestController
public class PaymentController {

	@Autowired
	PayementService service;

	@PostMapping("payment")
	public ResponseEntity<Payment> savePayment(@RequestBody PaymentDto dto) {
		service.savePayment(dto);
		return new ResponseEntity<Payment>(HttpStatus.CREATED);
	}

	@GetMapping("payment/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable int id) {

		return new ResponseEntity<Payment>(service.getPayment(id), HttpStatus.OK);
	}

	@GetMapping("payments")
	public ResponseEntity getPayments() {
		return new ResponseEntity(service.getPayments(), HttpStatus.OK);

	}

}
