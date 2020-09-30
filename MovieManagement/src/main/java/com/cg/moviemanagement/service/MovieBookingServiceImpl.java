package com.cg.moviemanagement.service;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.dto.BookingForm;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.BookingException;
import com.cg.moviemanagement.util.MovieConstants;

@Transactional
@Service
public class MovieBookingServiceImpl implements MovieBookingService {

	@Autowired
	private MovieDao dao;

	
	@Override
	public String addBooking(BookingForm bookingForm) throws BookingException {
		Show show = dao.getShow(bookingForm.getShowId());
		long bid =dao.getMaxBookingId(bookingForm.getShowId()) +1;
		if (show.getSeats() >= bookingForm.getTkts()) {
			String id= ""+show.getShowId()+""+bid;
			double cost= 250* bookingForm.getTkts();
			Booking booking = new Booking();
			booking.setBookingId(id);
			booking.setContact(bookingForm.getContact());
			booking.setUserName(bookingForm.getUserName());
			booking.setNoOfTkts(bookingForm.getTkts());
			booking.setBookingDate(LocalDate.now());
			booking.setTotalCost(cost);
			booking.setShow(show);
			show.setSeats(show.getSeats() - bookingForm.getTkts());
			dao.editShow(show);
			dao.addBooking(booking);
			return id;
		}
		throw new BookingException(MovieConstants.TKT_NOT_AVAILABLE);

	}

	
	@Override
	public boolean cancelBooking(String bookingId) {
		Booking booking = dao.getBookingDetails(bookingId);
		Show show = booking.getShow();
		show.setSeats(show.getSeats() + booking.getNoOfTkts());
		dao.editShow(show);
		dao.removeBooking(booking);
		return true;
	}	
}
