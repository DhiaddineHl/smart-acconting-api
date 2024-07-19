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

  topics = ["topic1", "topic2", "topic3", "topic4", "topic5"]

  formBuilder = inject(NonNullableFormBuilder);

  candidacyApplication = this.formBuilder.group({
    topic: (''),
    files: ('')
  })

  onSubmit() {

  }

  onBasicUploadAuto($event: FileUploadEvent) {

  }
}
