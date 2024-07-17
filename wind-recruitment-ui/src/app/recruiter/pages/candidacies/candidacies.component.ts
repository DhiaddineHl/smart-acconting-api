import { Component } from '@angular/core';
import {HeaderComponent} from "../../component/header/header.component";
import {SidebarComponent} from "../../component/sidebar/sidebar.component";
import {TopicTableComponent} from "../../component/topic-table/topic-table.component";
import {CandidaciesTableComponent} from "../../component/candidacies-table/candidacies-table.component";

@Component({
  selector: 'app-candidacies',
  standalone: true,
  imports: [
    HeaderComponent,
    SidebarComponent,
    TopicTableComponent,
    CandidaciesTableComponent
  ],
  templateUrl: './candidacies.component.html',
  styleUrl: './candidacies.component.css'
})
export class CandidaciesComponent {

}
