import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IndexService {

  message:string = "Welcome to our Pet Clinic!";

  constructor(private http: HttpClient) { }

  restMessage(){
    return this.http.get("http://localhost:8080/");
  }
}
