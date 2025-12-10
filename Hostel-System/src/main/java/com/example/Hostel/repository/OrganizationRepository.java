package com.example.Hostel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer>{

	@Query("select o from Organization o where o.email = :email")
	Optional<Organization> findbyemail(@Param("email") String email);
	
	
	
}
