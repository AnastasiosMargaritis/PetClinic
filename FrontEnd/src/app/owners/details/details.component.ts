import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OwnersService } from 'src/app/service/owners.service';

export class Owner{
  constructor(private id:number,
              private firstName: string,
              private lastName: string,
              private address: string,
              private city: string,
              private telephone: string
              ){}
}

class PetType{
  constructor(private id: number,
              private name: string){}
}

class Pet{
  constructor(private id: number,
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
  pet: Pet[];

  constructor(private router: ActivatedRoute,
              private service: OwnersService) { }

  ngOnInit() {
    this.router.params.subscribe(
      params => {
        this.id = params['id'];
        this.service.getOnwerById(this.id).subscribe(
          response => this.getOwner(response)
        );

        this.service.getPetByOwnerId(this.id).subscribe(
          response2 => this.getPetByOwner(response2)
        )
      })

    };

    getOwner(response){
      this.owner = response;
    }

    getPetByOwner(response){
      this.pet = response;
    }
}
