import {Component, inject, Input, OnInit} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {InputNumberModule} from "primeng/inputnumber";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {NgForOf} from "@angular/common";
import {ToastModule} from "primeng/toast";
import {TopicResponse, TopicServiceService} from "../../services/topic/topic-service.service";


@Component({
  selector: 'app-topic-details-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule,
    FormsModule,
    InputNumberModule,
    InputTextModule,
    InputTextareaModule,
    NgForOf,
    ReactiveFormsModule,
    ToastModule,
  ],
  templateUrl: './topic-details-modal.component.html',
  styleUrl: './topic-details-modal.component.css'
})
export class TopicDetailsModalComponent implements OnInit{

  @Input({required: true}) topicId = 0;
  @Input({required: true}) isManageable = true;

  topicsService = inject(TopicServiceService);

  isVisible: boolean = false;
  showModal() {
    this.isVisible = true
  }

  topicDetails : TopicResponse = {};

  getTopicDetails = () => {
    this.topicsService.getTopicById(this.topicId)
      .subscribe({
        next: (response) => {
          console.log(response)
          this.topicDetails = response
        }, error : (err) => {
          console.log(err)
        }
      })
  }
  ngOnInit(): void {
    this.getTopicDetails()
  }

}
