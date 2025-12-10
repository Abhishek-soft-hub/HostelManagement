package com.example.Hostel.excepionHandle;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Hostel.Exception.BedsServiceException;
import com.example.Hostel.Exception.BookingServiceException;
import com.example.Hostel.Exception.BuildingServiceException;
import com.example.Hostel.Exception.FloorServiceException;
import com.example.Hostel.Exception.HostelServiceException;
import com.example.Hostel.Exception.OrganizationServiceException;
import com.example.Hostel.Exception.PayementServiceException;
import com.example.Hostel.Exception.RoomServiceException;
import com.example.Hostel.Exception.UserException;
import com.example.Hostel.entity.Building;
import com.example.Hostel.entity.Organization;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = HostelServiceException.class)
	public ResponseEntity<String> hostelException(HostelServiceException hs) {
		return new ResponseEntity<>(hs.getMessage(), hs.getHtttpStatus());
	}

	@ExceptionHandler(exception = BuildingServiceException.class)
	public ResponseEntity<String> buildingException(BuildingServiceException hs) {
		return new ResponseEntity<>(hs.getMessage(), hs.getHtttpStatus());
	}

	@ExceptionHandler(exception = FloorServiceException.class)
	public ResponseEntity<String> floorException(FloorServiceException hs) {
		return new ResponseEntity<>(hs.getMessage(), hs.getHtttpStatus());
	}

	@ExceptionHandler(exception = RoomServiceException.class)
	public ResponseEntity<String> roomException(RoomServiceException hs) {
		return new ResponseEntity<>(hs.getMessage(), hs.getHtttpStatus());
	}

	@ExceptionHandler(exception = BedsServiceException.class)
	public ResponseEntity<String> bedsException(BedsServiceException hs) {
		return new ResponseEntity<>(hs.getMessage(), hs.getHtttpStatus());
	}

	@ExceptionHandler(exception = UserException.class)
	public ResponseEntity userException(UserException ue) {
		return new ResponseEntity(ue.getMessage(), ue.getHttp());
	}

	@ExceptionHandler(exception = OrganizationServiceException.class)
	public ResponseEntity organization(OrganizationServiceException org) {
		return new ResponseEntity(org.getMessage(), org.getHttp());
	}

	@ExceptionHandler(exception = BookingServiceException.class)
	public ResponseEntity<String> booking(BookingServiceException booking) {
		return new ResponseEntity<String>(booking.getMessage(), booking.getHtttpStatus());

	}

	@ExceptionHandler(exception = PayementServiceException.class)
	public ResponseEntity payment(PayementServiceException payment) {
		return new ResponseEntity(payment.getMessage(), payment.getHttpStatus());

	}
}
