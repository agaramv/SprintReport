import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup } from '@angular/forms';
import { SprintFormService } from '../sprint-form.service';
import { Reason } from 'src/app/Models/reasons.model';
import { Team } from 'src/app/Models/team.model';
import { sprintReport } from 'src/app/Models/sprintReport.model';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  submitted:boolean = false;
  otr = new FormControl();
  otrList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  otrSelected: string[];
  itr = new FormControl();
  itrList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  sprintCategory:String[] = ['Forecast', 'Capacity','Estimated','Completed']
  reasons:Reason[]
  teams:Team[]
  otherEnabled=false;

  origPbiPerc:number=3;
  origBugPerc:number;
  addPbiPerc:number;
  addBugPerc:number;
  sprintReport: any; //Object to take form
  
  constructor(private sprintFormService: SprintFormService) { }
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
  }

  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      // console.log(this.reasons)
    })
  }

  getTeams(){
    this.sprintFormService.getTeams().subscribe((data: Team[])=>{
      // console.log(data);
      this.teams = data;
      // console.log(this.teams)
    })
  }

  //Captures the form data
  onSubmit(report:NgForm) {
    //need to change the report.value.sprintEnd and Start to the data format we want
    this.sprintReport = JSON.stringify(report.value);
    console.log(this.sprintReport)
  }

}
