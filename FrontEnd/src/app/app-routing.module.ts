import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { OwnersComponent } from './owners/owners.component';
import { VetsComponent } from './vets/vets.component';


const routes: Routes = [
  {path:'',component: IndexComponent},
  {path: 'owners', component: OwnersComponent},
  {path: 'vets', component: VetsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
