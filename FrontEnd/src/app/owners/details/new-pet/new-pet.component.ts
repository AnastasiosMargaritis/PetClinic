import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/service/pet.service';
import { Pet, PetType } from '../details.component';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-pet',
  templateUrl: './new-pet.component.html',
  styleUrls: ['./new-pet.component.css']
})
export class NewPetComponent implements OnInit {

  pet: Pet;
  id: number;

  constructor(private service: PetService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        this.id = params['id'];
        this.service.getPetByOwnerId(this.id).subscribe(
          response => this.getPet(response)
        )
      }
    )
  }

  getPet(response){
    this.pet = response;
    console.log(this.pet)
  }

  onUpdatePet(f: NgForm){

    const value = f.value;
    console.log(value);

    const newPet = new Pet(
        this.pet[0].id,
        value.Name,
        value.birthDate,
        new PetType(0, value.petType)
    );

    this.service.updatePet(this.pet[0].id, newPet).subscribe(
      data => {
        this.router.navigate([this.id, 'details']);
      }
    )

  }

}
