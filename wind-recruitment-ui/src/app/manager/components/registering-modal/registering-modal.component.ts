import {Component, EventEmitter, importProvidersFrom, inject, Output} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {InputTextareaModule} from "primeng/inputtextarea";
import {NgForOf} from "@angular/common";
import {FormsModule, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {AuthenticationService, RecruiterRegisterRequest} from "../../../authentication/services/authentication.service";
import {RadioButtonModule} from "primeng/radiobutton";
import {MessageService} from "primeng/api";
import {ToastModule} from "primeng/toast";

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
    FormsModule,
    ToastModule
  ],
  providers: [MessageService],
  templateUrl: './registering-modal.component.html',
  styleUrl: './registering-modal.component.css'
})
export class RegisteringModalComponent {

  @Output() employeeRegistered = new EventEmitter<void>();

  formBuilder = inject(NonNullableFormBuilder);
  authenticationService = inject(AuthenticationService);
  messageService = inject(MessageService);

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


  isVisible: boolean = false;
  showModal() {
    this.isVisible = true
  }
  hideModal(){
    this.isVisible = false;
  }

  showSuccessToast(){
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Message Content' });
  }

  onSubmit() {
    this.authenticationService.registerRecruiter(
      this.recruiterRegistration.getRawValue()
    ).subscribe({
      next: (response) => {
        console.log("recruiter registered successfully")
        this.hideModal()
        this.showSuccessToast()
        this.employeeRegistered.emit();
      },error: (err) => {
        console.log(err)
    }
    })
  }

}
