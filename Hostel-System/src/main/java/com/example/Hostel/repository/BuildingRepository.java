package com.example.Hostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Building;
@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer>{

}
