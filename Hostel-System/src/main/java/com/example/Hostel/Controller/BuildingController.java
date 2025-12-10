package com.example.Hostel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hostel.Constants.Successfull;
import com.example.Hostel.dtos.BuildingDto;
import com.example.Hostel.entity.Building;
import com.example.Hostel.service.BuildingService;

@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@PostMapping("hostel/Building")
	public ResponseEntity saveBuilding(@RequestBody BuildingDto dto) {
		buildingService.saveBuilding(dto);
		return new ResponseEntity(Successfull.SAVE_DATA, HttpStatus.CREATED);
	}

	@GetMapping("buildings")
	public ResponseEntity getBuildings() {
		return ResponseEntity.ok(buildingService.getBuildings());
	}

	@GetMapping("building/{id}")
	public ResponseEntity getBuilding(@PathVariable int id) {
		return ResponseEntity.ok(buildingService.getBuilding(id));
	}

	@PutMapping("update/building/{id}")
	public ResponseEntity updateBuilding(@PathVariable int id, @RequestBody Building building) {
		buildingService.updateBuilding(id, building);
		return ResponseEntity.ok(Successfull.UPDATE);
	}

	@DeleteMapping("delete/building/{id}")
	public ResponseEntity deleteBuilding(@PathVariable int id) {
		buildingService.deleteBuilding(id);
		return ResponseEntity.ok(Successfull.DELETE);
	}
}
