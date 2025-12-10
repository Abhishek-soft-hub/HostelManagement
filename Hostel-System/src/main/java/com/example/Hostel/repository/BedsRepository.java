package com.example.Hostel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Hostel.entity.Beds;

@Repository
public interface BedsRepository extends JpaRepository<Beds, Integer>{
	 @Query("""
		        SELECT b FROM Beds b 
		        WHERE b.status = "A"
		        AND b.room.shearing = :shearing
		        AND b.room.floor.building.hostel.id = :hostelId
		    """)
		    List<Beds> getVacantBeds(
		            @Param("shearing") int shearing,
		            @Param("hostelId") int hostelId
		    );

}
