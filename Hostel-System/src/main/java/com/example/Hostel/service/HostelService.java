package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.HostelDto;
import com.example.Hostel.entity.Hostel;

public interface HostelService {
	
	public void saveHostel(HostelDto dtos);
	public void deleteHOstel(int id);
	public Hostel getHostel(int id);
	public List<Hostel> getHostels();
	public void updateHostel(int id, Hostel updatedHostel );

}
