import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Request } from '../Models/request.model';

@Injectable({
  providedIn: 'root'
})
export class SprintFormService {
  endpoint:any = environment.apiUrl
  sprintReport: any[];
  request:Request;
  constructor(private http: HttpClient) { }
  
  //Saves the sprint report info
  saveSprintReport(report){
    // this.buildDates(report.sprintStart);
    this.saveRequests(report.otr, report.itr); //Need to get sprint number 
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
    console.log(newDate);
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
