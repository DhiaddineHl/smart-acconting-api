import {Component, inject, OnInit} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {PaginatorModule} from "primeng/paginator";
import {ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from '@angular/common';
import {ToastModule} from "primeng/toast";
import {FileUploadModule} from "primeng/fileupload";

import {CandidacyRequest} from "../../../services/models/candidacy-request";
import {CandidaciesServiceService} from "../../../recruiter/services/candidacy/candidacies-service.service";
import {TopicResponse, TopicServiceService} from "../../../recruiter/services/topic/topic-service.service";


@Component({
  selector: 'app-candidacy-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule,
    InputTextModule,
    PaginatorModule,
    ReactiveFormsModule,
    NgIf,
    NgForOf,
    ToastModule,
    FileUploadModule
  ],
  templateUrl: './candidacy-modal.component.html',
  styleUrl: './candidacy-modal.component.css',
})
export class CandidacyModalComponent implements OnInit{

  isVisible: boolean = false;
  selectedFile: any;
  selectedPDF : string | undefined;
  size: number = 10;
  number: number = 0;

  candidaciesService = inject(CandidaciesServiceService)
  topicService = inject(TopicServiceService);

  topics_options : Array<TopicResponse> | undefined = [];

  topics = [
    {
      id: 1,
      name: "topic1"
    },{
      id: 2,
      name: "topic2"
    },{
      id: 3,
      name: "topic3"
    },{
      id: 4,
      name: "topic4"
    },
  ]

  candidacyReq: CandidacyRequest = {
    topic_id : 0
  }

  onSubmit() {
    console.log(this.candidacyReq)
    this.candidaciesService.postCandidacy({
      topic_id: this.candidacyReq.topic_id
    })
      .subscribe({
        next: (candidacy_id) => {
          console.log("candidacy id : ", candidacy_id)
          this.candidaciesService.uploadCandidacyFiles({
            candidacy_id,
            body : {
              file : this.selectedFile
            }
          }).subscribe({
            next :() => {
              console.log("file uploaded successfully")
            }, error: (err : ErrorEvent) => {
            console.log("error uploading files: ", err)
          }
          })
        },error:(err: ErrorEvent) => {
          console.log("error creation candidacy ", err)
        }
      })
  }

  getAllTopics(){
    this.topicService.getAllTopics(this.size, this.number)
      .subscribe({
        next:(response)=>{
          this.topics_options = response.content;
        },error:(err) => {
          console.log("error fetching the topics list", err)
        }
      })
  }

  onSelectFile(event: any) {
    this.selectedFile = event.target.files[0];
    console.log( "initial selected file", this.selectedFile);
    console.log(this.selectedFile instanceof Blob)

    if (this.selectedFile) {

      const reader = new FileReader();
      reader.onload = () => {
        this.selectedPDF = reader.result as string;

      };
      reader.readAsDataURL(this.selectedFile);

    }

  }

  ngOnInit(): void {
    this.getAllTopics();
    console.log("topics options", this.topics_options)
  }
}
