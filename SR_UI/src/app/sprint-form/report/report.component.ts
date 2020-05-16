import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
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

  sprintCategory:String[] = ['Forecast', 'Planned','Actual']
  sprintHours:String[]=['Estimated','Completed']
  reasons:Reason[]
  teams:Team[]
  smemails:any[]
  otherEnabled=false;

  origPbiPerc:number=3;
  origBugPerc:number;
  addPbiPerc:number;
  addBugPerc:number;
  sprintReport = this.fb.group({
    smemail: [''],
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
  });
  previousSprintReport = this.fb.group({
    team_id: [''],
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
  });
  
  constructor(private sprintFormService: SprintFormService, private fb:FormBuilder) { }
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
    this.addSprintCategoriesHours(this.sprintCategory,this.sprintHours);
    // this.fillPreviousSprintReport()
  }

  fillPreviousSprintReport(){
    var previousReport;// get previous sprint and use param to know how far back the previous sprint for selecting past sprints
    // Need to get past sprints otr/itr requests
    // Could do for each in previous sprint report 
    this.previousSprintReport.patchValue({
      team_id: previousReport.team_id,
      sprintStart: previousReport.sprint_start_date,
      sprintEnd: previousReport.sprint_end_date,
      origPbiComp: previousReport.planned_PBI_completed,
      origPbiIncomp: previousReport.planned_PBI_not_complete,
      origBugComp: previousReport.planned_bug_completed,
      origBugIncomp: previousReport.planned_bug_completed,
      addPbiComp: previousReport.Addon_PBI_completed,
      addPbiIncomp: previousReport.Addon_PBI_not_complete,
      addBugComp: previousReport.Addon_bug_completed,
      addBugIncomp: previousReport.Addon_bug_not_complete,
      R01: previousReport.reason_1,
      R02: previousReport.reason_2,
      R03: previousReport.reason_3,
      R04: previousReport.reason_4,
      R05: previousReport.reason_5,
    })//Do the rest manual for now
    // var reasonsCode = 'reason_';
    // for (let i = 0; i < this.reasons.length; i++) {
    //   reasonsCode = reasonsCode+ (i+1).toString();
    //   this.previousSprintReport.patchValue({ : previousReport.reasonsCode})
    // }
    // set value
  }


  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      this.addReasons(this.reasons);
    })
  }

  addReasons(reasons: any[]){
    // var title = "reason_";
    // for (let index = 0; index < reasons.length; index++) {
    //   title=title+(index+1).toString()
    //   this.sprintReport.addControl(title, new FormControl(false));
    //   this.previousSprintReport.addControl(title, new FormControl(false));
    // }
    reasons.forEach(element => {
      this.sprintReport.addControl(element.code, new FormControl(false));
      this.previousSprintReport.addControl(element.code, new FormControl(false));
    });
  }

  getTeams(){
    this.sprintFormService.getTeams().subscribe((data: Team[])=>{
      // console.log(data);
      this.teams = data;
      // console.log(this.teams)
    })
  }

  addSprintCategoriesHours(categories: any[], hours:any[]){
    categories.forEach(element => {
      this.sprintReport.addControl(element.toLowerCase(), new FormControl(''));
      // this.previousSprintReport.addControl(element.toLowerCase(), new FormControl(''));
    });

    hours.forEach(element => {
      this.sprintReport.addControl(element.toLowerCase(), new FormControl(''));
      this.previousSprintReport.addControl(element.toLowerCase(), new FormControl(''));
    });
  }

  //Captures the form data
  onSubmit() {
    //need to change the report.value.sprintEnd and Start to the data format we want
    let form = JSON.stringify(this.sprintReport.value);
    //save form api
    console.log(this.sprintReport)
    this.sprintFormService.saveSprintReport(this.sprintReport.value);
  }

  // Get Requests from form
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
