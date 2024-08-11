import {Component, ViewChild} from '@angular/core';
import {CandidaciesTableComponent} from "../../../recruiter/component/candidacies-table/candidacies-table.component";
import {HeaderComponent} from "../../../recruiter/component/header/header.component";
import {SidebarComponent} from "../../../recruiter/component/sidebar/sidebar.component";
import {
  CandidaciesTableByCandidateComponent
} from "../../components/candidacies-table-by-candidate/candidacies-table-by-candidate.component";
import {EmployeesTableComponent} from "../../../manager/components/employees-table/employees-table.component";
import {NavigationBarComponent} from "../../../manager/components/navigation-bar/navigation-bar.component";
import {RegisteringModalComponent} from "../../../manager/components/registering-modal/registering-modal.component";
import {SearchbarComponent} from "../../../recruiter/component/searchbar/searchbar.component";
import {
  CandidateNavigationBarComponent
} from "../../components/candidate-navigation-bar/candidate-navigation-bar.component";
import {CandidacyModalComponent} from "../../components/candidacy-modal/candidacy-modal.component";

@Component({
  selector: 'app-candidacies-page',
  standalone: true,
  imports: [
    CandidaciesTableComponent,
    HeaderComponent,
    SidebarComponent,
    CandidaciesTableByCandidateComponent,
    EmployeesTableComponent,
    NavigationBarComponent,
    RegisteringModalComponent,
    SearchbarComponent,
    CandidateNavigationBarComponent,
    CandidacyModalComponent
  ],
  templateUrl: './candidacies-page.component.html',
  styleUrl: './candidacies-page.component.css'
})
export class CandidaciesPageComponent {

  @ViewChild(CandidaciesTableByCandidateComponent) candidaciesTable! : CandidaciesTableByCandidateComponent;

  onNewCandidacySubmitted():void {
    this.candidaciesTable.getMyCandidacies();
  }

}
