/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { CandidacyResponse } from '../models/candidacy-response';
import { createTopic } from '../fn/hr-controller/create-topic';
import { CreateTopic$Params } from '../fn/hr-controller/create-topic';
import { deleteTopic } from '../fn/hr-controller/delete-topic';
import { DeleteTopic$Params } from '../fn/hr-controller/delete-topic';
import { getAllCandidacies } from '../fn/hr-controller/get-all-candidacies';
import { GetAllCandidacies$Params } from '../fn/hr-controller/get-all-candidacies';
import { getAllTopics } from '../fn/hr-controller/get-all-topics';
import { GetAllTopics$Params } from '../fn/hr-controller/get-all-topics';
import { getAllValidations } from '../fn/hr-controller/get-all-validations';
import { GetAllValidations$Params } from '../fn/hr-controller/get-all-validations';
import { getCandidaciesByCandidate } from '../fn/hr-controller/get-candidacies-by-candidate';
import { GetCandidaciesByCandidate$Params } from '../fn/hr-controller/get-candidacies-by-candidate';
import { getCandidacyById } from '../fn/hr-controller/get-candidacy-by-id';
import { GetCandidacyById$Params } from '../fn/hr-controller/get-candidacy-by-id';
import { getTopicById } from '../fn/hr-controller/get-topic-by-id';
import { GetTopicById$Params } from '../fn/hr-controller/get-topic-by-id';
import { getTopicByRecruiter } from '../fn/hr-controller/get-topic-by-recruiter';
import { GetTopicByRecruiter$Params } from '../fn/hr-controller/get-topic-by-recruiter';
import { getValidationById } from '../fn/hr-controller/get-validation-by-id';
import { GetValidationById$Params } from '../fn/hr-controller/get-validation-by-id';
import { PageResponseCandidacyResponse } from '../models/page-response-candidacy-response';
import { PageResponseTopicResponse } from '../models/page-response-topic-response';
import { TopicResponse } from '../models/topic-response';
import { updateTopic } from '../fn/hr-controller/update-topic';
import { UpdateTopic$Params } from '../fn/hr-controller/update-topic';
import { validateCandidacy } from '../fn/hr-controller/validate-candidacy';
import { ValidateCandidacy$Params } from '../fn/hr-controller/validate-candidacy';

