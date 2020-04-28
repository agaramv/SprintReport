import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup } from '@angular/forms';
import { SprintFormService } from '../sprint-form.service';
import { Reason } from 'src/app/Models/reasons.model';
import { Team } from 'src/app/Models/team.model';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  submitted:boolean = false;
  otr = new FormControl();
  otrList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  itr = new FormControl();
  itrList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  reasons:Reason[]
  teams:Team[]
  
  constructor(private sprintFormService: SprintFormService) { }
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
  }

  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      console.log(data);
      this.reasons = data;
      console.log(this.reasons)
    })
  }

  getTeams(){
    this.sprintFormService.getTeams().subscribe((data: Team[])=>{
      console.log(data);
      this.teams = data;
      console.log(this.teams)
    })
  }

  //Captures the form data
  onSubmit(report:NgForm) {
    console.log(report.value)
  }

}
