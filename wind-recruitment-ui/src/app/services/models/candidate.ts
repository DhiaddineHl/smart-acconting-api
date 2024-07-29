/* tslint:disable */
/* eslint-disable */
import { GrantedAuthority } from '../models/granted-authority';
import { Token } from '../models/token';
export interface Candidate {
  accountActivated?: boolean;
  accountNonExpired?: boolean;
  accountNonLocked?: boolean;
  authorities?: Array<GrantedAuthority>;
  credentialsNonExpired?: boolean;
  email?: string;
  enabled?: boolean;
  first_name?: string;
  id?: number;
  last_name?: string;
  password?: string;
  phone_number?: string;
  role?: 'CANDIDATE' | 'MANAGER' | 'RECRUITER';
  tokens?: Array<Token>;
  university?: string;
  username?: string;
}
