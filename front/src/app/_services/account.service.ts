import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const API_URL = 'http://localhost:8082/api/accounts/';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) { }

  getAccounts(): Observable<Array<any>> {
    return this.http.get<Array<any>>(API_URL);
  }

}
