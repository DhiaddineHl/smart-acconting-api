import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {PaginatorModule} from "primeng/paginator";
import {NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from '@angular/common';
import {ToastModule} from "primeng/toast";
import {FileUploadEvent, FileUploadModule} from "primeng/fileupload";

import { MessageService } from 'primeng/api';

import {CandidateControllerService} from "../../../services/services/candidate-controller.service";
import {CandidacyRequest} from "../../../services/models/candidacy-request";
import {TokenService} from "../../../authentication/services/token/token.service";

interface UploadEvent {
  originalEvent: Event;
  files: File[];
}
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
export class CandidacyModalComponent {

  isVisible: boolean = false;
  selectedFile: any;
  selectedPDF : string | undefined;
  candidacyService = inject(CandidateControllerService)
  tokenService = inject(TokenService)

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

  formBuilder = inject(NonNullableFormBuilder);

  // candidacyApplication = this.formBuilder.group<CandidacyRequest>({
  //   topic_id: (0)
  // })

  candidacyReq: CandidacyRequest = {
    topic_id : 0
  }

  onSubmit() {
    console.log(this.candidacyReq)
    this.candidacyService.postCandidacy({
      Authorization : "Bearer " + this.tokenService.getToken("access_token"),
      body: this.candidacyReq
    })
      .subscribe({
        next: (candidacy_id) => {
          console.log("candidacy id : ", candidacy_id)
          this.candidacyService.uploadCandidacyFiles({
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
}
