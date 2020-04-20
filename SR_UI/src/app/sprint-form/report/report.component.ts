import { Component, OnInit } from '@angular/core';
import { NgForm, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  submitted:boolean = false;
  report:FormGroup
  constructor() { }
  formTemplate = [
    {
      "type":"textBox",
      "label":"Name",
    },
    {
      "type":"number",
      "label":"Age"
    },
    {
      "type":"select",
      "label":"favorite book",
      "options":["Jane Eyre","Pride and Prejudice","Wuthering Heights"]
    }
  ]

  ngOnInit(): void {
    let group={}
    this.formTemplate.forEach(inputTemplate=>{
      group[inputTemplate.label]=new FormControl('');
    })
    this.report=new FormGroup(group)
  }

  //Captures the form data
  onSubmit() {
    console.log(this.report.value)
  }
}
