import {Component, inject} from '@angular/core';
import {BadgeModule} from "primeng/badge";
import {Button} from "primeng/button";
import {PrimeTemplate} from "primeng/api";
import {TableModule} from "primeng/table";
import {TopicResponsePage, TopicServiceService} from "../../../recruiter/services/topic/topic-service.service";

@Component({
  selector: 'app-candidate-topics-table',
  standalone: true,
    imports: [
        BadgeModule,
        Button,
        PrimeTemplate,
        TableModule
    ],
  templateUrl: './candidate-topics-table.component.html',
  styleUrl: './candidate-topics-table.component.css'
})
export class CandidateTopicsTableComponent {

  topicsService = inject(TopicServiceService);

  topicsResponse : TopicResponsePage = {};
  size: number = 10;
  number: number = 0;

  getAllTopics = () => {
    this.topicsService.getAllTopics(
      this.size, this.number
    ).subscribe({
      next: (response) => {
        this.topicsResponse = response
        console.log(response.content)
      }, error: (err) => {
        console.log(err)
      }
    })
  }

  ngOnInit(): void {
    this.getAllTopics()
  }


}
