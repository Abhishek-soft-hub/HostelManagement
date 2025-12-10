package com.example.Hostel.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int roomNumber;
	private int shearing;
	private String type;
	private int noOfBeds;

	@ManyToOne
	@JoinColumn(name = "floor_Id")
	@JsonIgnoreProperties({"room"})
	private Floors floor;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("room")
	private List<Beds> beds;

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

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

	public Floors getFloor() {
		return floor;
	}

	public void setFloor(Floors floor) {
		this.floor = floor;
	}

	public List<Beds> getBeds() {
		return beds;
	}

	public void setBeds(List<Beds> beds) {
		this.beds = beds;
	}

}
