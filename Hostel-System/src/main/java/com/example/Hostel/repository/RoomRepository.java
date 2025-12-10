package com.example.Hostel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query("SELECT DISTINCT r FROM Room r " + "JOIN r.beds b " + "WHERE r.shearing = :sharing "
			+ "AND b.status = 'AVAILABLE'")
	public List<Room> getRoomAsPerSheraring(@Param("sharing") int shearing);
}
