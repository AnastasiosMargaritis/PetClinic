import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  getAllPets(){
    return this.http.get("http://localhost:8080/pets");
  }

  getPetByOwnerId(id){
    return this.http.get(`http://localhost:8080/pets/owner/${id}`);
  }

  createPet(id: number, pet){
    return this.http.post(`http://localhost:8080/pets/owners/${id}/create`, pet);
  }

  updatePet(petId: number, pet){
    return this.http.put(`http://localhost:8080/pets/details/${petId}`, pet);
  }

}
