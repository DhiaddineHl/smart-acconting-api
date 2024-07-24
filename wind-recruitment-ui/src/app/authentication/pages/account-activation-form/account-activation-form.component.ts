import {Component, inject, Inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {InputOtpModule} from "primeng/inputotp";
import {Router} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {AuthenticationService} from "../../services/authentication.service";
import {routes} from "../../../app.routes";

@Component({
  selector: 'app-account-activation-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
    InputOtpModule,
    FormsModule
  ],
  templateUrl: './account-activation-form.component.html',
  styleUrl: './account-activation-form.component.css'
})
export class AccountActivationFormComponent {

  router= inject(Router)
  authenticationService = inject(AuthenticationService)

  activationCode: string = '';

  onActivate(){
    this.authenticationService.activateAccount(
      this.activationCode
    ).subscribe({
      next: () => {
        console.log("account successfully activated")
        this.router.navigate(['/login'])
      },error:(err) => {
        console.log(err)
      }
    })
  }

}
