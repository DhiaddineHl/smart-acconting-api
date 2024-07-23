/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseCandidacyResponse } from '../../models/page-response-candidacy-response';

export interface GetAllCandidacies$Params {
  size?: number;
  number?: number;
}

export function getAllCandidacies(http: HttpClient, rootUrl: string, params?: GetAllCandidacies$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseCandidacyResponse>> {
  const rb = new RequestBuilder(rootUrl, getAllCandidacies.PATH, 'get');
  if (params) {
    rb.query('size', params.size, {});
    rb.query('number', params.number, {});
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

getAllCandidacies.PATH = '/api/v1/hr/candidacies';
