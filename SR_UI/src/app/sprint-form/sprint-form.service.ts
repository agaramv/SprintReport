import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  saveSprintReport(report){
    this.buildDates(report.sprintStart); 
    return this.http.post<any>(this.endpoint+'/sprintreport/new',this.createReport(report))
    // this.saveRequests(report.otr, report.itr); //Need to get sprint number 
  }

  createReport(report){ 
    this.sprintReport.teamID=report.team;
    this.sprintReport.sprintNum=report.sprintNum;
    this.sprintReport.sprintStartdate=this.buildDates(report.sprintStart);
    this.sprintReport.sprintEnddate=this.buildDates(report.sprintEnd);
    this.sprintReport.scrumMasterEmail=report.smemail;
    this.sprintReport.planned_PBI_Completed=report.origPbiComp
    this.sprintReport.planned_PBI_NotCompleted=report.origPbiIncomp
    this.sprintReport.plannedBugCompleted=report.origBugComp
    this.sprintReport.plannedBugNotCompleted=report.origBugIncomp
    this.sprintReport.addon_PBI_Completed=report.addPbiComp
    this.sprintReport.addon_PBI_NotCompleted=report.addPbiIncomp
    this.sprintReport.addonBugCompleted=report.addBugComp
    this.sprintReport.addonBugNotCompleted=report.addBugIncomp
    this.sprintReport.reason1=report.R01
    this.sprintReport.reason2=report.R02
    this.sprintReport.reason3=report.R03
    this.sprintReport.reason4=report.R04
    this.sprintReport.reason5=report.R05
    this.sprintReport.reasonOther='';
    this.sprintReport.supportPBI=report.supportPbi
    this.sprintReport.supportBug=report.supportBug
    this.sprintReport.newValuePBI=report.newValuePbi
    this.sprintReport.newValueBug=report.newValueBug
    this.sprintReport.improvementPBI=report.improvementsPbi
    this.sprintReport.improvementBug=report.improvementsBug
    this.sprintReport.sprintCapacity=report.forecast;
    this.sprintReport.plannedCapacity=report.planned;
    this.sprintReport.actualCapacity=report.actual;
    this.sprintReport.estimatedHours=report.estimated;
    this.sprintReport.completedHours=report.completed;
    this.sprintReport.createDate="2020-05-15T20:00:00";
    this.sprintReport.lastUpdDate="2020-05-15T20:00:00";
    console.log("Create")
    console.log(this.sprintReport);
    return this.sprintReport;
  }

  // saveRequests(otrs, itrs){
  //   var request: Request;
  //     // console.log("Norm "+ this.request)
  //   otrs.forEach(element => {
  //     this.request = {
  //       team_id: 'team',
  //       sprint_num:3,
  //       category: 'otr',
  //       request_id: element
  //     };
  //     //Save Otrs
  //   });
  //   itrs.forEach(element => {
  //     this.request = {
  //       team_id: 'team',
  //       sprint_num:3,
  //       category: 'itr',
  //       request_id: element
  //     };
  //     //Save itrs
  //   });
  // }

  buildDates(date){
    var newDate = '';
    newDate= date.getFullYear()+'-'+ this.make2Digit(date.getMonth()+1)+'-'+this.make2Digit(date.getDate());
    console.log(newDate);
    return newDate
  }

  getRequests(){
    return this.http.get<any>(this.endpoint + '/otrequest/all');
  }

  getITRequests(){
    return this.http.get<any>(this.endpoint + '/otrequest/itr');
  }

  getOTRequests(){
    return this.http.get<any>(this.endpoint + '/otrequest/otr');
  }
  
  //Gets previous sprint with only team
  getPreviousSprintTeam(teamId){
    return this.http.get<any>(this.endpoint + '/lastsprintreport/byteamID/'+teamId);
  }

  //Gets previous sprint with team and sprint number needed
  getPreviousSprint(teamId, sprintNum){
    return this.http.get<any>(this.endpoint + '/sprintreport/byteam/'+teamId+'/sprintnum/'+sprintNum);
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

  //Get scrum master emails
  getEmails(){
    return this.http.get<any>(this.endpoint + '/scrummaster/email/all');
  }

  make2Digit(val){
    val=val.toString()
    if(val.length==1){
      val='0'+val.toString();
    }
    return val;
  }
}
