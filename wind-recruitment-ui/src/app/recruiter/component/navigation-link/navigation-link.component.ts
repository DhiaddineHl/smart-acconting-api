import {Component, Input} from '@angular/core';
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-navigation-link',
  standalone: true,
    imports: [
        RouterLink
    ],
  templateUrl: './navigation-link.component.html',
  styleUrl: './navigation-link.component.css'
})
export class NavigationLinkComponent {

  @Input({required : true}) label: string = '';

  // isActive: boolean = false;
  //
  //  activateLink(){
  //   this.isActive = true
  // }

}
