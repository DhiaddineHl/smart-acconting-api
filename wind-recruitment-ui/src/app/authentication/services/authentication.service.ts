import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StrictHttpResponse} from "../../services/strict-http-response";

export interface AuthenticationResponse {
  access_token: string
  refresh_token: string
}

export interface AuthenticationRequest{
  email: string
  password: string
}

export interface RecruiterRegisterRequest{
  first_name: string
  last_name: string
  email: string
  password: string
  company: string
  speciality: string
}

export interface CandidateRegisterRequest{
  first_name: string
  last_name: string
  email: string
  password: string
  university: string
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  login = (request: AuthenticationRequest) : Observable<AuthenticationResponse> => {
    return this.http.post<AuthenticationResponse>("http://localhost:8080/api/v1/auth/login", request)
  }

  registerCandidate = (request: CandidateRegisterRequest) : Observable<StrictHttpResponse<void>> => {
    return this.http.post<StrictHttpResponse<void>>("http://localhost:8080/api/v1/auth/register-candidate", request)
  }

  registerHRRecruiter = (request: RecruiterRegisterRequest) : Observable<StrictHttpResponse<void>> => {
    return this.http.post<StrictHttpResponse<void>>("http://localhost:8080/api/v1/auth/register-hr-recruiter", request)
  }

  registerTechRecruiter = (request: RecruiterRegisterRequest) : Observable<StrictHttpResponse<void>> => {
    return this.http.post<StrictHttpResponse<void>>("http://localhost:8080/api/v1/auth/register-tech-recruiter", request)
  }

  activateAccount = (token: string) : Observable<StrictHttpResponse<void>> => {
    return this.http.post<StrictHttpResponse<void>>("http://localhost:8080/api/v1/auth/activate-account", {}, {
      params: {
        token: token
      }
    })
  }

  // refreshToken = () : Observable<void> => {
  //   return this.http.post("http://localhost:8080/api/v1/auth/refresh-token")
  // } //todo

}
