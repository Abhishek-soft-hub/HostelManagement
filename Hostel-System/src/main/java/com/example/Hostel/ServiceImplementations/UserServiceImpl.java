package com.example.Hostel.ServiceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Exception.UserException;
import com.example.Hostel.dtos.UserLoginDto;
import com.example.Hostel.entity.User;
import com.example.Hostel.Constants.Error;
import com.example.Hostel.repository.UserReposiotry;
import com.example.Hostel.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserReposiotry userRepo;

	@Override
	public void saveUser(User user) {
		userRepo.save(user);

	}

	@Override
	public void deleteUser(int id) {
		if (userRepo.findById(id) == null || userRepo.findById(id).isEmpty()) {
			throw new UserException(Error.USER_ERROR , HttpStatus.BAD_REQUEST);
		}
		userRepo.deleteById(id);

	}

	@Override
	public void updateUser(int id) {
		User userUpdate = new User();
		if (userRepo.findById(id) == null || userRepo.findById(id).isEmpty()) {
			throw new UserException(Error.USER_ERROR, HttpStatus.BAD_REQUEST);
		}
		User existUser = userRepo.findById(id).get();

		existUser.setName(userUpdate.getName());
		existUser.setLastName(userUpdate.getLastName());
		existUser.setEmail(userUpdate.getEmail());
		existUser.setPassword(userUpdate.getPassword());
		existUser.setMoNo(userUpdate.getMoNo());
		existUser.setDateOfBirth(userUpdate.getDateOfBirth());
		userRepo.save(existUser);

	}

	@Override
	public User getUser(int id) {
		if (userRepo.findById(id) == null || userRepo.findById(id).isEmpty()) {
			throw new UserException(Error.USER_ERROR, HttpStatus.BAD_REQUEST);
		}
		return userRepo.findById(id).get();
	}

	@Override
	public List<User> getUsers() {
		if (userRepo.findAll().isEmpty()) {
			throw new UserException(Error.USER_ERROR, HttpStatus.BAD_REQUEST);
		}
		return userRepo.findAll();
	}

	@Override
	public User loginUser(UserLoginDto dto) {
		User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(() -> new UserException(Error.PASSWORD_ERROR, HttpStatus.BAD_REQUEST));
		if(!user.getPassword().equals(dto.getPassword())) {
			throw new UserException(Error.PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
		}
		return user;
		
	
		
		
		
	}

}