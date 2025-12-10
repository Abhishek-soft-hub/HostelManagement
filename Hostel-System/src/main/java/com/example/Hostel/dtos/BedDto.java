package com.example.Hostel.dtos;

public class BedDto {

	private int roomNo;
	private int floorNo;
	private String bildingName;
	private String hostelName;
	private int bedNo;
	private int bedPrice;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getBildingName() {
		return bildingName;
	}

	public void setBildingName(String bildingName) {
		this.bildingName = bildingName;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public int getBedNo() {
		return bedNo;
	}

	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}

	public int getBedPrice() {
		return bedPrice;
	}

	public void setBedPrice(int bedPrice) {
		this.bedPrice = bedPrice;
	}

}
