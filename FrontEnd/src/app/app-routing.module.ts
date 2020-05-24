import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { OwnersComponent } from './owners/owners.component';
import { VetsComponent } from './vets/vets.component';
import { DetailsComponent } from './owners/details/details.component';
import { SearchComponent } from './owners/search/search.component';


const routes: Routes = [
  {path:'',component: IndexComponent},
  {path: 'owners', component: OwnersComponent},
  {path: 'vets', component: VetsComponent},
  {path: ':id/details', component: DetailsComponent},
  {path: 'search', component: SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
