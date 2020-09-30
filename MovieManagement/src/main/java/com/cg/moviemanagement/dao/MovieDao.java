package com.cg.moviemanagement.dao;

import java.util.List;

import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;

public interface MovieDao {

	public boolean addMovie(Movie movie);
	public boolean editMovie(Movie movie);
	public Movie viewMovie(int movieId);
	public List<Movie> viewActiveMovies();
	public List<Movie> getMovies(String searchStr);
	
	public List<Show> getShows(int movieId);
	public boolean editShow(Show show);
	public Show getShow(int showId);
	public List<Show> getShows(String screenName);
	public List<Show> getShows();
	
	public boolean addBooking(Booking booking);
	public List<Booking> getBookingDetailsContact(String contact);
	public int countBookingInfo();
	public Booking getBookingDetails(String bookingId);
	public long getMaxBookingId(int showId);
	public boolean removeBooking(Booking booking);

}
