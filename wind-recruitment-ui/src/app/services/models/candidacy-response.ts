/* tslint:disable */
/* eslint-disable */
import { Candidate } from '../models/candidate';
import { Topic } from '../models/topic';
export interface CandidacyResponse {
  candidate?: Candidate;
  createdAt?: string;
  file?: Array<string>;
  id?: number;
  status?: string;
  topic?: Topic;
}
