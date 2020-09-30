package com.cg.moviemanagement.service;

import java.util.List;

import com.cg.moviemanagement.dto.Screen;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.ShowException;


public interface ShowService {
	public List<Show> getShows(int movieId) throws ShowException ;
	public List<Screen> getScreens(int movieId)throws ShowException;
}
