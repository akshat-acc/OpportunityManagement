import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { Router } from '@angular/router';
import { SocialUser } from 'angularx-social-login';
import { AuthguardService } from 'src/app/Service/authguard.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  loggedInUser:SocialUser

  constructor(private router:Router, private authguardService:AuthguardService) { }

  ngOnInit(): void {
    this.loggedInUser=JSON.parse(localStorage.getItem("user"));
  }

  logoutUser(){
    this.authguardService.signingOut();
  }

  home(){
    this.router.navigate(['/home/opportunity']);
  }

}

