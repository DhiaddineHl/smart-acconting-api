/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseTopicResponse } from '../../models/page-response-topic-response';

export interface GetAllTopics$Params {
  size?: number;
  number?: number;
}

export function getAllTopics(http: HttpClient, rootUrl: string, params?: GetAllTopics$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseTopicResponse>> {
  const rb = new RequestBuilder(rootUrl, getAllTopics.PATH, 'get');
  if (params) {
    rb.query('size', params.size, {});
    rb.query('number', params.number, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PageResponseTopicResponse>;
    })
  );
}

getAllTopics.PATH = '/api/v1/hr/topics';