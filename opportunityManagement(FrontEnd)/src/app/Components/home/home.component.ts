import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialUser } from 'angularx-social-login';
import { AuthguardService } from 'src/app/Service/authguard.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  loggedInUser:SocialUser

  constructor(private router:Router, private authguardService:AuthguardService) { }

  ngOnInit(): void {
    this.loggedInUser=JSON.parse(localStorage.getItem("user"));
  }

  logoutUser(){
    this.authguardService.signingOut();
  }
}
