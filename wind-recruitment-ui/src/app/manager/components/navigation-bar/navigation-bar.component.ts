import {Component, inject} from '@angular/core';
import {Button} from "primeng/button";
import {AvatarModule} from "primeng/avatar";
import {MenuModule} from "primeng/menu";
import {MenuItem, MenuItemCommandEvent} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'app-navigation-bar',
  standalone: true,
  imports: [
    Button,
    AvatarModule,
    MenuModule
  ],
  templateUrl: './navigation-bar.component.html',
  styleUrl: './navigation-bar.component.css'
})
export class NavigationBarComponent {

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
