/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { CandidacyRequest } from '../../models/candidacy-request';

export interface PostCandidacy$Params {
  Authorization: string;
      body: CandidacyRequest
}

export function postCandidacy(http: HttpClient, rootUrl: string, params: PostCandidacy$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
  const rb = new RequestBuilder(rootUrl, postCandidacy.PATH, 'post');
  if (params) {
    rb.header('Authorization', params.Authorization, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return (r as HttpResponse<any>).clone({ body: parseFloat(String((r as HttpResponse<any>).body)) }) as StrictHttpResponse<number>;
    })
  );
}

postCandidacy.PATH = '/api/v1/candidate/candidacy';
