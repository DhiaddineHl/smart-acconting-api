import { Component } from '@angular/core';
import {TableModule} from "primeng/table";

@Component({
  selector: 'app-topic-table',
  standalone: true,
  imports: [
    TableModule
  ],
  templateUrl: './topic-table.component.html',
  styleUrl: './topic-table.component.css'
})
export class TopicTableComponent {
  topics = [
    {
      code: "1",
      name: "topic 1",
      technologies: "Spring & Angular",
      duration: "2"
    },
    {
      code: "2",
      name: "topic 2",
      technologies: "MERN Stack",
      duration: "4"
    },
  ]

}
