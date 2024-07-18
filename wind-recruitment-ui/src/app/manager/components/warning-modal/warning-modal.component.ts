import {Component, Input} from '@angular/core';
import {Button} from "primeng/button";
import {DialogModule} from "primeng/dialog";

@Component({
  selector: 'app-warning-modal',
  standalone: true,
    imports: [
        Button,
        DialogModule
    ],
  templateUrl: './warning-modal.component.html',
  styleUrl: './warning-modal.component.css'
})
export class WarningModalComponent {

  isVisible: boolean = false;

  @Input({required: true}) severity :
    "success" | "info" | "warning" | "danger" | "help" | "primary" | "secondary" | "contrast" | null | undefined;
  @Input({required: true}) message: string = "";
  @Input({required: true}) label: string = "";

}
