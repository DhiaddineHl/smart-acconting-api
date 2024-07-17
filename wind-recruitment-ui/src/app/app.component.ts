import { Component } from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import {Button} from "primeng/button";
import {SidebarComponent} from "./recruiter/component/sidebar/sidebar.component";
import {HeaderComponent} from "./recruiter/component/header/header.component";
import {TopicTableComponent} from "./recruiter/component/topic-table/topic-table.component";
import {TopicsComponent} from "./recruiter/pages/topics/topics.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ReactiveFormsModule,
    Button, SidebarComponent, HeaderComponent, TopicTableComponent, TopicsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'wind-recruitment-ui';
}
