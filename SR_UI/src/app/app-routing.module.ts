import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SprintFormComponent } from './sprint-form/sprint-form.component';
import { ReportComponent } from './sprint-form/report/report.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/form/report', pathMatch: 'full' },
  { path: 'form', component: SprintFormComponent, children:[
    { path: 'report', component: ReportComponent}
  ]},
  { path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash:true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
