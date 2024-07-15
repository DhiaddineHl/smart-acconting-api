import { Component } from '@angular/core';
import {SidebarComponent} from "../../component/sidebar/sidebar.component";
import {HeaderComponent} from "../../component/header/header.component";
import {TopicTableComponent} from "../../component/topic-table/topic-table.component";

@Component({
  selector: 'app-topics',
  standalone: true,
  imports: [
    SidebarComponent,
    HeaderComponent,
    TopicTableComponent
  ],
  templateUrl: './topics.component.html',
  styleUrl: './topics.component.css'
})
export class TopicsComponent {

}
