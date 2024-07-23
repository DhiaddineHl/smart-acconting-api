import {Component, inject, Inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {InputOtpModule} from "primeng/inputotp";
import {Router} from "@angular/router";

@Component({
  selector: 'app-account-activation-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
    InputOtpModule
  ],
  templateUrl: './account-activation-form.component.html',
  styleUrl: './account-activation-form.component.css'
})
export class AccountActivationFormComponent {

  router= inject(Router)

}
