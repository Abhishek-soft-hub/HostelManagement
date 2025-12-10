package com.example.Hostel.dtos;

import java.util.List;

import com.example.Hostel.entity.Beds;

public class RoomsDto {

	private int roomNo;
	private int noOfBeds;
	private int shearing;
	private String type;

	public int getShearing() {
		return shearing;
	}

	public void setShearing(int shearing) {
		this.shearing = shearing;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private int floorId;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

}
