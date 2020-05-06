import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup } from '@angular/forms';

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
  constructor() { }
  
  ngOnInit(): void {
    this.getReasons();
    this.getTeams();
    this.addSprintCategoriesHours(this.sprintCategory,this.sprintHours);
    // this.fillPreviousSprintReport()
  }

  // fillPreviousSprintReport(){
  //   var previousReport:any;// get previous sprint and use param to know how far back the previous sprint for selecting past sprints
  //   // Need to get past sprints otr/itr requests
  //   // Could do for each in previous sprint report 
  //   this.previousSprintReport.patchValue({
  //     team: previousReport.team_id,
  //     sprintStart: previousReport.sprint_start_date,
  //     sprintEnd: previousReport.sprint_end_date,
  //     origPbiComp: previousReport.planned_PBI_completed,
  //     origPbiIncomp: previousReport.planned_PBI_not_complete,
  //     origBugComp: previousReport.planned_bug_completed,
  //     origBugIncomp: previousReport.planned_bug_completed,
  //     addPbiComp: previousReport.Addon_PBI_completed,
  //     addPbiIncomp: previousReport.Addon_PBI_not_complete,
  //     addBugComp: previousReport.Addon_bug_completed,
  //     addBugIncomp: previousReport.Addon_bug_not_complete,
  //     R01: previousReport.reason_1,
  //     R02: previousReport.reason_2,
  //     R03: previousReport.reason_3,
  //     R04: previousReport.reason_4,
  //     R05: previousReport.reason_5,
  //   })//Do the rest manual for now
  //   // var reasonsCode = 'reason_';
  //   // for (let i = 0; i < this.reasons.length; i++) {
  //   //   reasonsCode = reasonsCode+ (i+1).toString();
  //   //   this.previousSprintReport.patchValue({ : previousReport.reasonsCode})
  //   // }
  //   // set value
  // }

  getReasons(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      this.addReasons(this.reasons);
    })
  }

  getTeams(){
    this.sprintFormService.getReasons().subscribe((data: Reason[])=>{
      // console.log(data);
      this.reasons = data;
      this.addReasons(this.reasons);
    })
  }


  //Captures the form data
  onSubmit(report:NgForm) {
    console.log(report.value)
  }
}
