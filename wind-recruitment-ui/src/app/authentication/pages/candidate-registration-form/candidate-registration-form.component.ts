import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {Router} from "@angular/router";


@Component({
  selector: 'app-candidate-registration-form',
  standalone: true,
  imports: [
    Button,
    InputTextModule,
  ],
  templateUrl: './candidate-registration-form.component.html',
  styleUrl: './candidate-registration-form.component.css'
})
export class CandidateRegistrationFormComponent {

  router= inject(Router)

}
