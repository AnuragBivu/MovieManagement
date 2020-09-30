package com.cg.moviemanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.moviemanagement.dao.MovieDao;
import com.cg.moviemanagement.dto.Screen;
import com.cg.moviemanagement.entities.Show;
import com.cg.moviemanagement.exceptions.ShowException;
import com.cg.moviemanagement.util.MovieConstants;

@Transactional
@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	private MovieDao dao;
	
	
	@Override
	public List<Show> getShows(int movieId) throws ShowException {
		List<Show> showList=dao.getShows(movieId);
		if(showList.isEmpty())
		{
			throw new ShowException(MovieConstants.SHOW_NOT_AVAILABLE);
		}
		showList = showList.stream().filter(show->show.getShowDate().isAfter(LocalDate.now())).collect(Collectors.toList());
		showList.sort((s1,s2)->s2.getShowDate().compareTo(s1.getShowDate()));
			return showList;	
	}
	
	
	@Override
	public List<Screen> getScreens(int movieId) throws ShowException {
		List<Show> showList=dao.getShows(movieId);
		if(showList.isEmpty())
		{
			throw new ShowException(MovieConstants.SCREEN_NOT_AVAILABLE);
		}
		showList = showList.stream().filter(show->show.getShowDate().isAfter(LocalDate.now())).collect(Collectors.toList());
		showList.sort((s1, s2)->s1.getScreenName().compareTo(s2.getScreenName()));
		String tmp = MovieConstants.EMPTY;
		
		Screen screen=null;
		List<Screen> screenList = new ArrayList<>();
		for(Show show: showList) {
			
			if(tmp.equalsIgnoreCase(show.getScreenName())) {
				screen.setShowNames(screen.getShowNames() + ", " + show.getScreenName());
			}else {
				screen = new Screen();
				screen.setMovie(show.getMovie());
				screen.setScreenName(show.getScreenName());
				screen.setScreenImg(show.getScreenImg());
				screen.setShowNames(show.getShowName());
				screen.setShowDate(show.getShowDate());
				screenList.add(screen);
			}
		}	
		return screenList;
	}
}
