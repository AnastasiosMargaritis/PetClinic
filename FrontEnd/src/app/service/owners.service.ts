import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Owner } from '../owners/details/details.component';



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

  createOwner(newOwner: Owner){
    return this.http.post("http://localhost:8080/owners", newOwner);
  }
}
