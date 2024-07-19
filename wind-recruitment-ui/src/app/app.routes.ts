import { Routes } from '@angular/router';
import {TopicsComponent} from "./recruiter/pages/topics/topics.component";
import {CandidaciesComponent} from "./recruiter/pages/candidacies/candidacies.component";
import {ValidationsComponent} from "./recruiter/pages/validations/validations.component";
import {EmployeesPageComponent} from "./manager/pages/employees-page/employees-page.component";
import {CandidaciesPageComponent} from "./candidate/pages/candidacies-page/candidacies-page.component";
import {TopicsPageComponent} from "./candidate/pages/topics-page/topics-page.component";

export const routes: Routes = [
  {path: '', component: TopicsComponent},
  {path: 'candidacies', component: CandidaciesComponent},
  {path: 'validations', component: ValidationsComponent},
  {path: 'manager', component: EmployeesPageComponent},
  {path: 'candidate/candidacies', component: CandidaciesPageComponent},
  {path: 'candidate/topics', component: TopicsPageComponent}
];
