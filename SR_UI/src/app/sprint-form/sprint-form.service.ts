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
    this.sprintReport.sprint_num=1;
    this.sprintReport.sprint_start_date=this.buildDates(report.sprintStart);
    this.sprintReport.sprint_end_date=this.buildDates(report.sprintEnd);
    this.sprintReport.scrum_master_email=report.smemail;
    this.sprintReport.planned_PBI_completed=report.origPbiComp
    this.sprintReport.planned_PBI_not_complete=report.origPbiIncomp
    this.sprintReport.planned_bug_completed=report.origBugComp
    this.sprintReport.planned_bug_not_complete=report.origBugIncomp
    this.sprintReport.Addon_PBI_completed=report.addPbiComp
    this.sprintReport.Addon_PBI_not_completed=report.addPbiIncomp
    this.sprintReport.Addon_bug_completed=report.addBugComp
    this.sprintReport.Addon_bug_not_completed=report.addBugIncomp
    this.sprintReport.reason_1=report.R01
    this.sprintReport.reason_2=report.R02
    this.sprintReport.reason_3=report.R03
    this.sprintReport.reason_4=report.R04
    this.sprintReport.reason_5=report.R05
    this.sprintReport.reason_other='';
    this.sprintReport.improvements=0;
    this.sprintReport.support_ind=0;
    this.sprintReport.new_value_ind=0;
    this.sprintReport.run_ind=0;
    this.sprintReport.grow_ind=0;
    this.sprintReport.transform_ind=0;
    this.sprintReport.sprint_capacity=report.forecast;
    this.sprintReport.planned_capacity=report.planned;
    this.sprintReport.actual_capacity=report.actual;
    this.sprintReport.estimated_hours=report.estimated;
    this.sprintReport.completed_hours=report.completed;
    this.sprintReport.createDate='2020-05-18';
    this.sprintReport.last_udpdate='2020-05-18';
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
    // return this.http.get<any>(this.endpoint + '/sprintreport/form');
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
