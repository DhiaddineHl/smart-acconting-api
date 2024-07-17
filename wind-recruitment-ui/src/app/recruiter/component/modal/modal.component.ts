import {Component, inject} from '@angular/core';
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

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule,
    ReactiveFormsModule,
    InputTextModule,
    NgForOf,
    InputTextareaModule
  ],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {

  formBuilder = inject(NonNullableFormBuilder);

    topicCreation = this.formBuilder.group({
      name: (''),
      description: (''),
      duration: (''),
      requirements: this.formBuilder.array([
        this.formBuilder.control('')
      ])
    })

  get requirements() {
    return this.topicCreation.get('requirements') as FormArray;
  }

  addRequirement() {
    this.requirements.push(this.formBuilder.control(''))
  }


  isVisible: boolean = false;
  showModal() {
    this.isVisible = true
  }



  onSubmit() {
    console.log(this.topicCreation.getRawValue())
  }


}
