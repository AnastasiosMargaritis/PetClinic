import { Component, OnInit } from '@angular/core';
import { OwnersService } from '../service/owners.service';

class Owners{

  constructor(private id: number, private firstName: string, private lastName: string){}

}

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {

  owners: Owners[];

  constructor(private service: OwnersService) { }

  ngOnInit() {
    this.service.getAllOwners().subscribe(
      response => this.getAllOwners(response)
    );
  }

  getAllOwners(response){
    this.owners = response;
  }

}
