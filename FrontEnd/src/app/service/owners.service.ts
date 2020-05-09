import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class OwnersService {

  constructor(private http: HttpClient) { }


  getAllOwners(){
    return this.http.get("http://localhost:8080/owners");
  }
}
