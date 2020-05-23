import { Component, OnInit } from '@angular/core';
import { IndexService } from '../service/index.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  message: string;
  description: string;

  constructor(private service: IndexService) {
  }

  ngOnInit() {
      this.service.restMessage().subscribe(
        response => this.SuccessfulResponse(response)
      );
  }

  SuccessfulResponse(response){
    this.message = response.message;
    this.description = response.description;
  }
}
