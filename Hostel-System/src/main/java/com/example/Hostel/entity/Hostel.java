package com.example.Hostel.entity;

import java.util.List;

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
public class Hostel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private int capacity;
	private long moNo;
	private String gender;
	@ManyToOne()
	@JoinColumn(name = "orgnizationId")
	private Organization organization;

	@OneToMany(mappedBy = "hostel", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("hostel")
	private List<Building> building;

	public Hostel(int id, String name, String address, int capacity, long moNo, String gender,
			Organization organization, List<Building> building) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.capacity = capacity;
		this.moNo = moNo;
		this.gender = gender;
		this.organization = organization;
		this.building = building;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Building> getBuilding() {
		return building;
	}

	public void setBuilding(List<Building> building) {
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getMoNo() {
		return moNo;
	}

	public void setMoNo(long moNo) {
		this.moNo = moNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Hostel() {
	
		// TODO Auto-generated constructor stub
	}
	
	

}
