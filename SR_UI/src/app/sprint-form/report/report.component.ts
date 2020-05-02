import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup, FormBuilder } from '@angular/forms';
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
  sprintReport = this.fb.group({
    team: [''],
    sprintStart: [''],
    sprintEnd: [''],
    origPbiComp: [''],
    origPbiIncomp: [''],
    origBugComp: [''],
    origBugIncomp: [''],
    addPbiComp: [''],
    addPbiIncomp: [''],
    addBugComp: [''],
    addBugIncomp: [''],
    otr: [],
    itr: [],
    Forecast: [''],
    Capacity: [''],
    Estimated: [''],
    Completed: [''],
  });
  
  constructor(private sprintFormService: SprintFormService, private fb:FormBuilder) { }
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
  onSubmit() {
    //need to change the report.value.sprintEnd and Start to the data format we want
    let form = JSON.stringify(this.sprintReport.value);
    //save form api
    console.log(this.sprintReport)
    console.log(this.sprintReport.value.otr);
    // console.log(form)
  }

  get origPbiComp(): any {return this.sprintReport.get('origPbiComp')}
  get origPbiIncomp(): any {return this.sprintReport.get('origPbiIncomp')}
  get origBugComp(): any {return this.sprintReport.get('origBugComp')}
  get origBugIncomp(): any {return this.sprintReport.get('origBugIncomp')}
  get addPbiComp(): any {return this.sprintReport.get('addPbiComp')}
  get addPbiIncomp(): any {return this.sprintReport.get('addPbiIncomp')}
  get addBugComp(): any {return this.sprintReport.get('addBugComp')}
  get addBugIncomp(): any {return this.sprintReport.get('addBugIncomp')}
  get otrSelect() {return this.sprintReport.get('otr')}
  get itrSelect() {return this.sprintReport.get('itr')}


}
