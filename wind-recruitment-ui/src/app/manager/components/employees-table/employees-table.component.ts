import {Component, Input} from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {BadgeModule} from "primeng/badge";
import {Button} from "primeng/button";
import {WarningModalComponent} from "../warning-modal/warning-modal.component";
import {IconFieldModule} from "primeng/iconfield";
import {InputIconModule} from "primeng/inputicon";
import {InputTextModule} from "primeng/inputtext";
import {EmployeesResponsePage} from "../../services/employee/employee.service";

@Component({
  selector: 'app-employees-table',
  standalone: true,
  imports: [
    PrimeTemplate,
    TableModule,
    BadgeModule,
    Button,
    WarningModalComponent,
    IconFieldModule,
    InputIconModule,
    InputTextModule
  ],
  templateUrl: './employees-table.component.html',
  styleUrl: './employees-table.component.css'
})
export class EmployeesTableComponent {

  @Input({required: true}) employeesData : EmployeesResponsePage = {};

  employees = [
    {
      id: 1,
      full_name : "recruiter 1",
      email: "recruiter1@domain.com",
      speciality: "HR recruiter",
      accountVerified : true
    },{
      id: 2,
      full_name : "recruiter 2",
      email: "recruiter2@domain.com",
      speciality: "Full stack JAVA",
      accountVerified : true
    },{
      id: 3,
      full_name : "recruiter 3",
      email: "recruiter3@domain.com",
      speciality: "HR recruiter",
      accountVerified : true
    },{
      id: 4,
      full_name : "recruiter 4",
      email: "recruiter4@domain.com",
      speciality: "MERN stack specialist",
      accountVerified : false
    },{
      id: 5,
      full_name : "recruiter 5",
      email: "recruiter5@domain.com",
      speciality: "Devops specialist",
      accountVerified : false
    },
  ]

}
