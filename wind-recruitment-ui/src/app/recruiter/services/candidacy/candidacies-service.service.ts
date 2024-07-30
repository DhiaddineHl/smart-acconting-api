import { Injectable } from '@angular/core';
import {TopicResponse} from "../topic/topic-service.service";
import {Observable} from "rxjs";
import {StrictHttpResponse} from "../../../services/strict-http-response";
import {HttpClient, HttpContext} from "@angular/common/http";
import {RequestBuilder} from "../../../services/request-builder";
import {UploadCandidacyFiles$Params} from "../../../services/fn/candidate-controller/upload-candidacy-files";
import {map} from "rxjs/operators";
import {ApiConfiguration} from "../../../services/api-configuration";
import {uploadCandidacyFiles} from "./helpers/upload-candidacy-files-helper";


export interface CandidaciesResponsePage{
  content?: Array<CandidacyResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
 interface CandidacyResponse {

}

 interface CandidacyRequest {
  topic_id?: number
}

 interface FileUploadRequest {
  candidacy_id : number,
  body : {
    'file': Blob
  }
}

@Injectable({
  providedIn: 'root'
})
export class CandidaciesServiceService {

  constructor(
    private http : HttpClient,
    private config: ApiConfiguration
  ) { }

  postCandidacy = (request: CandidacyRequest) : Observable<number> => {
    return this.http.post<number>("http://localhost:8080/api/v1/candidate/candidacy",
    request
    )
  }

  static readonly UploadCandidacyFilesPath = '/api/v1/candidate/files/{candidacy_id}';

  uploadCandidacyFiles$Response(params: UploadCandidacyFiles$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return uploadCandidacyFiles(this.http, this.config.rootUrl, params, context);
  }

  uploadCandidacyFiles(params: UploadCandidacyFiles$Params, context?: HttpContext): Observable<void> {
    return this.uploadCandidacyFiles$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
