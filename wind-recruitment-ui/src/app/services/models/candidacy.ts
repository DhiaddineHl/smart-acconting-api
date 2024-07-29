/* tslint:disable */
/* eslint-disable */
import { Candidate } from '../models/candidate';
import { Topic } from '../models/topic';
export interface Candidacy {
  candidate?: Candidate;
  createdAt?: string;
  file_url?: string;
  id?: number;
  status?: 'PENDING' | 'HR_VALIDATED' | 'TECH_VALIDATED' | 'ACCEPTED';
  topic?: Topic;
}
