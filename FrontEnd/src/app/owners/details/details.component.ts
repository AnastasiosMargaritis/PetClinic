import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OwnersService } from 'src/app/service/owners.service';
import { PetService } from 'src/app/service/pet.service';

export class Owner{
  constructor(public id:number,
              public firstName: string,
              public lastName: string,
              public address: string,
              public city: string,
              public telephone: string
              ){}
}

export class PetType{
  constructor(private id: number,
              private name: string){}
}

export class Pet{
  constructor(public id: number,
              private name: string,
              private birthDate: string,
              private petType: PetType){}
}

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  id: number;

  owner: Owner;
  pet: Pet;

  constructor(private router: ActivatedRoute,
              private service: OwnersService,
              private petService: PetService,
              private route: Router) { }

  ngOnInit() {
    this.router.params.subscribe(
      params => {
        this.id = params['id'];
        this.service.getOnwerById(this.id).subscribe(
          response => this.getOwner(response)
        );

        this.petService.getPetByOwnerId(this.id).subscribe(
          response2 => this.getPetByOwner(response2)
        )
      })

    };

    getOwner(response){
      this.owner = response;
    }

    getPetByOwner(response){
      this.pet = response;
      console.log(this.pet)
    }

    updateOwnerDetails(){
      this.route.navigate(['update', this.owner.id]);
    }

    addNewPet(){
      this.route.navigate(['create', 'pet', this.owner.id]);
    }

    updatePet(){
      this.route.navigate(['update', 'pet', this.owner.id]);
    }
}
