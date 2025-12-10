package com.example.Hostel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.example.Hostel.dtos.RoomsDto;
import com.example.Hostel.entity.Room;
import com.example.Hostel.service.RoomService;

@RestController
@CrossOrigin(origins = { "http://localhost:5500", "http://127.0.0.1:5500" })
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping("hostel/building/floor/room")
	public ResponseEntity saveRoom(@RequestBody List<RoomsDto> dto) {
		roomService.saveRooms(dto);
		return new ResponseEntity(Successfull.SAVE_DATA, HttpStatus.CREATED);
	}

	@GetMapping("floor/rooms")
	public ResponseEntity getRooms() {
		return ResponseEntity.ok(roomService.getRoom());
	}

	@GetMapping("floor/room/{id}")
	public ResponseEntity getRoom(@PathVariable int id) {
		return ResponseEntity.ok(roomService.getRoom(id));
	}

	@PutMapping("floor/room/edit/{id}")
	public ResponseEntity updateRoom(@PathVariable int id, @RequestBody Room room) {
		roomService.updateRoom(id, room);
		return ResponseEntity.ok(Successfull.UPDATE);
	}

	@DeleteMapping("floor/room/delete/{id}")
	public ResponseEntity deleteRoom(@PathVariable int id) {
		roomService.deleteRoom(id);
		return ResponseEntity.ok(Successfull.DELETE);
	}

	@GetMapping("room/aspershearing/{shearing}")
	public ResponseEntity getRoomAsPerSheraring(@PathVariable int shearing) {
		return new ResponseEntity(roomService.getRoomAsPerSheraring(shearing), HttpStatus.OK);

	};
}
