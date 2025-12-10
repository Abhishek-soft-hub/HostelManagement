package com.example.Hostel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.beds.id = :bedsId")
	public Optional<Booking> findActiveBookingBeds(@Param("bedsId") int bedsId);
}
