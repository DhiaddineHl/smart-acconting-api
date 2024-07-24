import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, NonNullableFormBuilder, ReactiveFormsModule} from "@angular/forms";
import {AuthRequest} from "../../../services/models/auth-request";
import {AuthenticationRequest, AuthenticationService} from "../../services/authentication.service";
import {TokenService} from "../../services/token/token.service";


@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
    ReactiveFormsModule,
  ],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {

  router= inject(Router);
  authenticationService= inject(AuthenticationService)
  formBuilder = inject(NonNullableFormBuilder);
  tokenService = inject(TokenService);

  loginRequest = this.formBuilder.group<AuthenticationRequest>({
    email: (''),
    password: ('')
  })

  onLogin = () => {
    this.authenticationService.login(
      this.loginRequest.getRawValue()
    ).subscribe({
      next: (response) => {
        this.tokenService.setToken("access_token", response.access_token);
        this.tokenService.setToken("refresh_token", response.refresh_token);
        console.log(response);
        this.router.navigate(['/'])
      },error: (err) => {
        console.log(err)
      }
    })
  }



}
