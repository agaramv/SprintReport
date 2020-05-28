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
  previous = false;
  sprintCategory:String[] = ['Forecast', 'Planned','Actual']
  sprintHours:String[]=['Estimated','Completed']
  reasons:Reason[]
  teams:Team[]
  smemails:any[] = ['vidur@gmail.com','cow@gmail.com','test@gmail.com']
  otherEnabled=false;
  sprintNumber;
  previousSprintNumber;
  
  sprintReport = this.fb.group({
    team: [''],
    sprintStart: [''],
    sprintEnd: [''],
    smemail: [''],
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
    smemail: [''],
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
    this.fillPreviousSprintReport()
  }

  fillPreviousSprintReport(){
    // Need to get past sprints otr/itr requests
    var data
    this.sprintFormService.getPreviousSprint('CR').subscribe((dat: any[])=>{
      data=dat[0];
      // console.log(data);
      // console.log(data.scrumMasterEmail);
      this.previousSprintNumber=(data.sprintNum)+1
      this.sprintReport.patchValue({
        team: data.teamID,
        sprintStart: data.sprintStartdate,
        sprintEnd: data.sprintEnddate,
        smemail: data.scrumMasterEmail,
        origPbiComp: data.planned_PBI_Completed,
        origPbiIncomp: data.planned_PBI_NotCompleted,
        origBugComp: data.plannedBugCompleted,
        origBugIncomp: data.plannedBugNotCompleted,
        addPbiComp: data.addon_PBI_completed,
        addPbiIncomp: data.addon_PBI_not_completed,
        addBugComp: data.addonBugCompleted,
        addBugIncomp: data.addonBugNotCompleted,
        R01: JSON.parse(data.reason1),
        R02: JSON.parse(data.reason2),
        R03: JSON.parse(data.reason3),
        R04: JSON.parse(data.reason4),
        R05: JSON.parse(data.reason5),
        forecast: data.sprintCapacity,
        planned: data.plannedCapacity,
        actual: data.actualCapacity,
        estimated: data.estimatedHours,
        completed: data.completedHours,
      })
    }) 
    console.log(this.sprintReport.value)
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
    console.log(this.sprintReport.value)
    this.sprintFormService.saveSprintReport(this.sprintReport.value);
  }

  // Get Requests from form
  get origPbiComp(): any {return Number(this.sprintReport.get('origPbiComp').value)}
  get origPbiIncomp(): any {return Number(this.sprintReport.get('origPbiIncomp').value)}
  get origBugComp(): any {return Number(this.sprintReport.get('origBugComp').value)}
  get origBugIncomp(): any {return Number(this.sprintReport.get('origBugIncomp').value)}
  get addPbiComp(): any {return Number(this.sprintReport.get('addPbiComp').value)}
  get addPbiIncomp(): any {return Number(this.sprintReport.get('addPbiIncomp').value)}
  get addBugComp(): any {return Number(this.sprintReport.get('addBugComp').value)}
  get addBugIncomp(): any {return Number(this.sprintReport.get('addBugIncomp').value)}
  get otrSelect() {return this.sprintReport.get('otr')}
  get itrSelect() {return this.sprintReport.get('itr')}


}
