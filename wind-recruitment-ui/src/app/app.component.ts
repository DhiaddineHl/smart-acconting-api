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

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule,
    Button, SidebarComponent, HeaderComponent, TopicTableComponent, TopicsComponent, CandidaciesComponent, ValidationsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wind-recruitment-ui';
}
