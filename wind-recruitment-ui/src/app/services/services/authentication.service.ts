/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { activateAccount } from '../fn/authentication-controller/activate-account';
import { ActivateAccount$Params } from '../fn/authentication-controller/activate-account';
import { authenticate } from '../fn/authentication-controller/authenticate';
import { Authenticate$Params } from '../fn/authentication-controller/authenticate';
import { AuthResponse } from '../models/auth-response';
import { refreshToken } from '../fn/authentication-controller/refresh-token';
import { RefreshToken$Params } from '../fn/authentication-controller/refresh-token';
import { registerCandidate } from '../fn/authentication-controller/register-candidate';
import { RegisterCandidate$Params } from '../fn/authentication-controller/register-candidate';
import { registerHrRecruiter } from '../fn/authentication-controller/register-hr-recruiter';
import { RegisterHrRecruiter$Params } from '../fn/authentication-controller/register-hr-recruiter';
import { registerManager } from '../fn/authentication-controller/register-manager';
import { RegisterManager$Params } from '../fn/authentication-controller/register-manager';
import { registerTechnicalRecruiter } from '../fn/authentication-controller/register-technical-recruiter';
import { RegisterTechnicalRecruiter$Params } from '../fn/authentication-controller/register-technical-recruiter';

@Injectable({ providedIn: 'root' })
export class AuthenticationService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `registerTechnicalRecruiter()` */
  static readonly RegisterTechnicalRecruiterPath = '/api/v1/auth/register-tech-recruiter';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `registerTechnicalRecruiter()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerTechnicalRecruiter$Response(params: RegisterTechnicalRecruiter$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return registerTechnicalRecruiter(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `registerTechnicalRecruiter$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerTechnicalRecruiter(params: RegisterTechnicalRecruiter$Params, context?: HttpContext): Observable<void> {
    return this.registerTechnicalRecruiter$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `registerManager()` */
  static readonly RegisterManagerPath = '/api/v1/auth/register-manager';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `registerManager()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerManager$Response(params: RegisterManager$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return registerManager(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `registerManager$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerManager(params: RegisterManager$Params, context?: HttpContext): Observable<void> {
    return this.registerManager$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `registerHrRecruiter()` */
  static readonly RegisterHrRecruiterPath = '/api/v1/auth/register-hr-recruiter';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `registerHrRecruiter()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerHrRecruiter$Response(params: RegisterHrRecruiter$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return registerHrRecruiter(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `registerHrRecruiter$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerHrRecruiter(params: RegisterHrRecruiter$Params, context?: HttpContext): Observable<void> {
    return this.registerHrRecruiter$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `registerCandidate()` */
  static readonly RegisterCandidatePath = '/api/v1/auth/register-candidate';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `registerCandidate()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerCandidate$Response(params: RegisterCandidate$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return registerCandidate(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `registerCandidate$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  registerCandidate(params: RegisterCandidate$Params, context?: HttpContext): Observable<void> {
    return this.registerCandidate$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `refreshToken()` */
  static readonly RefreshTokenPath = '/api/v1/auth/refresh-token';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `refreshToken()` instead.
   *
   * This method doesn't expect any request body.
   */
  refreshToken$Response(params?: RefreshToken$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return refreshToken(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `refreshToken$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  refreshToken(params?: RefreshToken$Params, context?: HttpContext): Observable<void> {
    return this.refreshToken$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `authenticate()` */
  static readonly AuthenticatePath = '/api/v1/auth/login';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `authenticate()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  authenticate$Response(params: Authenticate$Params, context?: HttpContext): Observable<StrictHttpResponse<AuthResponse>> {
    return authenticate(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `authenticate$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  authenticate(params: Authenticate$Params, context?: HttpContext): Observable<AuthResponse> {
    return this.authenticate$Response(params, context).pipe(
      map((r: StrictHttpResponse<AuthResponse>): AuthResponse => r.body)
    );
  }

  /** Path part for operation `activateAccount()` */
  static readonly ActivateAccountPath = '/api/v1/auth/activate-account';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `activateAccount()` instead.
   *
   * This method doesn't expect any request body.
   */
  activateAccount$Response(params: ActivateAccount$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return activateAccount(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `activateAccount$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  activateAccount(params: ActivateAccount$Params, context?: HttpContext): Observable<void> {
    return this.activateAccount$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
