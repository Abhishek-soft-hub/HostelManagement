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
import com.example.Hostel.dtos.FloorsDto;
import com.example.Hostel.entity.Floors;
import com.example.Hostel.service.FloorService;
@RestController
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
public class FloorController {

    @Autowired
    private FloorService floorService;
    
    @PostMapping("hostel/building/floor")
    public ResponseEntity savefloor(@RequestBody FloorsDto dto) {
    	floorService.save(dto);
    	return new ResponseEntity(Successfull.SAVE_DATA , HttpStatus.CREATED);
    }
    
    @DeleteMapping("hostel/floor/delete/{id}")
    public ResponseEntity deleteFloor(@PathVariable int id) {
    	floorService.deleteFloor(id);
		return new ResponseEntity(Successfull.DELETE , HttpStatus.OK) ;
    	
    }
    
    @GetMapping("building/floor/{id}")
    public ResponseEntity getFloor(@PathVariable int id) {
    	return new ResponseEntity(floorService.getFloor(id), HttpStatus.OK);
    }

    @GetMapping("building/floors")
    public ResponseEntity getFloors() {
    	return new ResponseEntity(floorService.getFloors(), HttpStatus.OK);
    }
    @GetMapping("update/floors")
    public ResponseEntity updateFloor(@PathVariable int id) {
    	floorService.updateFloor(id);
    	return new ResponseEntity(Successfull.UPDATE, HttpStatus.OK);
    }
}

