import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SprintFormService {
  endpoint:any = environment.apiUrl
  constructor(private http: HttpClient) { }

  //Gets the form structure
  getSprintReportFrom(){
    return this.http.get<any>(this.endpoint + '/appointments/all');
  }

  //Saves the sprint report info
  saveSprintReport(){

  }
}
