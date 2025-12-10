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
public class Floors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int floorNumber;
	private int NumberOfRooms;
	@ManyToOne
	@JoinColumn(name = "building_Id")
	@JsonIgnoreProperties({"floor"})
	private Building building;
	
	@OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("floor")
	private List<Room> room;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getNumberOfRooms() {
		return NumberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		NumberOfRooms = numberOfRooms;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}
	
	

	
}
