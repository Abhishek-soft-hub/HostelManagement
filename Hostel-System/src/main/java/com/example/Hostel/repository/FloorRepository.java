package com.example.Hostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Floors;
@Repository
public interface FloorRepository extends JpaRepository<Floors, Integer> {

}
