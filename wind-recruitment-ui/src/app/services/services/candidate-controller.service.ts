/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { postCandidacy } from '../fn/candidate-controller/post-candidacy';
import { PostCandidacy$Params } from '../fn/candidate-controller/post-candidacy';
import { uploadCandidacyFiles } from '../fn/candidate-controller/upload-candidacy-files';
import { UploadCandidacyFiles$Params } from '../fn/candidate-controller/upload-candidacy-files';

@Injectable({ providedIn: 'root' })
export class CandidateControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `uploadCandidacyFiles()` */
  static readonly UploadCandidacyFilesPath = '/api/v1/candidate/files/{candidacy_id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `uploadCandidacyFiles()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  uploadCandidacyFiles$Response(params: UploadCandidacyFiles$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return uploadCandidacyFiles(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `uploadCandidacyFiles$Response()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  uploadCandidacyFiles(params: UploadCandidacyFiles$Params, context?: HttpContext): Observable<void> {
    return this.uploadCandidacyFiles$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `postCandidacy()` */
  static readonly PostCandidacyPath = '/api/v1/candidate/candidacy';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `postCandidacy()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postCandidacy$Response(params: PostCandidacy$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return postCandidacy(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `postCandidacy$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postCandidacy(params: PostCandidacy$Params, context?: HttpContext): Observable<number> {
    return this.postCandidacy$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

}
