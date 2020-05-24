import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class OwnersService {

  constructor(private http: HttpClient) { }


  getAllOwners(){
    return this.http.get("http://localhost:8080/owners");
  }

  getOnwerById(id){
    return this.http.get(`http://localhost:8080/owners/${id}`);
  }

  getPetByOwnerId(id){
    return this.http.get(`http://localhost:8080/pets/owner/${id}`);
  }

  search(searchField){

    return this.http.get("http://localhost:8080/owners/search", {
      params:{
        keyword: searchField
      }
    });
  }
}
