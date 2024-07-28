import {Component, inject, OnInit} from '@angular/core';
import {TableModule} from "primeng/table";
import {Button} from "primeng/button";
import {TopicResponse, TopicResponsePage, TopicServiceService} from "../../services/topic/topic-service.service";
import {BadgeModule} from "primeng/badge";
import {TopicDetailsModalComponent} from "../topic-details-modal/topic-details-modal.component";

@Component({
  selector: 'app-topic-table',
  standalone: true,
  imports: [
    TableModule,
    Button,
    BadgeModule,
    TopicDetailsModalComponent
  ],
  templateUrl: './topic-table.component.html',
  styleUrl: './topic-table.component.css'
})
export class TopicTableComponent implements OnInit{

  topicsService = inject(TopicServiceService);

  topicsResponse : TopicResponsePage = {};
  size: number = 10;
  number: number = 0;

  getTopicsByRecruiter = () => {
    this.topicsService.getTopicsByRecruiter(
      this.number, this.size
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
    this.getTopicsByRecruiter()
  }



}
