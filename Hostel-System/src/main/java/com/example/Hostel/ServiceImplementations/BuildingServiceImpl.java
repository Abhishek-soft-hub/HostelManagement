package com.example.Hostel.ServiceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Exception.BuildingServiceException;

import com.example.Hostel.Exception.HostelServiceException;
import com.example.Hostel.dtos.BuildingDto;
import com.example.Hostel.entity.Building;

import com.example.Hostel.entity.Hostel;
import com.example.Hostel.repository.BuildingRepository;

import com.example.Hostel.repository.HostelRepository;
import com.example.Hostel.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	BuildingRepository bRepo;

	@Autowired
	HostelRepository hostelRepo;

	@Override
	public void saveBuilding(BuildingDto dto) {

		Optional<Hostel> o = hostelRepo.findById(dto.getHostelId());
		if (o.isEmpty()) {
			throw new HostelServiceException(HttpStatus.BAD_REQUEST, Error.HOSTEL_ERROR);
		}
		Building b = new Building();
		b.setName(dto.getBuildingName());
		b.setFloors(dto.getNoOfFloors());
		Hostel h = o.get();
		b.setHostel(h);

		bRepo.save(b);
	}

	@Override
	public void deleteBuilding(int id) {
		if (bRepo.findById(id).isEmpty()) {
			throw new BuildingServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		bRepo.deleteById(id);

	}

	@Override
	public Building getBuilding(int id) {
		if (bRepo.findById(id).isEmpty()) {
			throw new BuildingServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		return bRepo.findById(id).get();
	}

	@Override
	public List<Building> getBuildings() {
		if (bRepo.findAll().isEmpty()) {
			throw new BuildingServiceException(HttpStatus.BAD_REQUEST, Error.BULDING_ERROR);
		}
		return bRepo.findAll();
	}

	@Override
	public void updateBuilding(int id, Building update) {
		if (bRepo.findById(id).isEmpty()) {
			throw new BuildingServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}

		Building exist = bRepo.findById(id).get();

		exist.setName(update.getName());
		exist.setFloors(update.getFloors());

		bRepo.save(exist);
	}

}
