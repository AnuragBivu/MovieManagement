package com.cg.moviemanagement.exceptions;

public class MovieNotFoundException extends Exception{

	public MovieNotFoundException() {
		super();
	}
	
	public MovieNotFoundException(String msg) {
		super(msg);
	}
}
