/* tslint:disable */
/* eslint-disable */
import { Candidacy } from '../models/candidacy';
import { HrRecruiter } from '../models/hr-recruiter';
import { TechnicalRecruiter } from '../models/technical-recruiter';
export interface Validation {
  candidacy?: Candidacy;
  createdAt?: string;
  hrRecruiter?: HrRecruiter;
  id?: number;
  status?: 'PENDING' | 'HR_VALIDATED' | 'TECHNICAL_VALIDATED' | 'ACCEPTED';
  technicalRecruiter?: TechnicalRecruiter;
}
