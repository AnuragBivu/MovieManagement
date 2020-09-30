package com.cg.moviemanagement.service;


import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.dto.BookingForm;

public interface MovieBookingService {
	
	
	public String addBooking(BookingForm bookingForm)throws BookingException;
	public boolean cancelBooking(String bookingId);
	}


