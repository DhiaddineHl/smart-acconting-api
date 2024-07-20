import {Component, inject} from '@angular/core';
import {AvatarModule} from "primeng/avatar";
import {Button} from "primeng/button";
import {NavigationExtras, Router, RouterLink} from "@angular/router";

@Component({
  selector: 'app-candidate-navigation-bar',
  standalone: true,
  imports: [
    AvatarModule,
    Button,
    RouterLink
  ],
  templateUrl: './candidate-navigation-bar.component.html',
  styleUrl: './candidate-navigation-bar.component.css'
})
export class CandidateNavigationBarComponent {

  router = inject(Router)


}
