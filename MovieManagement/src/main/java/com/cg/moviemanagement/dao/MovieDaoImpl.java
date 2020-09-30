package com.cg.moviemanagement.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cg.moviemanagement.entities.Booking;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;


@Repository
public class MovieDaoImpl implements MovieDao{

	@PersistenceContext
	private EntityManager em;
 
	@Override
	public boolean addMovie(Movie movie) 
	{
		if(true)
		{
		
			em.persist(movie);
			return true;
		}
		
		return false;

	}

	@Override
	public boolean editMovie(Movie movie) {
		em.merge(movie);
		return true;
	}
	
	@Override
	public Movie viewMovie(int movieId) {
		
		return em.find(Movie.class, movieId);
	}
	
	/**************************************************************************************************
     *Method:    viewActiveMovies
     *description:   display all the records of movie which are active.
     *@returns                 -List of movies details
     *created by               -Prameela
     *created date             -26-SEP-2020
**************************************************************************************************/
	@Override
	public List<Movie> viewActiveMovies() {
		String jpql = "from Movie m where m.active=1";
		TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		
		return query.getResultList();
	}
	/*********************************************************************************************************************
	 * Method: getMovies 
	 * Description: To give a list of movies from database by taking movie name/movie director/ movie genre as input.
	 * @param searchStr: Movie's name/ movie genre/ movie director's name.
	 *              Created By - prameela
	 *              Created Date - 26-SEP-2020
	 *********************************************************************************************************************/

	@Override
	public List<Movie> getMovies(String searchStr) {
		searchStr = searchStr.toLowerCase();
		String Qstr = "from Movie m where (LOWER(m.movieName) like :str or LOWER(m.director) like :str or LOWER(m.language) like :str or LOWER(m.genre) like :str) or m.movieName like :str or m.director like :str or m.language like :str or m.genre like :str";
		
			TypedQuery<Movie> query = em.createQuery(Qstr,Movie.class);
			query.setParameter("str",searchStr);
			return query.getResultList();
	}

	 
	
	
	@Override
	public List<Show> getShows(int movieId) {
		String jpql = "from Show s inner join fetch s.movie m where m.movieId=:mid ";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("mid", movieId);
	
		return query.getResultList();
	}

	@Override
	public boolean editShow(Show show) {
		em.merge(show);
		return true;
	}

	@Override
	public boolean addBooking(Booking booking) {
		em.persist(booking);
		return true;
	}

	
	@Override
	public List<Booking> getBookingDetailsContact(String contact) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.contact=:phone";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		
		query.setParameter("phone", contact);
		return query.getResultList();
	}

	@Override
	public Booking getBookingDetails(String bookingId) {
		String jpql = "from Booking b inner join fetch b.show s inner join fetch s.movie m where b.bookingId=:bid";
		TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
		query.setParameter("bid", bookingId);
		return query.getSingleResult();
	}
	
	@Override
	public int countBookingInfo() {
		String jpql = "select count(bookingId) from Booking";
		TypedQuery<Integer> query = em.createQuery(jpql,Integer.class);
		return query.getSingleResult();
		
	}

	 
	@Override
	public Show getShow(int showId) {
		return em.find(Show.class, showId);
	}

	
	@Override
	public long getMaxBookingId(int showId) {
		String jpql = "select count(b.bookingId) from Booking b join b.show s where s.showId=:showid";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("showid", showId);
		return query.getSingleResult();
	}

	
	@Override
	public List<Show> getShows(String screenName) {
		String jpql = "from Show s inner join fetch s.movie m where s.screenName=:screenname and s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		
		query.setParameter("screenname", screenName);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
	}

	@Override
	public List<Show> getShows() {
		String jpql = "from Show s inner join fetch s.movie m where  s.showDate >= :dt";
		TypedQuery<Show> query = em.createQuery(jpql, Show.class);
		query.setParameter("dt", LocalDate.now());
		return query.getResultList();
		
	}

	@Override
	public boolean removeBooking(Booking booking) {
		em.remove(booking);
		return true;
	}
}
