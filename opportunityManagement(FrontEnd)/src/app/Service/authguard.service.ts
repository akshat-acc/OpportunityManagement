import { Injectable } from '@angular/core';
import {SocialAuthService} from 'angularx-social-login';
import {SocialUser, GoogleLoginProvider} from 'angularx-social-login';
import { Router} from '@angular/router'
import { Observable } from 'rxjs';
import { UserService } from './user.service';
import { User } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  user : SocialUser;
  storageUser:any;
  dBUser:User=new User();
  userList:Array<string>=[];

  constructor(private aService : SocialAuthService,private router:Router, private userService:UserService) { }

  public signingInWithGoogle():any{
    this.aService.signIn(GoogleLoginProvider.PROVIDER_ID).then((user)=>{
      this.user = user;
      console.log(this.user);
      this.storageUser={
        "id":this.user.id,
        "name":this.user.firstName+" "+this.user.lastName,
        "email":this.user.email,
        "photo":this.user.photoUrl
      }
      // this.dBUser={
      //   "userId":0,
      //   "firstName":this.user.firstName,
      //   "lastName":this.user.lastName,
      //   "email":this.user.email
      // }
      this.dBUser.firstName=this.user.firstName;
      this.dBUser.lastName=this.user.lastName;
      this.dBUser.email=this.user.email;
      localStorage.setItem("APP_TOKEN", this.user.idToken);
      localStorage.setItem("user",JSON.stringify(this.storageUser));
      this.userService.getAllUser().subscribe(resp=>{
        console.log(resp);
        for(let i=0;i<resp.length;i++){
            this.userList.push(resp[i].email);
        }
        console.log(this.userList);
        if(!this.userList.includes(this.user.email)){
          this.userService.addUser(this.dBUser).subscribe((resp)=>{
            console.log("User Added"+" resp: "+resp);
          });
        }
      })
      this.router.navigate(['menu']);
    },(error)=>{
      console.log(error);
    });
  }

  public signingOut():any{
    this.aService.signOut();
    localStorage.removeItem("APP_TOKEN");
    //sessionStorage.removeItem("APP_TOKEN")
    this.router.navigate(['login']);
  }

  public isAuthenticated(): boolean {
    console.log(this.user);
    if (!localStorage.getItem("APP_TOKEN")) {
      return false;
    }
    return true;
  }

  canActivate(): boolean{
    if (!this.isAuthenticated()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
