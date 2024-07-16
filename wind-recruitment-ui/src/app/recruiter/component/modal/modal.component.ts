import { Component } from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";

@Component({
  selector: 'app-modal',
  standalone: true,
  imports: [
    Button,
    DialogModule
  ],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent {

  isVisible: boolean = false;

  showModal() {
    this.isVisible = true
  }
}
