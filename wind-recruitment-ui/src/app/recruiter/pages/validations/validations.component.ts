import { Component } from '@angular/core';
import {CandidaciesTableComponent} from "../../component/candidacies-table/candidacies-table.component";
import {HeaderComponent} from "../../component/header/header.component";
import {SidebarComponent} from "../../component/sidebar/sidebar.component";
import {ValidationsTableComponent} from "../../component/validations-table/validations-table.component";

@Component({
  selector: 'app-validations',
  standalone: true,
  imports: [
    CandidaciesTableComponent,
    HeaderComponent,
    SidebarComponent,
    ValidationsTableComponent
  ],
  templateUrl: './validations.component.html',
  styleUrl: './validations.component.css'
})
export class ValidationsComponent {

}
