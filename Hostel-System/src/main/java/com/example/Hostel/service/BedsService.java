package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.BedDto;
import com.example.Hostel.dtos.BedsDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.entity.Building;

public interface BedsService {
	
	public void saveBeds(BedsDto beds);
	public void deleteBeds(int id);
	public Beds getBed(int id);
	public List<Beds> getBeds();
	public void updateBeds(int id );
	public List<BedDto> getAvaiableBeds(int shearing, int hostelId);


}
