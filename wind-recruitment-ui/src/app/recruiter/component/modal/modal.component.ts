import {Component, EventEmitter, inject, Output} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {
  FormArray,
  NonNullableFormBuilder,
  ReactiveFormsModule
} from "@angular/forms";
import {InputTextModule} from "primeng/inputtext";
import {NgForOf} from "@angular/common";
import {InputTextareaModule} from "primeng/inputtextarea";
import {InputNumberModule} from "primeng/inputnumber";
import {TopicCreationRequest, TopicServiceService} from "../../services/topic/topic-service.service";
import {ToastModule} from "primeng/toast";
import {MessageService} from "primeng/api";
import {TopicTableComponent} from "../topic-table/topic-table.component";

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule,
    ReactiveFormsModule,
    InputTextModule,
    NgForOf,
    InputTextareaModule,
    InputNumberModule,
    ToastModule
  ],
  providers: [MessageService, TopicTableComponent],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {

  @Output() topicCreated =  new EventEmitter<void>();

  formBuilder = inject(NonNullableFormBuilder);
  topicService = inject(TopicServiceService);
  messageService= inject(MessageService);
  topicTable = inject(TopicTableComponent)

  isVisible: boolean = false;

    topicCreation = this.formBuilder.group({
      name: (''),
      description: (''),
      duration: (0),
      requirements: this.formBuilder.array([
        this.formBuilder.control('')
      ])
    })

  getTopicCreation() : TopicCreationRequest {
      return {
        name: this.topicCreation.get('name')?.value as string ,
        description: this.topicCreation.get('description')?.value as string ,
        duration: this.topicCreation.get('duration')?.value as number ,
        requirements: this.requirements.controls.map(c => c.value)
      }
  }

  get requirements() {
    return this.topicCreation.get('requirements') as FormArray;
  }

  addRequirement() {
    this.requirements.push(this.formBuilder.control(''))
  }

  showModal() {
    this.isVisible = true
  }

  hideModal() {
    this.isVisible = false
  }
  showSuccessToast(){
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Topic created' });
  }


  onSubmit() {
      this.topicService.createTopic(
        this.getTopicCreation()
      ).subscribe({
        next: () => {
          this.hideModal()
          this.showSuccessToast()
          this.topicCreated.emit();
          console.log("topic created")
        },error: (err) => {
          console.log(err)
        }
      })
    }


}
