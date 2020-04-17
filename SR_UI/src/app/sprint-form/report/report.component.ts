import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  submitted:boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  //Captures the form data
  onSubmit(form: NgForm) {
    
  }
}
