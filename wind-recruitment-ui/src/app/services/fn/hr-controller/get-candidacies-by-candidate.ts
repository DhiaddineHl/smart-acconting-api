/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseCandidacyResponse } from '../../models/page-response-candidacy-response';

export interface GetCandidaciesByCandidate$Params {
  candidateId: number;
}

export function getCandidaciesByCandidate(http: HttpClient, rootUrl: string, params: GetCandidaciesByCandidate$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseCandidacyResponse>> {
  const rb = new RequestBuilder(rootUrl, getCandidaciesByCandidate.PATH, 'get');
  if (params) {
    rb.path('candidateId', params.candidateId, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PageResponseCandidacyResponse>;
    })
  );
}

getCandidaciesByCandidate.PATH = '/api/v1/hr/candidacies/candidate/{candidateId}';
