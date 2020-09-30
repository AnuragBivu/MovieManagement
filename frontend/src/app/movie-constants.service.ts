import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieConstantsService {

    //public static base_url= "http://localhost:8877/moviemanagement/";
  public static base_url= "http://localhost:8877/";

   
    public static searchMovieUrl =MovieConstantsService.base_url+"searchmovie/"; 
    public static searchShowsForScreen = MovieConstantsService.base_url+"showsforscreen/";
    public static searchShowsScreenMovieDate =  MovieConstantsService.base_url+"viewshowsforscreenmoviedt/";
    public static searchShowsScreenDate = MovieConstantsService.base_url+"viewshowsforscreendt/";
    public static searchShowsMovieDate= MovieConstantsService.base_url+"viewshowsfordatemovieid/"; 
    
    
    public static viewmovies =MovieConstantsService.base_url+"viewmovies"; 
    public static viewnewmovies = MovieConstantsService.base_url+"viewnewmovies/";
  

    public static viewshows =MovieConstantsService.base_url+"viewshows/"; 
    public static viewscreens =MovieConstantsService.base_url+"viewscreen/"; 

    public static bookmovie= MovieConstantsService.base_url +"booking/";
    public static cancelbooking= MovieConstantsService.base_url+ "cancelbooking/";

    public static searchBookingDetails = MovieConstantsService.base_url+'getbooking/';

  
  constructor() { }
}
