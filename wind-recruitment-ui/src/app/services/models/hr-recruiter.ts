/* tslint:disable */
/* eslint-disable */
import { GrantedAuthority } from '../models/granted-authority';
import { Token } from '../models/token';
import { Topic } from '../models/topic';
import { Validation } from '../models/validation';
export interface HrRecruiter {
  accountActivated?: boolean;
  accountNonExpired?: boolean;
  accountNonLocked?: boolean;
  authorities?: Array<GrantedAuthority>;
  company?: string;
  credentialsNonExpired?: boolean;
  email?: string;
  enabled?: boolean;
  first_name?: string;
  id?: number;
  last_name?: string;
  password?: string;
  phone_number?: string;
  proposedTopics?: Array<Topic>;
  role?: 'CANDIDATE' | 'MANAGER' | 'RECRUITER';
  speciality?: string;
  tokens?: Array<Token>;
  username?: string;
  validations?: Array<Validation>;
}
