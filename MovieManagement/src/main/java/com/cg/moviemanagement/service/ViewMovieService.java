package com.cg.moviemanagement.service;

import java.util.List;

import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
public interface ViewMovieService {

	public List<Movie> viewMovies() throws MovieNotFoundException;
	public List<Movie> viewNewMovies() throws MovieNotFoundException;
	boolean addmovie(Movie movie);
	 
}
