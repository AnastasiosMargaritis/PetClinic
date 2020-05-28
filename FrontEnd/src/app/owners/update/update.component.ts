import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Owner } from '../details/details.component';
import { OwnersService } from 'src/app/service/owners.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id: number;
  owner: Owner;

  constructor(private router: ActivatedRoute,
              private service: OwnersService,
              private route: Router) { }

  ngOnInit() {
    this.router.params.subscribe(
      params => {
        this.id = params['id'];
        this.service.getOnwerById(this.id).subscribe(
          response =>{
            this.getOwner(response);
          }
        )
      }
    )
  }

  getOwner(response){
    this.owner = response;
  }

  onUpdateOwner(form: NgForm){

    const value = form.value;

    const newOwner = new Owner(
      this.owner.id,
      value.firstName,
      value.lastName,
      value.address,
      value.city,
      value.telephone);

      console.log(value);

    this.service.updateOwner(this.owner.id, newOwner).subscribe(
      data => {
        this.route.navigate([this.owner.id, 'details']);
      }
    )
  }

}
