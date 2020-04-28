import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SprintFormService {
  endpoint:any = environment.apiUrl
  constructor(private http: HttpClient) { }
  
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

  //Saves the sprint report info
  saveSprintReport(){

  }
}
