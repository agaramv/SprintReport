import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm, FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SprintFormService } from '../sprint-form.service';
import { Reason } from 'src/app/Models/reasons.model';
import { Team } from 'src/app/Models/team.model';
import { sprintReport } from 'src/app/Models/sprintReport.model';
import { Subscription } from 'rxjs';
import { repeatWhen } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  submitted:boolean = false;
  otrList: Request[];
  itrList: Request[];
  previous = false;
  firstSprint = false;
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
  
  constructor(private sprintFormService: SprintFormService, private fb:FormBuilder, private http: HttpClient) { }
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
    this.getEmails();
    this.getOTITRequests()
    this.addSprintCategoriesHours(this.sprintCategory,this.sprintHours);
    this.checkingTeamValue()
  }

  checkingTeamValue(){
    //Need to change so that when someone changes the team the subscription won't end
    this.sprintReport.get('team').valueChanges
    .pipe(repeatWhen(()=>{
      this.teamVal!=
    }))
    .subscribe(data => {
      this.fillSprintReport('start')
    })    
  }  
 
  fillSprintReport(callType){
    // Need to get past sprints otr/itr requests
    let data
    //Start is for intializing the sprint number and populating the smemail when the user selects a team
    if(callType=='start'){
      //Add previous sprint otrs/itrs
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
    //Previous changes the form elements to the previous Sprint Report of the team selected
    if(callType=='previous'){
      if(this.previousSprintNumber==2){
        this.firstSprint = true;
      }
      else{
        this.previous=true;
      }
      this.sprintFormService.getPreviousSprint(this.teamVal.value,this.previousSprintNumber-1).subscribe((dat: any[])=>{
        data=dat[0];
        // this.sprintNumber=dat[0].sprintNum;
        this.previousSprintNumber=data.sprintNum;
        console.log("Previous SN "+ this.sprintNumber+" PN "+this.previousSprintNumber)
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
    //Nextt changes the form elements to the next Sprint Report of the team selected. Activate only when previous has been clicked
    if(callType=='next'){
      if(this.sprintNumber==this.previousSprintNumber+1){
        this.previous=false
        this.fillSprintReport('new');
        this.previousSprintNumber+=1;
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
      console.log("Next"+"SN "+ this.sprintNumber+" PN "+this.previousSprintNumber)
    }
    //New resets the form for the user to enter a new sprint report of the team selected
    if(callType=='new'){
      this.previous=false;
      this.sprintReport.reset({team: this.teamVal.value, smemail: this.sprintReport.get('smemail').value})
      console.log("New"+"SN "+ this.sprintNumber+" PN "+this.previousSprintNumber)
    }
  }

  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      this.addReasons(this.reasons);
    })
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
    this.addSprintReport(newReport);
  }

  addSprintReport(newReport){
    this.sprintFormService.saveSprintReport(newReport).subscribe(data=>{
      console.log(data)
    })
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
