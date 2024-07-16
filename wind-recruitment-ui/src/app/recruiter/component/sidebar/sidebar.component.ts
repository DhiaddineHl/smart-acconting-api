import { Component } from '@angular/core';
import {AvatarComponent} from "../avatar/avatar.component";

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    AvatarComponent
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

}
