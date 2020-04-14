import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SprintFormComponent } from './sprint-form/sprint-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/form', pathMatch: 'full' },
  { path: 'form', component: SprintFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash:true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
