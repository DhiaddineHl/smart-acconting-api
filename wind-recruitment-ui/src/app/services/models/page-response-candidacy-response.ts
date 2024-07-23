/* tslint:disable */
/* eslint-disable */
import { CandidacyResponse } from '../models/candidacy-response';
export interface PageResponseCandidacyResponse {
  content?: Array<CandidacyResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
