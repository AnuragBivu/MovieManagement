package com.cg.moviemanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.service.SearchService;
import com.cg.moviemanagement.service.ViewMovieService;

@SpringBootTest
class MovieManagementSystemApplicationTests {
	@MockBean
	ViewMovieService service;
	   @MockBean
	   MovieDao dao;
	   @MockBean
	   SearchService search;

	   @Test
		public void testSearchMovie() throws MovieNotFoundException {
			search.getMovies("hindi");
			verify(search,times(1)).getMovies("hindi");
		}
 
		
		@Test
		public void testviewAllMovies() throws MovieNotFoundException {

			service.viewMovies();
			verify(service, times(1)).viewMovies();
		}
		
		@Test
		public void testviewActiveMovies() throws MovieNotFoundException {

			service.viewNewMovies();
			verify(service, times(1)).viewNewMovies();
		}
		
		@Test
		void test() {
			
		}
 
 	/*	@Test
	    void testAddMovie() {
			
			Movie movie= new Movie();
			movie.setActive(1);
			movie.setDirector("Rajamouli");
			movie.setGenre("Action");
			movie.setMovieId(3001);
			movie.setMovieName("Bahubali");
			Mockito.when(dao.addMovie(movie));
			assertThat(dao.addMovie(movie)).isEqualTo(movie);
		}
 	
		
		@Test
		public void testDeleteMovie() {
			
			service.deletemovie(3005);
			verify(service,times(1)).deletemovie(3005);
		}*/

}
	
	
	
	
	
	
 