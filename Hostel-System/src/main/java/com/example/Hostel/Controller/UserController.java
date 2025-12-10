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

import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.dtos.UserLoginDto;
import com.example.Hostel.entity.User;
import com.example.Hostel.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("hostel/user/regigisration")
	public ResponseEntity saveUser(@RequestBody User user) {
		service.saveUser(user);
		return new ResponseEntity(Successfull.REGISTER, HttpStatus.CREATED);
	}

	@DeleteMapping("hostel/student/{id}")
	public ResponseEntity deleteuser(@PathVariable int id) {
		service.deleteUser(id);
		return new ResponseEntity(Successfull.DELETE, HttpStatus.OK);
	}

	@GetMapping("hostel/student")
	public ResponseEntity getUser(@PathVariable int id) {
		return new ResponseEntity(service.getUser(id), HttpStatus.OK);
	}

	@GetMapping("hostel/students")
	public ResponseEntity getUsers() {
		return new ResponseEntity(service.getUsers(), HttpStatus.OK);
	}

	@PutMapping("hostel/student/update/{id}")
	public ResponseEntity updateUser(@PathVariable int id) {
		service.updateUser(id);
		return new ResponseEntity(Successfull.UPDATE, HttpStatus.OK);
	}

	@PostMapping("hostel/student/Login")
	public ResponseEntity userLogin(@RequestBody UserLoginDto dto) {
		service.loginUser(dto);
		return new ResponseEntity(Successfull.LOGIN, HttpStatus.OK);
	}

}
