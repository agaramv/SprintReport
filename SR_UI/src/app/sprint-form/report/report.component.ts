import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SprintFormService } from '../sprint-form.service';
import { Reason } from 'src/app/Models/reasons.model';
import { Team } from 'src/app/Models/team.model';
import { sprintReport } from 'src/app/Models/sprintReport.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit, OnDestroy {
  submitted:boolean = false;
  otrList: Request[];
  itrList: Request[];
  previous = false;
  sprintCategory:String[] = ['Forecast', 'Planned','Actual']
  sprintHours:String[]=['Estimated','Completed']
  reasons:Reason[]
  teams:Team[]
  smemails:any[];
  otherEnabled=false;
  sprintNumber: any;
  previousSprintNumber: any;
  private subscr: Subscription;
  
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
    supportPbi: [''],
    newValuePbi: [''],
    improvementsPbi: [''],
    supportBug: [''],
    newValueBug: [''],
    improvementsBug: [''],
    otr: [],
    itr: [],
  });
  
  constructor(private sprintFormService: SprintFormService, private fb:FormBuilder) { }
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
    this.getEmails();
    this.getOTITRequests()
    this.addSprintCategoriesHours(this.sprintCategory,this.sprintHours);
    this.checkingTeamValue()
  }

  ngOnDestroy() {
    // this.subscription.unsubscribe()
}

  checkingTeamValue(){
    this.subscr = this.sprintReport.get('team').valueChanges.subscribe(data => {
      this.fillSprintReport('start')
    })    
  }  
  //Need a function for the moment a team is selected the previousSprint for the team will be called and fill in some info
  //Could use fill previous sprint with parameters
  fillSprintReport(callType){
    // Need to get past sprints otr/itr requests
    let data
    if(callType=='start'){
      //Add something with past otrs
      this.sprintFormService.getPreviousSprintTeam(this.teamVal.value).subscribe((dat: any[])=>{
        data=dat[0];
        this.sprintNumber=(data.sprintNum)+1
        this.previousSprintNumber=data.sprintNum+1;
        this.sprintReport.patchValue({
          smemail: data.scrumMasterEmail
        })
      }) 
      this.subscr.unsubscribe();
    }
    if(callType=='previous'){
      this.previous=true;
      this.sprintFormService.getPreviousSprint(this.teamVal.value,this.previousSprintNumber-1).subscribe((dat: any[])=>{
        data=dat[0];
        // this.sprintNumber=dat[0].sprintNum;
        console.log(data.sprintNum)
        this.previousSprintNumber=data.sprintNum;
        console.log("SN "+ this.sprintNumber+" PN "+this.previousSprintNumber)
        this.sprintReport.patchValue({
          team: data.teamID,
          sprintStart: data.sprintStartdate,
          sprintEnd: data.sprintEnddate,
          smemail: data.scrumMasterEmail,
          origPbiComp: data.planned_PBI_Completed,
          origPbiIncomp: data.planned_PBI_NotCompleted,
          origBugComp: data.plannedBugCompleted,
          origBugIncomp: data.plannedBugNotCompleted,
          addPbiComp: data.addon_PBI_Completed,
          addPbiIncomp: data.addon_PBI_NotCompleted,
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
    }
    if(callType=='next'){
      if(this.sprintNumber==this.previousSprintNumber+1){
        this.previous=false
        this.fillSprintReport('new');
      }
      else{
        this.sprintFormService.getPreviousSprint(this.teamVal.value,this.previousSprintNumber+1).subscribe((dat: any[])=>{
          data=dat[0];
          this.previousSprintNumber=data.sprintNum;
          this.sprintReport.patchValue({
            team: data.teamID,
            sprintStart: data.sprintStartdate,
            sprintEnd: data.sprintEnddate,
            smemail: data.scrumMasterEmail,
            origPbiComp: data.planned_PBI_Completed,
            origPbiIncomp: data.planned_PBI_NotCompleted,
            origBugComp: data.plannedBugCompleted,
            origBugIncomp: data.plannedBugNotCompleted,
            addPbiComp: data.addon_PBI_Completed,
            addPbiIncomp: data.addon_PBI_NotCompleted,
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
      }
    }
    if(callType=='new'){
      this.previous=false;
      this.previousSprintNumber=this.sprintNumber-1;
      this.sprintReport.reset({team: this.teamVal.value, smemail: this.sprintReport.get('smemail').value})
    }
  }

  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      this.addReasons(this.reasons);
    })
    console.log(this.reasons)
  }

  addReasons(reasons: any[]){
    reasons.forEach(element => {
      this.sprintReport.addControl(element.code, new FormControl(false));
      // this.previousSprintReport.addControl(element.code, new FormControl(false));
    });
  }

  getTeams(){
    this.sprintFormService.getTeams().subscribe((data: Team[])=>{
      // console.log(data);
      this.teams = data;
      // console.log(this.teams)
    })
  }

  getEmails(){
    this.sprintFormService.getEmails().subscribe((data: any[])=>{
      this.smemails = data;
    })
  }

  getOTITRequests(){
    this.sprintFormService.getOTRequests().subscribe((data: Request[])=>{
      this.otrList=data;
    })
    this.sprintFormService.getITRequests().subscribe((data: Request[])=>{
      this.itrList=data;
    })
  }

  addSprintCategoriesHours(categories: any[], hours:any[]){
    categories.forEach(element => {
      this.sprintReport.addControl(element.toLowerCase(), new FormControl(''));
      // this.previousSprintReport.addControl(element.toLowerCase(), new FormControl(''));
    });

    hours.forEach(element => {
      this.sprintReport.addControl(element.toLowerCase(), new FormControl(''));
      // this.previousSprintReport.addControl(element.toLowerCase(), new FormControl(''));
    });
  }

  //Captures the form data
  onSubmit() {
    console.log(this.sprintReport.value)
    var newReport = this.sprintReport.value;
    newReport.sprintNum = this.sprintNumber;
    this.sprintFormService.saveSprintReport(newReport);
  }

  // Get Requests from form
  get teamVal() {return this.sprintReport.get('team')}
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
