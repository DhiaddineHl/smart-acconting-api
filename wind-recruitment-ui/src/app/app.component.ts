import { Component } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import {Button} from "primeng/button";
import {SidebarComponent} from "./recruiter/component/sidebar/sidebar.component";
import {HeaderComponent} from "./recruiter/component/header/header.component";
import {TopicTableComponent} from "./recruiter/component/topic-table/topic-table.component";
import {TopicsComponent} from "./recruiter/pages/topics/topics.component";
import {CandidaciesComponent} from "./recruiter/pages/candidacies/candidacies.component";
import {ValidationsComponent} from "./recruiter/pages/validations/validations.component";
import {NavigationBarComponent} from "./manager/components/navigation-bar/navigation-bar.component";
import {EmployeesTableComponent} from "./manager/components/employees-table/employees-table.component";
import {SearchbarComponent} from "./recruiter/component/searchbar/searchbar.component";
import {RegisteringModalComponent} from "./manager/components/registering-modal/registering-modal.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule,
    Button, SidebarComponent, HeaderComponent, TopicTableComponent, TopicsComponent, CandidaciesComponent, ValidationsComponent, NavigationBarComponent, EmployeesTableComponent, SearchbarComponent, RegisteringModalComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wind-recruitment-ui';
}
