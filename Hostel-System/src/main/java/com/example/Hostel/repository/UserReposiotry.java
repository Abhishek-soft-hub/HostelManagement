package com.example.Hostel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.User;
@Repository
public interface UserReposiotry extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> findByEmail(@Param("email") String email);
	
	@Query("SELECT u from User u WHERE u.role = :role")
	Optional<User> findByRole(@Param("role") String role);
	
	
}
