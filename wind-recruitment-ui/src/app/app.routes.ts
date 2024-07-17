import { Routes } from '@angular/router';
import {TopicsComponent} from "./recruiter/pages/topics/topics.component";
import {CandidaciesComponent} from "./recruiter/pages/candidacies/candidacies.component";
import {ValidationsComponent} from "./recruiter/pages/validations/validations.component";

export const routes: Routes = [
  {path: '', component: TopicsComponent},
  {path: 'candidacies', component: CandidaciesComponent},
  {path: 'validations', component: ValidationsComponent}
];
