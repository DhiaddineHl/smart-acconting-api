/* tslint:disable */
/* eslint-disable */
import { HrRecruiter } from '../models/hr-recruiter';
export interface Topic {
  description?: string;
  duration?: number;
  id?: number;
  name?: string;
  requirements?: Array<string>;
  topicAuthor?: HrRecruiter;
}
