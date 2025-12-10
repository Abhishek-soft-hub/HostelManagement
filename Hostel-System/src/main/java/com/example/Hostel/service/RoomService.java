package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.RoomsDto;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Room;

public interface RoomService {
	
	
	public void deleteRoom(int id);
	public Room getRoom(int id);
	public List<Room> getRoom();
	public void updateRoom(int id, Room r);
	public void saveRooms(List<RoomsDto> roomDto);
	public List<Room> getRoomAsPerSheraring( int shearing);


}
