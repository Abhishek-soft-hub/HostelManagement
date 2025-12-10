package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.FloorsDto;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Floors;

public interface FloorService {

	public void save(FloorsDto dto);
	public void deleteFloor(int id);
	public Floors getFloor(int id);
	public List<Floors> getFloors();
	public void updateFloor(int id);

}