@Injectable({ providedIn: 'root' })
export class HrControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getTopicById()` */
  static readonly GetTopicByIdPath = '/api/v1/hr/topic/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getTopicById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTopicById$Response(params: GetTopicById$Params, context?: HttpContext): Observable<StrictHttpResponse<TopicResponse>> {
    return getTopicById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getTopicById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTopicById(params: GetTopicById$Params, context?: HttpContext): Observable<TopicResponse> {
    return this.getTopicById$Response(params, context).pipe(
      map((r: StrictHttpResponse<TopicResponse>): TopicResponse => r.body)
    );
  }

  /** Path part for operation `updateTopic()` */
  static readonly UpdateTopicPath = '/api/v1/hr/topic/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateTopic()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTopic$Response(params: UpdateTopic$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return updateTopic(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateTopic$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateTopic(params: UpdateTopic$Params, context?: HttpContext): Observable<void> {
    return this.updateTopic$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `deleteTopic()` */
  static readonly DeleteTopicPath = '/api/v1/hr/topic/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteTopic()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTopic$Response(params: DeleteTopic$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteTopic(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteTopic$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTopic(params: DeleteTopic$Params, context?: HttpContext): Observable<void> {
    return this.deleteTopic$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `validateCandidacy()` */
  static readonly ValidateCandidacyPath = '/api/v1/hr/validate-candidacy/{candidacyId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `validateCandidacy()` instead.
   *
   * This method doesn't expect any request body.
   */
  validateCandidacy$Response(params: ValidateCandidacy$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return validateCandidacy(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `validateCandidacy$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  validateCandidacy(params: ValidateCandidacy$Params, context?: HttpContext): Observable<void> {
    return this.validateCandidacy$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `createTopic()` */
  static readonly CreateTopicPath = '/api/v1/hr/topic';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createTopic()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTopic$Response(params: CreateTopic$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return createTopic(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createTopic$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTopic(params: CreateTopic$Params, context?: HttpContext): Observable<void> {
    return this.createTopic$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getAllValidations()` */
  static readonly GetAllValidationsPath = '/api/v1/hr/validations';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllValidations()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllValidations$Response(params?: GetAllValidations$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return getAllValidations(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllValidations$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllValidations(params?: GetAllValidations$Params, context?: HttpContext): Observable<void> {
    return this.getAllValidations$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getValidationById()` */
  static readonly GetValidationByIdPath = '/api/v1/hr/validations/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getValidationById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getValidationById$Response(params: GetValidationById$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return getValidationById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getValidationById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getValidationById(params: GetValidationById$Params, context?: HttpContext): Observable<void> {
    return this.getValidationById$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getAllTopics()` */
  static readonly GetAllTopicsPath = '/api/v1/hr/topics';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllTopics()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllTopics$Response(params?: GetAllTopics$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseTopicResponse>> {
    return getAllTopics(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllTopics$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllTopics(params?: GetAllTopics$Params, context?: HttpContext): Observable<PageResponseTopicResponse> {
    return this.getAllTopics$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseTopicResponse>): PageResponseTopicResponse => r.body)
    );
  }

  /** Path part for operation `getTopicByRecruiter()` */
  static readonly GetTopicByRecruiterPath = '/api/v1/hr/topicsByRecruiter';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getTopicByRecruiter()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTopicByRecruiter$Response(params: GetTopicByRecruiter$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseTopicResponse>> {
    return getTopicByRecruiter(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getTopicByRecruiter$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getTopicByRecruiter(params: GetTopicByRecruiter$Params, context?: HttpContext): Observable<PageResponseTopicResponse> {
    return this.getTopicByRecruiter$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseTopicResponse>): PageResponseTopicResponse => r.body)
    );
  }

  /** Path part for operation `getAllCandidacies()` */
  static readonly GetAllCandidaciesPath = '/api/v1/hr/candidacies';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllCandidacies()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllCandidacies$Response(params?: GetAllCandidacies$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseCandidacyResponse>> {
    return getAllCandidacies(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllCandidacies$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllCandidacies(params?: GetAllCandidacies$Params, context?: HttpContext): Observable<PageResponseCandidacyResponse> {
    return this.getAllCandidacies$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseCandidacyResponse>): PageResponseCandidacyResponse => r.body)
    );
  }

  /** Path part for operation `getCandidacyById()` */
  static readonly GetCandidacyByIdPath = '/api/v1/hr/candidacies/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getCandidacyById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCandidacyById$Response(params: GetCandidacyById$Params, context?: HttpContext): Observable<StrictHttpResponse<CandidacyResponse>> {
    return getCandidacyById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getCandidacyById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCandidacyById(params: GetCandidacyById$Params, context?: HttpContext): Observable<CandidacyResponse> {
    return this.getCandidacyById$Response(params, context).pipe(
      map((r: StrictHttpResponse<CandidacyResponse>): CandidacyResponse => r.body)
    );
  }

  /** Path part for operation `getCandidaciesByCandidate()` */
  static readonly GetCandidaciesByCandidatePath = '/api/v1/hr/candidacies/candidate/{candidateId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getCandidaciesByCandidate()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCandidaciesByCandidate$Response(params: GetCandidaciesByCandidate$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseCandidacyResponse>> {
    return getCandidaciesByCandidate(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getCandidaciesByCandidate$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCandidaciesByCandidate(params: GetCandidaciesByCandidate$Params, context?: HttpContext): Observable<PageResponseCandidacyResponse> {
    return this.getCandidaciesByCandidate$Response(params, context).pipe(
      map((r: StrictHttpResponse<PageResponseCandidacyResponse>): PageResponseCandidacyResponse => r.body)
    );
  }

}
