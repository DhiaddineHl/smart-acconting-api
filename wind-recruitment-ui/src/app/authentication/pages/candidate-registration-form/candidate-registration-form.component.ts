import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {Router} from "@angular/router";
import {NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {
  AuthenticationRequest,
  AuthenticationService,
  CandidateRegisterRequest
} from "../../services/authentication.service";


@Component({
  selector: 'app-candidate-registration-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
    ReactiveFormsModule,
  ],
  templateUrl: './candidate-registration-form.component.html',
  styleUrl: './candidate-registration-form.component.css'
})
export class CandidateRegistrationFormComponent {

  router= inject(Router)
  formBuilder = inject(NonNullableFormBuilder);
  authenticationService = inject(AuthenticationService);

  registration = this.formBuilder.group<CandidateRegisterRequest>({
    first_name: (''),
    last_name: (''),
    email: (''),
    password: (''),
    university: ('')
  })

  onRegister = () => {
    this.authenticationService.registerCandidate(
      this.registration.getRawValue()
    ).subscribe({
      next: (response) => {
        console.log("registration successful")
        this.router.navigate(['/activate-account'])
      },error: (err) => {
        console.log(err)
      }
    })
  }


}
