import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class VetService {

  constructor(private http: HttpClient) { }


  getAllVets(){
    return this.http.get("http://localhost:8080/vets");
  }
}
