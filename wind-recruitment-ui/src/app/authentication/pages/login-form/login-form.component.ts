import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
  ],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {

  router= inject(Router)

}
