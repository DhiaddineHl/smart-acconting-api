import { Routes } from '@angular/router';
import {TopicsComponent} from "./recruiter/pages/topics/topics.component";
import {CandidaciesComponent} from "./recruiter/pages/candidacies/candidacies.component";
import {ValidationsComponent} from "./recruiter/pages/validations/validations.component";
import {EmployeesPageComponent} from "./manager/pages/employees-page/employees-page.component";
import {CandidaciesPageComponent} from "./candidate/pages/candidacies-page/candidacies-page.component";
import {TopicsPageComponent} from "./candidate/pages/topics-page/topics-page.component";
import {LoginFormComponent} from "./authentication/pages/login-form/login-form.component";
import {
  AccountActivationFormComponent
} from "./authentication/pages/account-activation-form/account-activation-form.component";
import {
  CandidateRegistrationFormComponent
} from "./authentication/pages/candidate-registration-form/candidate-registration-form.component";

export const routes: Routes = [
  {path: 'recruiter/topics', component: TopicsComponent},
  {path: 'recruiter/candidacies', component: CandidaciesComponent},
  {path: 'recruiter/validations', component: ValidationsComponent},

  {path: 'manager', component: EmployeesPageComponent},

  {path: 'candidate/candidacies', component: CandidaciesPageComponent},
  {path: 'candidate/topics', component: TopicsPageComponent},

  {path: 'login', component: LoginFormComponent},
  {path: 'activate-account', component: AccountActivationFormComponent},
  {path: 'register/candidate', component: CandidateRegistrationFormComponent},

  {path: 'candidate', redirectTo: 'candidate/candidacies'},
  {path: 'recruiter', redirectTo: 'recruiter/topics'},
];
