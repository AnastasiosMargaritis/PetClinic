import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OwnersService } from 'src/app/service/owners.service';
import { Owner } from '../details/details.component';
import { ThrowStmt } from '@angular/compiler';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  owners: Owner[];
  isEmpty: boolean = true;

  constructor(private service: OwnersService,
              private route: Router) { }

  ngOnInit() {
  }

  register(form: NgForm){
    this.service.search(form.value.keyword).subscribe(
      response => this.getMatchedOwners(response)
    )

    form.resetForm();
  }

  getMatchedOwners(response){
    this.owners = response

    if(this.owners != null){
      this.isEmpty = false;
    }
  }

  ownerDetails(id : number){
    this.route.navigate([id, 'details']);
  }
}
