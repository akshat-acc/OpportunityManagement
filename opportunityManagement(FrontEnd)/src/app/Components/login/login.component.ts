import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SocialAuthService, GoogleLoginProvider, SocialUser } from 'angularx-social-login';
import { AuthguardService } from 'src/app/Service/authguard.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private socialService : SocialAuthService,private authguardService:AuthguardService) { }

  socialUser:SocialUser;
  isLoggedin:Boolean;

  ngOnInit(): void {
    
    this.socialService.authState.subscribe((user)=>{
      this.socialUser = user;
      this.isLoggedin = (user != null);
      console.log(this.socialUser);
    });

    if(localStorage.getItem("APP_TOKEN")){
      this.router.navigate(['menu']);
    }
  }

  signInWithGoogle() : any{
    this.authguardService.signingInWithGoogle();
  }

  signOut() : any{
    this.authguardService.signingOut();
  }
}


