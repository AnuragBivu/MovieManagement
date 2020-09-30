package com.cg.moviemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.moviemanagement.dto.Screen;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.service.ShowService;

@RestController
public class ShowController {
	@Autowired
	ShowService movieservice;
	
	@CrossOrigin
	@GetMapping("/viewshows/{movieid}")
	public List<Show> getShows(@PathVariable("movieid") int movieId) throws ShowException
	{
		List<Show> shows = movieservice.getShows(movieId);
		return shows;
		
	}
	
	@CrossOrigin
	@GetMapping("/viewscreen/{movieid}")
	public List<Screen> getScreen(@PathVariable("movieid") int movieId) throws ShowException
	{
		List<Screen> screens = movieservice.getScreens(movieId);
		return screens;
		
	}
	
	
	
}
