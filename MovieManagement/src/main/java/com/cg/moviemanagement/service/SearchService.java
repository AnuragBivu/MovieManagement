package com.cg.moviemanagement.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.moviemanagement.entities.Movie;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.MovieNotFoundException;
import com.cg.moviemanagement.exceptions.ShowException;

public interface SearchService {

	public List<Movie> getMovies(String searchStr)throws MovieNotFoundException;
	public List<Show> getShows(String screenName)throws ShowException;
	public List<Show> getShows(LocalDate searchDt, int movieId)throws ShowException;
	public List<Show> getShows(String screenName, LocalDate searchDt, int movieId)throws ShowException;
	public List<Show> getShows(String screenName, LocalDate searchDt)throws ShowException;
}
