import { Component } from '@angular/core';
import {EmployeesTableComponent} from "../../components/employees-table/employees-table.component";
import {NavigationBarComponent} from "../../components/navigation-bar/navigation-bar.component";
import {RegisteringModalComponent} from "../../components/registering-modal/registering-modal.component";
import {SearchbarComponent} from "../../../recruiter/component/searchbar/searchbar.component";

@Component({
  selector: 'app-employees-page',
  standalone: true,
    imports: [
        EmployeesTableComponent,
        NavigationBarComponent,
        RegisteringModalComponent,
        SearchbarComponent
    ],
  templateUrl: './employees-page.component.html',
  styleUrl: './employees-page.component.css'
})
export class EmployeesPageComponent {

}
