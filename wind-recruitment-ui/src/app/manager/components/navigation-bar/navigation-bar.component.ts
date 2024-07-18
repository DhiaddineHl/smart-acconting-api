import { Component } from '@angular/core';
import {Button} from "primeng/button";
import {AvatarModule} from "primeng/avatar";

@Component({
  selector: 'app-navigation-bar',
  standalone: true,
  imports: [
    Button,
    AvatarModule
  ],
  templateUrl: './navigation-bar.component.html',
  styleUrl: './navigation-bar.component.css'
})
export class NavigationBarComponent {

}
