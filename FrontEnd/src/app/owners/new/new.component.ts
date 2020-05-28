import { Component, OnInit } from '@angular/core';
import { Owner } from '../details/details.component';
import { NgForm } from '@angular/forms';
import { OwnersService } from 'src/app/service/owners.service';
import { OwnersComponent } from '../owners.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new',
  templateUrl: './new.component.html',
  styleUrls: ['./new.component.css']
})
export class NewComponent implements OnInit {
  constructor(private service: OwnersService,
              private route: Router) { }

  owners: Owner[];

  ngOnInit() {
    this.service.getAllOwners().subscribe(
      response => this.getAllOwners(response)
    );
  }

  getAllOwners(response){
    this.owners = response;
  }

  onCreateOwner(form: NgForm){
  const value = form.value;
  console.log(value);
  const newOwner = new Owner(this.owners.length + 1,
                    value.firstName,
                    value.lastName,
                    value.address,
                    value.city,
                    value.telephone);

  this.service.createOwner(newOwner).subscribe(
    data =>{
      this.route.navigate([newOwner.id, 'details']);
    }
  );
  form.reset();
  this.route.navigate(['owners']);
  }

}
