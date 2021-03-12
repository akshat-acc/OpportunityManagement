import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  BASE_URL='http://localhost:8080/user';
  ADD_USER='/add';
  GET_ALL_USER='/getAllUser';

  constructor(public http:HttpClient) { }

  public addUser(user:User):Observable<any>{
    return this.http.post(this.BASE_URL+this.ADD_USER,user);
  }

  public getAllUser():Observable<any>{
    return this.http.get(this.BASE_URL+this.GET_ALL_USER);
  }
}
