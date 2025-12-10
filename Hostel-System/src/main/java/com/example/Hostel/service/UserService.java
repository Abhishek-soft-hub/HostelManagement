package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.UserLoginDto;
import com.example.Hostel.entity.User;

public interface UserService {
	
	public void saveUser(User user);
	public void deleteUser(int id);
	public void updateUser(int id );
	public User getUser(int id);
	public List<User> getUsers();
	public User loginUser(UserLoginDto dto);
}
