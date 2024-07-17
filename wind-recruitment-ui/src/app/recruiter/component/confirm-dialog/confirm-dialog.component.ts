import { Component } from '@angular/core';
import {DialogModule} from "primeng/dialog";
import {Button} from "primeng/button";

@Component({
  selector: 'app-confirm-dialog',
  standalone: true,
  imports: [
    DialogModule,
    Button
  ],
  templateUrl: './confirm-dialog.component.html',
  styleUrl: './confirm-dialog.component.css'
})
export class ConfirmDialogComponent {

  isVisible: boolean = false;

}
