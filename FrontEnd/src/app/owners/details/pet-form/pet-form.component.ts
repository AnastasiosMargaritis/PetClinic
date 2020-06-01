import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/service/pet.service';
import { Pet, PetType } from '../details.component';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-pet-form',
  templateUrl: './pet-form.component.html',
  styleUrls: ['./pet-form.component.css']
})

export class PetFormComponent implements OnInit {

  pets: Pet[];
  id: number;

  constructor(private service: PetService,
              private router: ActivatedRoute,
              private route: Router) { }

  ngOnInit() {

    this.router.params.subscribe(
      params => {
        this.id = params['id'];
        this.service.getAllPets().subscribe(
          response => this.getAllPets(response)
        )
      }
    )
  }

  getAllPets(response){
    this.pets = response;
  }

  onCreatePet(f: NgForm){
    const value = f.value;

    const newPet = new Pet(this.pets.length + 1,
                            value.name,
                            value.birthDate,
                            new PetType(0, value.petType))
    console.log(newPet);
    this.service.createPet(this.id, newPet).subscribe(
      data => {
        f.reset();
        this.route.navigate([this.id, 'details']);
      }
    )
  }
}
