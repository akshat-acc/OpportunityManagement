import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Opportunity } from '../Models/opportunity';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OpportunityService {

  BASE_URL='http://localhost:8080/opportunity';
  ADD_OPPORTUNITY='/add';
  GET_ALL_OPPORTUNITY='/getAll';
  DELETE_OPPORTUNITY='/delete';
  EDIT_OPPORTUNITY='/update';

  constructor(public http:HttpClient) { }

  public addOpportunity(opportunity: Opportunity):Observable<any>{
    return this.http.post(this.BASE_URL+this.ADD_OPPORTUNITY,opportunity);
  }

  public getAllOppertunity():Observable<any>{
    return this.http.get(this.BASE_URL+this.GET_ALL_OPPORTUNITY);
  }

  public deleteOpportunity(id:Number): Observable<any>{
    return this.http.delete(this.BASE_URL+this.DELETE_OPPORTUNITY+'/'+id);
  }

  public EditDetails(opportunity:Opportunity,id) : Observable<any>{
    return this.http.post(this.BASE_URL + this.EDIT_OPPORTUNITY+'/'+id,opportunity);
  }
}
