import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SprintFormComponent } from './sprint-form/sprint-form.component';
import { ReportComponent } from './sprint-form/report/report.component';

const routes: Routes = [
  { path: '', redirectTo: '/form/report', pathMatch: 'full' },
  { path: 'form', component: SprintFormComponent, children:[
    { path: 'report', component: ReportComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash:true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
