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

  topics = ["topic1", "topic2", "topic3", "topic4", "topic5"]

  formBuilder = inject(NonNullableFormBuilder);

  candidacyApplication = this.formBuilder.group({
    topic: (''),
    files: ('')
  })

  onSubmit() {

  }

  onSelectFile(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0){
      console.log(input.files[0].name)
      this.selectedFile = input.files[0]
    }
    if (this.selectedFile) {

      const reader = new FileReader();
      reader.onload = () => {
        this.selectedFile = reader.result as string;
      };
      reader.readAsDataURL(this.selectedFile);
    }
  }
}
