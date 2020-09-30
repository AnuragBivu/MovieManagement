import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { NgForm } from '@angular/forms';
import { formArrayNameProvider } from '@angular/forms/esm5/src/directives/reactive_directives/form_group_name';
import { Router } from "@angular/router";


@Component({
  selector: 'app-search-shows',
  templateUrl: './search-shows.component.html',
  styleUrls: ['./search-shows.component.css'],
 
})
export class SearchShowsComponent implements OnInit {

  screenname:String;
  moviedate:Date;

  show: any;

  toggleShowList;

  errorMsg:string;
  showError:boolean;

  constructor(private service: MovieService,private router: Router) { }

  ngOnInit() {
  }

  searchShow(form: NgForm){
    this.showError=false;
    this.toggleShowList=false;
    
    if(this.screenname!=null && this.moviedate==null){
      this.service.searchShowsScreenName(this.screenname).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true});
    }

    if(this.screenname!=null && this.moviedate!=null){
      this.service.showsForScreenDate(this.screenname,this.moviedate).subscribe(data=>{this.show=data,this.toggleShowList=true},
        error=>{this.errorMsg=error.error.message, this.showError=true}
        );
    }
    form.resetForm();
  }
  back() {
    // this.searchNameFlag = false;
     this.router.navigate(["/"]);
   }
 
}
