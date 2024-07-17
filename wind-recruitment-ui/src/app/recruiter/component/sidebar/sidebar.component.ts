import { Component } from '@angular/core';
import {AvatarComponent} from "../avatar/avatar.component";
import {ConfirmDialogComponent} from "../confirm-dialog/confirm-dialog.component";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [
    AvatarComponent,
    ConfirmDialogComponent,
    RouterLink
  ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

}
