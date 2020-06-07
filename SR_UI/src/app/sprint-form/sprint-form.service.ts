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
  sprintReport: any;
  
  request:Request;
  constructor(private http: HttpClient) { }
  
  //Saves the sprint report info
  saveSprintReport(report){
    // this.buildDates(report.sprintStart);
    
    var s = JSON.stringify(this.createReport(report))
    console.log(s);
    return this.http.post<any>(this.endpoint + '/sprintreport/new',s);
    // this.saveRequests(report.otr, report.itr); //Need to get sprint number 
  }
  createReport(report){ 
    var sprintReport: any = {};
    sprintReport.teamID=report.team;
    sprintReport.sprintNum=report.sprintNum;
    sprintReport.sprintStartdate=report.sprintStartdate;
    sprintReport.sprintEnddate=report.sprintEnddate;
    sprintReport.scrumMasterEmail=report.smemail;
    sprintReport.planned_PBI_Completed=report.origPbiComp
    sprintReport.planned_PBI_NotCompleted=report.origPbiIncomp
    sprintReport.plannedBugCompleted=report.origBugComp
    sprintReport.plannedBugNotCompleted=report.origBugIncomp
    sprintReport.addon_PBI_Completed=report.addPbiComp
    sprintReport.addon_PBI_NotCompleted=report.addPbiIncomp
    sprintReport.addonBugCompleted=report.addBugComp
    sprintReport.addonBugNotCompleted=report.addBugIncomp
    sprintReport.reason1=report.R01
    sprintReport.reason2=report.R02
    sprintReport.reason3=report.R03
    sprintReport.reason4=report.R04
    sprintReport.reason5=report.R05
    sprintReport.reasonOther='';
    sprintReport.supportPBI=report.supportPbi
    sprintReport.supportBug=report.supportBug
    sprintReport.newValuePBI=report.newValuePbi
    sprintReport.newValueBug=report.newValueBug
    sprintReport.improvementPBI=report.improvementsPbi
    sprintReport.improvementBug=report.improvementsBug
    sprintReport.sprintCapacity=report.forecast;
    sprintReport.plannedCapacity=report.planned;
    sprintReport.actualCapacity=report.actual;
    sprintReport.estimatedHours=report.estimated;
    sprintReport.completedHours=report.completed;
    sprintReport.createDate="2020-05-15T20:00:00";
    sprintReport.lastUpdDate="2020-05-15T20:00:00";
    console.log("Create")
    console.log(sprintReport);
    return sprintReport;
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
    newDate= date.getFullYear()+'-'+ this.make2Digit(date.getMonth())+'-'+this.make2Digit(date.getDate());
    // console.log(newDate);
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
