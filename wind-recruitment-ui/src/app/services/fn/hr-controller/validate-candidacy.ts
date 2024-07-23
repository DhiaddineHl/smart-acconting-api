/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';


export interface ValidateCandidacy$Params {
  candidacyId: number;
  Authorization: string;
}

export function validateCandidacy(http: HttpClient, rootUrl: string, params: ValidateCandidacy$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, validateCandidacy.PATH, 'post');
  if (params) {
    rb.path('candidacyId', params.candidacyId, {});
    rb.header('Authorization', params.Authorization, {});
  }

  return http.request(
    rb.build({ responseType: 'text', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return (r as HttpResponse<any>).clone({ body: undefined }) as StrictHttpResponse<void>;
    })
  );
}

validateCandidacy.PATH = '/api/v1/hr/validate-candidacy/{candidacyId}';
