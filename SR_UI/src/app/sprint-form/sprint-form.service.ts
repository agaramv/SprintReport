import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Request } from '../Models/request.model';
import { sprintReport } from '../Models/sprintReport.model';

@Injectable({
  providedIn: 'root'
})
export class SprintFormService {
  endpoint:any = environment.apiUrl
  sprintReport: any = {};
  request:Request;
  constructor(private http: HttpClient) { }
  
  //Saves the sprint report info
  saveSprintReport(report){//Missing values are run, grow, transform, newValue, Support, 
    // this.buildDates(report.sprintStart);
    this.createReport(report);
    let s = JSON.stringify(this.sprintReport)
    console.log(s)
    return this.http.post<any>(this.endpoint + '/sprintreport/new',s);
    // this.saveRequests(report.otr, report.itr); //Need to get sprint number 
  }
// Missing add pbi and bug ot complete 
  createReport(report){ 
    this.sprintReport.teamId='CR'
    this.sprintReport.sprintNum=5;
    this.sprintReport.sprintStartdate="2020-05-15";
    this.sprintReport.sprintEnddate="2020-05-15";
    this.sprintReport.scrumMasterEmail=report.smemail;
    this.sprintReport.planned_PBI_completed=report.origPbiComp
    this.sprintReport.planned_PBI_not_complete=report.origPbiIncomp
    this.sprintReport.plannedBugCompleted=report.origBugComp
    this.sprintReport.plannedBugNotCompleted=report.origBugIncomp
    this.sprintReport.Addon_PBI_completed=report.addPbiComp
    this.sprintReport.Addon_PBI_not_completed=report.addPbiIncomp
    this.sprintReport.AddonBugCompleted=report.addBugComp
    this.sprintReport.AddonBugNotCompleted=report.addBugIncomp
    this.sprintReport.reason1=report.R01
    this.sprintReport.reason2=report.R02
    this.sprintReport.reason3=report.R03
    this.sprintReport.reason4=report.R04
    this.sprintReport.reason5=report.R05
    this.sprintReport.reasonOther='';
    this.sprintReport.improvement=0;
    this.sprintReport.supportInd=0;
    this.sprintReport.newValueInd=0;
    this.sprintReport.runInd=0;
    this.sprintReport.growInd=0;
    this.sprintReport.transformInd=0;
    this.sprintReport.sprintCapacity=report.forecast;
    this.sprintReport.plannedCapacity=report.planned;
    this.sprintReport.actualCapacity=report.actual;
    this.sprintReport.estimatedHours=report.estimated;
    this.sprintReport.completedHours=report.completed;
    this.sprintReport.createDate="2020-05-15T20:00:00";
    this.sprintReport.last_udpdate="2020-05-15T20:00:00";
    console.log("Create")
    console.log(this.sprintReport);
  }

  saveRequests(otrs, itrs){
    var request: Request;
      // console.log("Norm "+ this.request)
    otrs.forEach(element => {
      this.request = {
        team_id: 'team',
        sprint_num:3,
        category: 'otr',
        request_id: element
      };
      //Save Otrs
    });
    itrs.forEach(element => {
      this.request = {
        team_id: 'team',
        sprint_num:3,
        category: 'itr',
        request_id: element
      };
      //Save itrs
    });
  }

  buildDates(date){
    var newDate = '';
    newDate= date.getFullYear()+'-'+ this.make2Digit(date.getMonth())+'-'+this.make2Digit(date.getDate());
    // console.log(newDate);
    return newDate
  }
  
  //Gets previous sprint
  getPreviousSprint(){
    return this.http.get<any>(this.endpoint + '/sprintreport/form');
    return 1;
  }

  //Gets the form from db
  getSprintReportFrom(){
    return this.http.get<any>(this.endpoint + '/sprintreport/form');
  }

  //Gets teams from db
  getTeams(){
    return this.http.get<any>(this.endpoint + '/agileteam/all');
  }

  //Gets reasons from db
  getReasons(){
    return this.http.get<any>(this.endpoint + '/reason/all');
  }

  make2Digit(val){
    val=val.toString()
    if(val.length==1){
      val='0'+val.toString();
    }
    return val;
  }
}
