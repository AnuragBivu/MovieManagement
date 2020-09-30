import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  movies: any;

  errorMsg:String;
  showAllMovies:boolean;
  showError:boolean;

  constructor(private service:MovieService,private router: Router) { }

  ngOnInit() {
    this.service.viewmovies().subscribe(
      data=>{this.movies=data,this.showAllMovies=true},
      error=>{this.errorMsg=error.error.message,this.showError=true}      );
  }
  back() {
    // this.searchNameFlag = false;
     this.router.navigate(["/"]);
   }
 
}
