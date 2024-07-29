/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';


export interface UploadCandidacyFiles$Params {
  candidacy_id: number;
      body?: {
'file': Blob;
}
}

export function uploadCandidacyFiles(http: HttpClient, rootUrl: string, params: UploadCandidacyFiles$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
  const rb = new RequestBuilder(rootUrl, uploadCandidacyFiles.PATH, 'post');
  if (params) {
    rb.path('candidacy_id', params.candidacy_id, {});
    rb.body(params.body, 'multipart/form-data');
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

uploadCandidacyFiles.PATH = '/api/v1/candidate/files/{candidacy_id}';
