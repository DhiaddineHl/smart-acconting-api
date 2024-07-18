import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {NgForOf} from "@angular/common";
import {FormArray, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-registering-modal',
  standalone: true,
    imports: [
        Button,
        DialogModule,
        InputTextModule,
        InputTextareaModule,
        NgForOf,
        ReactiveFormsModule
    ],
  templateUrl: './registering-modal.component.html',
  styleUrl: './registering-modal.component.css'
})
export class RegisteringModalComponent {

  formBuilder = inject(NonNullableFormBuilder);

  recruiterRegistration = this.formBuilder.group({
    first_name: (''),
    last_name: (''),
    email: (''),
    password: (''),
    speciality: ('')
  })


  isVisible: boolean = false;
  showModal() {
    this.isVisible = true
  }

  onSubmit() {
    console.log(this.recruiterRegistration.getRawValue())
  }

}
