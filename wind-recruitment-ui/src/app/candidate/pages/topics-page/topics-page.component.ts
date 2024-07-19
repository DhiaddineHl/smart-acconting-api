import { Component } from '@angular/core';
import {HeaderComponent} from "../../../recruiter/component/header/header.component";
import {SidebarComponent} from "../../../recruiter/component/sidebar/sidebar.component";
import {TopicTableComponent} from "../../../recruiter/component/topic-table/topic-table.component";

@Component({
  selector: 'app-topics-page',
  standalone: true,
    imports: [
        HeaderComponent,
        SidebarComponent,
        TopicTableComponent
    ],
  templateUrl: './topics-page.component.html',
  styleUrl: './topics-page.component.css'
})
export class TopicsPageComponent {

}
