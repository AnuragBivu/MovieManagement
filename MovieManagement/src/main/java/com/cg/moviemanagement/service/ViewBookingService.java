package com.cg.moviemanagement.service;

import java.util.List;

import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;

public interface ViewBookingService {
	public List<Booking> getBookingDetails(String Contact)throws BookingException;
}
