package com.example.Hostel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Hostel;
@Repository
public interface HostelRepository extends JpaRepository<Hostel, Integer>{

}
