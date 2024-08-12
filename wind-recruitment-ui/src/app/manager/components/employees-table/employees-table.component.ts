import {Component, EventEmitter, inject, Input, Output} from '@angular/core';
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {BadgeModule} from "primeng/badge";
import {Button} from "primeng/button";
import {WarningModalComponent} from "../warning-modal/warning-modal.component";
import {IconFieldModule} from "primeng/iconfield";
import {InputIconModule} from "primeng/inputicon";
import {InputTextModule} from "primeng/inputtext";
import {EmployeeService, EmployeesResponsePage} from "../../services/employee/employee.service";
import {DialogModule} from "primeng/dialog";

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
    InputTextModule,
    DialogModule
  ],
  templateUrl: './employees-table.component.html',
  styleUrl: './employees-table.component.css'
})
export class EmployeesTableComponent {

  employeeService = inject(EmployeeService)

  @Output() employeeUpdated = new EventEmitter<void>();

  @Input({required: true}) employeesData : EmployeesResponsePage = {};

  onBlock = (id: number) => {
    this.employeeService.blockEmployee(id)
      .subscribe({
        next:() => {
          this.employeeUpdated.emit();
          console.log("employee blocked")
        }, error: (err) => {
          console.log("error in blocking the employee", err)
        }
      })
  }

  onActivate = (id: number) => {
    this.employeeService.activateEmployee(id)
      .subscribe({
        next:() => {
          this.employeeUpdated.emit();
          console.log("employee activated")
        }, error: (err) => {
          console.log("error in activating the employee", err)
        }
      })
  }

}
