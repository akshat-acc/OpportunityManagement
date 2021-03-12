import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Audit } from '../Models/audit';

@Injectable({
  providedIn: 'root'
})
export class AuditService {

  BASE_URL='http://localhost:8080/audit';
  ADD_AUDIT='/add';
  GET_ALL_AUDIT='/getAllAudit';

  constructor(public http:HttpClient) { }

  public addAudit(audit:Audit):Observable<any>{
    return this.http.post(this.BASE_URL+this.ADD_AUDIT,audit);
  }

  public getAllAudit():Observable<any>{
    return this.http.get(this.BASE_URL+this.GET_ALL_AUDIT);
  }
}
