import {Component, inject} from '@angular/core';
import {AvatarModule} from "primeng/avatar";
import {Button} from "primeng/button";
import {NavigationExtras, Router, RouterLink} from "@angular/router";
import {MenuModule} from "primeng/menu";
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-candidate-navigation-bar',
  standalone: true,
    imports: [
        AvatarModule,
        Button,
        RouterLink,
        MenuModule
    ],
  templateUrl: './candidate-navigation-bar.component.html',
  styleUrl: './candidate-navigation-bar.component.css'
})
export class CandidateNavigationBarComponent {

  router = inject(Router);

  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
      {
        label: 'Options',
        items: [
          {
            label: 'My account',
            icon: 'pi pi-user'
          },
          {
            label: 'Logout',
            icon: 'pi pi-sign-out',
            command : () => {
              this.logout()
            }
          }
        ]
      }
    ];
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['/login'])
  }


}
