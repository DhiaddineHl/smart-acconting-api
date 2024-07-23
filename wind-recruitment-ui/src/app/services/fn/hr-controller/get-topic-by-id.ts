/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { TopicResponse } from '../../models/topic-response';

export interface GetTopicById$Params {
  id: number;
}

export function getTopicById(http: HttpClient, rootUrl: string, params: GetTopicById$Params, context?: HttpContext): Observable<StrictHttpResponse<TopicResponse>> {
  const rb = new RequestBuilder(rootUrl, getTopicById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<TopicResponse>;
    })
  );
}

getTopicById.PATH = '/api/v1/hr/topic/{id}';
