import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { formSection } from './formSection.model';
import { formElem } from './formElem.model';
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

  //Create the form structure
  createSprintForm(){
    var sprintForm:any = []
    var sprintFormSection:formSection;
    var sprintFormElem:formElem;
    var lastHeader = ''
    var sprintReportStructure = this.getSprintReportFrom();
    sprintReportStructure.forEach(element => {
      if(element.info_type="H"){
        sprintFormSection.title = element.work_desc;
        lastHeader = element.work_desc;
        sprintForm.push(sprintFormSection)
      }
      else{
        sprintFormElem.name = element.work_code
        sprintFormElem.type = element.info_type
        sprintFormElem.value = null;
        // sprintForm.indexOf(sprintFormSection.title=)
      }
    });
    console.log(sprintForm);
  }

  //Saves the sprint report info
  saveSprintReport(){

  }
}
