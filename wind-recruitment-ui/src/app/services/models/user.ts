/* tslint:disable */
/* eslint-disable */
import { GrantedAuthority } from '../models/granted-authority';
export interface User {
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
  username?: string;
}
