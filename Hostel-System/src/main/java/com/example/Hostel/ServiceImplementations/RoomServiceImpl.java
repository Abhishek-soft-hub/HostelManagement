package com.example.Hostel.ServiceImplementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Exception.FloorServiceException;
import com.example.Hostel.Exception.RoomServiceException;
import com.example.Hostel.dtos.BedsDto;
import com.example.Hostel.dtos.RoomsDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.entity.Floors;
import com.example.Hostel.entity.Room;
import com.example.Hostel.repository.BedsRepository;
import com.example.Hostel.repository.FloorRepository;
import com.example.Hostel.repository.RoomRepository;
import com.example.Hostel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	FloorRepository floorRepo;
	
	
	

	@Override
	public void saveRooms(List<RoomsDto> listRoomDto) {
		for (RoomsDto dto : listRoomDto) {

			Optional<Floors> o = floorRepo.findById(dto.getFloorId());
			if (o.isEmpty()) {
				throw new FloorServiceException(HttpStatus.BAD_REQUEST, Error.FLOOR_ERROR);
			}
			Floors f = o.get();

			Room r = new Room();
			r.setRoomNumber(dto.getRoomNo());
			r.setShearing(dto.getShearing());
			r.setType(dto.getType());
			r.setNoOfBeds(dto.getNoOfBeds());
			r.setFloor(f);
			

			
			roomRepo.save(r);
		}

	}

	@Override
	public void deleteRoom(int id) {
		if (roomRepo.findById(id).isEmpty()) {
			throw new RoomServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		roomRepo.deleteById(id);
	}

	@Override
	public Room getRoom(int id) {
		if (roomRepo.findById(id).isEmpty()) {
			throw new RoomServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		return roomRepo.findById(id).get();
	}

	@Override
	public List<Room> getRoom() {
		if (roomRepo.findAll().isEmpty()) {
			throw new RoomServiceException(HttpStatus.BAD_REQUEST, Error.ROOM_ERROR);
		}
		return roomRepo.findAll();
	}

	@Override
	public void updateRoom(int id, Room r) {
		if (roomRepo.findById(id).isEmpty()) {
			throw new RoomServiceException(HttpStatus.BAD_REQUEST, Error.ERROR);
		}
		Room exist = roomRepo.findById(id).get();
		exist.setRoomNumber(r.getRoomNumber());
		exist.setShearing(r.getShearing());
		exist.setType(r.getType());

		roomRepo.save(exist);
	}

	@Override
	public List<Room> getRoomAsPerSheraring(int shearing) {
		
		return roomRepo.getRoomAsPerSheraring(shearing);
	}

}
