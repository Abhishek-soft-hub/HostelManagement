package com.example.Hostel.ServiceImplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.Hostel.Constants.Error;
import com.example.Hostel.Exception.BedsServiceException;
import com.example.Hostel.Exception.BookingServiceException;
import com.example.Hostel.Exception.UserException;
import com.example.Hostel.dtos.BookingDto;
import com.example.Hostel.entity.Beds;
import com.example.Hostel.entity.Booking;
import com.example.Hostel.entity.User;
import com.example.Hostel.repository.BedsRepository;
import com.example.Hostel.repository.BookingRepository;
import com.example.Hostel.repository.UserReposiotry;
import com.example.Hostel.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepo;
	@Autowired
	BedsRepository bedRepo;
	@Autowired
	UserReposiotry userRepo;

	@Override
	public void saveBooking(BookingDto dto) {

		Optional<Beds> beds = bedRepo.findById(dto.getBedId());

		Optional<User> user = userRepo.findById(dto.getUserId());

		if (user.isEmpty()) {
			throw new UserException(Error.USER_ERROR + " Or " + Error.BEDS_ERROR, HttpStatus.BAD_REQUEST);
		}

		if (beds.isEmpty()) {
			throw new BedsServiceException(HttpStatus.BAD_REQUEST, Error.BEDS_ERROR);
		}

		Optional<Booking> existBeds = bookingRepo.findActiveBookingBeds(dto.getBedId());

		if (existBeds.isPresent()) {
			throw new BookingServiceException(Error.BOOKED_BEDS, HttpStatus.BAD_REQUEST);
		}

		Booking b = new Booking();
		b.setBookingDate(dto.getBookingDate());
		b.setChekIn(dto.getChekIn());
		b.setCheckout(dto.getCheckOut());
		b.setStatus(dto.getStatus());
		b.setPaymentMethod(dto.getPaymetMethod());
		b.setUser(user.get());
		b.setBeds(beds.get());
		bookingRepo.save(b);
	}

	@Override
	public void deleteBooking(int id) {
		Booking existBooking = bookingRepo.findById(id)
				.orElseThrow(() -> new BookingServiceException(Error.BOOKING_AVAILABILITY, HttpStatus.BAD_REQUEST));
		bookingRepo.deleteById(id);
	}

	@Override
	public void updateBooking(int id, Booking booking) {

		Booking existBooking = bookingRepo.findById(id)
				.orElseThrow(() -> new BookingServiceException(Error.BOOKING_AVAILABILITY, HttpStatus.BAD_REQUEST));
		existBooking.setChekIn(booking.getChekIn());
		existBooking.setCheckout(booking.getCheckout());
		existBooking.setBookingDate(booking.getBookingDate());
		existBooking.setPaymentMethod(booking.getPaymentMethod());
		existBooking.setStatus(booking.getStatus());

	}

	@Override
	public Booking getBooking(int id) {
		Booking existBooking = bookingRepo.findById(id)
				.orElseThrow(() -> new BookingServiceException(Error.BOOKING_AVAILABILITY, HttpStatus.BAD_REQUEST));
		return bookingRepo.findById(id).get();
	}

	@Override
	public List<Booking> bookings() {
		if(bookingRepo.findAll().isEmpty()) {
			throw new BookingServiceException(Error.BOOKING_AVAILABILITIS, HttpStatus.BAD_REQUEST);
		}
		return bookingRepo.findAll();
	}

}
