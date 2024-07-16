import { Component } from '@angular/core';
import {Button} from "primeng/button";
import {SearchbarComponent} from "../searchbar/searchbar.component";
import {ModalComponent} from "../modal/modal.component";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    Button,
    SearchbarComponent,
    ModalComponent
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

}
