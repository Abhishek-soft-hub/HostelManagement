package com.example.Hostel.ServiceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Exception.HostelServiceException;
import com.example.Hostel.dtos.HostelDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Floors;
import com.example.Hostel.entity.Hostel;
import com.example.Hostel.entity.Room;
import com.example.Hostel.entity.User;
import com.example.Hostel.repository.BedsRepository;
import com.example.Hostel.repository.BuildingRepository;
import com.example.Hostel.repository.FloorRepository;
import com.example.Hostel.repository.HostelRepository;
import com.example.Hostel.repository.RoomRepository;
import com.example.Hostel.repository.UserReposiotry;
import com.example.Hostel.service.HostelService;

@Service
public class HostelServiceImpl implements HostelService {
	@Autowired
	HostelRepository hostelRepo;
	@Autowired
	UserReposiotry userRepo;

	@Override
	public void saveHostel(HostelDto dto) {
		Hostel h = new Hostel();
		h.setName(dto.getName());
		h.setAddress(dto.getAddress());
		h.setCapacity(dto.getCapacity());
		h.setGender(dto.getGender());
		h.setMoNo(dto.getMoNo());
		hostelRepo.save(h);
	}

	@Override
	public void deleteHOstel(int id) {

		if (hostelRepo.findById(id) == null) {
			throw new HostelServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		hostelRepo.deleteById(id);
	}

	@Override
	public Hostel getHostel(int id) {

		if (hostelRepo.findById(id) == null) {
			throw new HostelServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		return hostelRepo.findById(id).get();
	}

	@Override
	public List<Hostel> getHostels() {
		if (hostelRepo.findAll().isEmpty()) {
			throw new HostelServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		return hostelRepo.findAll();
	}

	@Override
	public void updateHostel(int id, Hostel updatedHostel) {

		if (!hostelRepo.findById(id).isPresent()) {
			throw new HostelServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		Hostel existingHostel = hostelRepo.findById(id)
				.orElseThrow(() -> new RuntimeException(Error.HOSTEL_ERROR + " " + id));

		// 2. Update basic fields
		existingHostel.setName(updatedHostel.getName());
		existingHostel.setAddress(updatedHostel.getAddress());
		existingHostel.setCapacity(updatedHostel.getCapacity());
		existingHostel.setGender(updatedHostel.getGender());
		existingHostel.setMoNo(updatedHostel.getMoNo());

		hostelRepo.save(existingHostel);
	}

}
