package com.example.Hostel.ServiceImplementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Controller.FloorController;
import com.example.Hostel.Exception.BedsServiceException;
import com.example.Hostel.dtos.BedDto;
import com.example.Hostel.dtos.BedsDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.entity.Booking;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Floors;
import com.example.Hostel.entity.Hostel;
import com.example.Hostel.entity.Room;
import com.example.Hostel.repository.BedsRepository;
import com.example.Hostel.repository.RoomRepository;
import com.example.Hostel.service.BedsService;

@Service
public class BedServiceImpl implements BedsService {

	@Autowired
	BedsRepository bRepo;
	@Autowired
	RoomRepository rRepo;

	@Override
	public void saveBeds(BedsDto dto) {

		Optional<Room> o = rRepo.findById(dto.getRoomId());
		if (o.isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.ROOM_ERROR);
		}
		Room room = o.get();

		Beds beds = new Beds();
		beds.setBedNo(dto.getBedNo());
		beds.setPrice(dto.getPrice());
		beds.setStatus(dto.getStatus());
		beds.setRoom(room);

		bRepo.save(beds);
	}

	@Override
	public void deleteBeds(int id) {

		if (bRepo.findById(id).isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		bRepo.deleteById(id);

	}

	@Override
	public Beds getBed(int id) {
		if (bRepo.findById(id).isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		return bRepo.findById(id).get();
	}

	@Override
	public List<Beds> getBeds() {
		if (bRepo.findAll().isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.BEDS_ERROR);
		}
		return bRepo.findAll();
	}

	@Override
	public void updateBeds(int id) {

		Beds b = new Beds();
		if (bRepo.findById(id).isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		Beds exist = bRepo.findById(id).get();

		exist.setBedNo(b.getBedNo());
		exist.setPrice(b.getPrice());

		bRepo.save(exist);

	}

	@Override
	public List<BedDto> getAvaiableBeds(int shearing, int hosetlId) {
		List<BedDto> bedDto = new ArrayList<BedDto>();
		List<Beds> listBeds = bRepo.getVacantBeds(shearing, hosetlId);

		for (Beds beds : listBeds) {
			Room r = beds.getRoom();
			Floors f = r.getFloor();
			Building b = f.getBuilding();
			Hostel h = b.getHostel();

			BedDto dto = new BedDto();
			dto.setBedNo(beds.getBedNo());
			dto.setBedPrice(beds.getPrice());

			dto.setRoomNo(r.getRoomNumber());
			dto.setFloorNo(f.getFloorNumber());
			dto.setBildingName(b.getName());
			dto.setHostelName(h.getName());

			bedDto.add(dto);

		}
		return bedDto;
	}

}
