package com.example.Hostel.ServiceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Exception.BuildingServiceException;
import com.example.Hostel.Exception.FloorServiceException;
import com.example.Hostel.Exception.RoomServiceException;
import com.example.Hostel.dtos.FloorsDto;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Floors;
import com.example.Hostel.entity.Room;
import com.example.Hostel.repository.BuildingRepository;
import com.example.Hostel.repository.FloorRepository;
import com.example.Hostel.repository.RoomRepository;
import com.example.Hostel.service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	FloorRepository fRepo;

	@Autowired
	BuildingRepository buildingRepo;

	@Override
	public void save(FloorsDto dto) {
		Optional<Building> o = buildingRepo.findById(dto.getBuildingId());
		if (o.isEmpty()) {
			throw new BuildingServiceException(HttpStatus.BAD_REQUEST, Error.BULDING_ERROR);
		}
		Building b = o.get();

		Floors f = new Floors();
		f.setFloorNumber(dto.getFloorNo());
		f.setNumberOfRooms(dto.getNoOfRooms());
		f.setBuilding(b);
		fRepo.save(f);
	}

	@Override
	public void deleteFloor(int id) {
		if (fRepo.findById(id).isEmpty()) {
			throw new FloorServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		fRepo.deleteById(id);

	}

	@Override
	public Floors getFloor(int id) {
		if (fRepo.findById(id).isEmpty()) {
			throw new FloorServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}

		return fRepo.findById(id).get();
	}

	@Override
	public List<Floors> getFloors() {
		if (fRepo.findAll().isEmpty()) {
			throw new FloorServiceException(HttpStatus.BAD_REQUEST, Error.FLOOR_ERROR);
		}
		return fRepo.findAll();
	}

	@Override
	public void updateFloor(int id) {
		Floors f = new Floors();
		if (fRepo.findById(id).isEmpty()) {
			throw new FloorServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		Floors exist = fRepo.findById(id).get();

		exist.setFloorNumber(f.getFloorNumber());
		exist.setNumberOfRooms(f.getNumberOfRooms());
		fRepo.save(exist);
	}

}
