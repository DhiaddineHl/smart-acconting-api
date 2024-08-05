import {Component, inject} from '@angular/core';
import {DialogModule} from "primeng/dialog";
import {Button} from "primeng/button";
import {Router} from "@angular/router";

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

  router = inject(Router)
  isVisible: boolean = false;

  logout() {
    localStorage.clear();
    this.router.navigate(["/login"])
  }
}
