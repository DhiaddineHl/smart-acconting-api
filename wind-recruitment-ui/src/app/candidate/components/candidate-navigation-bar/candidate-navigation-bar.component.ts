import { Component } from '@angular/core';
import {AvatarModule} from "primeng/avatar";
import {Button} from "primeng/button";

@Component({
  selector: 'app-candidate-navigation-bar',
  standalone: true,
    imports: [
        AvatarModule,
        Button
    ],
  templateUrl: './candidate-navigation-bar.component.html',
  styleUrl: './candidate-navigation-bar.component.css'
})
export class CandidateNavigationBarComponent {

}
