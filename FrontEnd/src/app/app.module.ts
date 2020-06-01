import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpParams  } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { IndexComponent } from './index/index.component';
import { OwnersComponent } from './owners/owners.component';
import { VetsComponent } from './vets/vets.component';
import { DetailsComponent } from './owners/details/details.component';
import { SearchComponent } from './owners/search/search.component';
import { NewComponent } from './owners/new/new.component';
import { UpdateComponent } from './owners/update/update.component';
import { PetFormComponent } from './owners/details/pet-form/pet-form.component';
import { NewPetComponent } from './owners/details/new-pet/new-pet.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    OwnersComponent,
    VetsComponent,
    DetailsComponent,
    SearchComponent,
    NewComponent,
    UpdateComponent,
    PetFormComponent,
    NewPetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
