import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {NgForOf} from "@angular/common";
import {FormArray, FormsModule, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {RecruiterRegisterRequest} from "../../../authentication/services/authentication.service";
import {RadioButtonModule} from "primeng/radiobutton";

@Component({
  selector: 'app-registering-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule,
    InputTextModule,
    InputTextareaModule,
    NgForOf,
    ReactiveFormsModule,
    RadioButtonModule,
    FormsModule
  ],
  templateUrl: './registering-modal.component.html',
  styleUrl: './registering-modal.component.css'
})
export class RegisteringModalComponent {

  formBuilder = inject(NonNullableFormBuilder);

  recruiterRegistration = this.formBuilder.group<RecruiterRegisterRequest>({
    first_name: (''),
    last_name: (''),
    email: (''),
    password: (''),
    phone_number: (''),
    recruiter_type: (''),
    speciality: (''),
    company: ('')
  })

  recruiter_type: string = '';

  isVisible: boolean = false;
  showModal() {
    this.isVisible = true
  }

  onSubmit() {
    console.log(this.recruiterRegistration.getRawValue())
  }

}
