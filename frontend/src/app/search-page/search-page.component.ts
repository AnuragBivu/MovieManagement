import { Component, OnInit } from '@angular/core';
import { ThrowStmt } from '@angular/compiler';
import { Router } from "@angular/router";

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})

export class SearchPageComponent implements OnInit {
  constructor(private router: Router) { }

  ngOnInit() {
   
  }
  back() {
    // this.searchNameFlag = false;
     this.router.navigate(["/"]);
   }

  
}
