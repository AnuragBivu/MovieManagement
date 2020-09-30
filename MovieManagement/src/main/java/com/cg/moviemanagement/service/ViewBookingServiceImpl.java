package com.cg.moviemanagement.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.util.MovieConstants;

@Transactional
@Service
public class ViewBookingServiceImpl implements ViewBookingService {

	@Autowired
	private MovieDao dao;
	
	@Override
	public List<Booking> getBookingDetails(String Contact) throws BookingException {
		List<Booking> bookingLst = dao.getBookingDetailsContact(Contact); 
		if(bookingLst.isEmpty())
			throw new BookingException(MovieConstants.BOOKING_NOT_AVAILABLE);
		bookingLst.sort((b1,b2)->b2.getBookingDate().compareTo(b1.getBookingDate()));
		return bookingLst;
	}

}
