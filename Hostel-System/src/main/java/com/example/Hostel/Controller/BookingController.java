package com.example.Hostel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.dtos.BookingDto;
import com.example.Hostel.entity.Booking;
import com.example.Hostel.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService service;

	@PostMapping("booking")
	public ResponseEntity<String> saveBokking(@RequestBody BookingDto dto) {
		service.saveBooking(dto);
		return new ResponseEntity<String>(Successfull.BOOKING, HttpStatus.CREATED);
	}

	@DeleteMapping("booking/deleting/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable int id) {
		service.deleteBooking(id);

		return new ResponseEntity<String>(Successfull.DELETE, HttpStatus.OK);
	}

	@GetMapping("getBooking/{id}")
	public ResponseEntity getBooking(@PathVariable int id) {
		return new ResponseEntity(service.getBooking(id), HttpStatus.OK);
	}

	
	
	@GetMapping("getBookings")
	public ResponseEntity getBookings() {
		return new ResponseEntity(service.bookings(), HttpStatus.OK);
	}

	@PutMapping("update/booking/{id}")
	public ResponseEntity updateBooking(@PathVariable int id, @RequestBody Booking booking) {

		service.updateBooking(id, booking);
		return new ResponseEntity(Successfull.UPDATE, HttpStatus.OK);

	}

}
