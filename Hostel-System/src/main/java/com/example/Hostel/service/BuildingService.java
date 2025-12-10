package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.BuildingDto;
import com.example.Hostel.entity.Building;

public interface BuildingService {
	public void saveBuilding(BuildingDto dto) ;
	public void deleteBuilding(int id);
	public Building getBuilding(int id);
	public List<Building> getBuildings();
	public void updateBuilding(int id, Building update);

}
