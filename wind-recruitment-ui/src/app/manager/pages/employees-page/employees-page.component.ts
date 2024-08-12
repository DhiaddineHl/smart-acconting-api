import {Component, inject, OnInit, ViewChild} from '@angular/core';
import {EmployeesTableComponent} from "../../components/employees-table/employees-table.component";
import {NavigationBarComponent} from "../../components/navigation-bar/navigation-bar.component";
import {RegisteringModalComponent} from "../../components/registering-modal/registering-modal.component";
import {SearchbarComponent} from "../../../recruiter/component/searchbar/searchbar.component";
import {TabViewModule} from "primeng/tabview";
import {EmployeeService, EmployeesResponsePage} from "../../services/employee/employee.service";

@Component({
  selector: 'app-employees-page',
  standalone: true,
  imports: [
    EmployeesTableComponent,
    NavigationBarComponent,
    RegisteringModalComponent,
    SearchbarComponent,
    TabViewModule
  ],
  templateUrl: './employees-page.component.html',
  styleUrl: './employees-page.component.css'
})
export class EmployeesPageComponent implements OnInit{

  @ViewChild(EmployeesTableComponent) employeesTable! :EmployeesTableComponent;

  size:number = 10;
  number: number = 0;

  employeeService = inject(EmployeeService);

  hrResponse: EmployeesResponsePage = {};
  technicalResponse: EmployeesResponsePage = {};

  getAllTechnicalRecruiter = () => {
    this.employeeService.getAllTechnicalRecruiter(
      this.size, this.number
    ).subscribe({
      next: (response) => {
        this.technicalResponse = response;
        console.log(this.technicalResponse)
      },error : (err) => {
        console.log("error fetching technical recruiters", err)
      }
    })
  }

  getAllHRRecruiter = () => {
    this.employeeService.getAllHRRecruiter(
      this.size, this.number
    ).subscribe({
      next: (response) => {
        this.hrResponse = response;
        console.log(this.hrResponse)
      },error : (err) => {
        console.log("error fetching technical recruiters", err)
      }
    })
  }

  ngOnInit(): void {
    this.getAllHRRecruiter();
    this.getAllTechnicalRecruiter()
  }


}
