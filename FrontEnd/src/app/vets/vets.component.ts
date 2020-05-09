import { Component, OnInit } from '@angular/core';
import { VetService } from '../service/vet.service';

class Vet{
  constructor(private id: number, private firstName: string, private lastName: string){

  }
}

@Component({
  selector: 'app-vets',
  templateUrl: './vets.component.html',
  styleUrls: ['./vets.component.css']
})
export class VetsComponent implements OnInit {

  vets: Vet[];

  constructor(private service: VetService) { }

  ngOnInit() {
    this.service.getAllVets().subscribe(
      response => this.getAllVets(response)
    );
  }

  getAllVets(response){
    this.vets = response;
  }

}
