package com.example.Hostel.service;

import java.util.List;

import com.example.Hostel.dtos.BookingDto;
import com.example.Hostel.entity.Booking;

public interface BookingService {

	public void saveBooking(BookingDto dto);

	public void deleteBooking(int id);

	public void updateBooking(int id, Booking booking);

	public Booking getBooking(int id);

	public List<Booking> bookings();

}
