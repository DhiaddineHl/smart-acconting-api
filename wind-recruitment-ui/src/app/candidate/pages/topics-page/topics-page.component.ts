import { Component } from '@angular/core';
import {HeaderComponent} from "../../../recruiter/component/header/header.component";
import {SidebarComponent} from "../../../recruiter/component/sidebar/sidebar.component";
import {TopicTableComponent} from "../../../recruiter/component/topic-table/topic-table.component";
import {
    CandidaciesTableByCandidateComponent
} from "../../components/candidacies-table-by-candidate/candidacies-table-by-candidate.component";
import {CandidacyModalComponent} from "../../components/candidacy-modal/candidacy-modal.component";
import {
    CandidateNavigationBarComponent
} from "../../components/candidate-navigation-bar/candidate-navigation-bar.component";
import {SearchbarComponent} from "../../../recruiter/component/searchbar/searchbar.component";
import {CandidateTopicsTableComponent} from "../../components/candidate-topics-table/candidate-topics-table.component";

@Component({
  selector: 'app-topics-page',
  standalone: true,
  imports: [
    HeaderComponent,
    SidebarComponent,
    TopicTableComponent,
    CandidaciesTableByCandidateComponent,
    CandidacyModalComponent,
    CandidateNavigationBarComponent,
    SearchbarComponent,
    CandidateTopicsTableComponent
  ],
  templateUrl: './topics-page.component.html',
  styleUrl: './topics-page.component.css'
})
export class TopicsPageComponent {

}
