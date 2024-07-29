import { Injectable } from '@angular/core';
import {TopicResponse} from "../topic/topic-service.service";
import {Observable} from "rxjs";
import {StrictHttpResponse} from "../../../services/strict-http-response";
import {HttpClient} from "@angular/common/http";
import {RequestBuilder} from "../../../services/request-builder";

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
    private http : HttpClient
  ) { }

  postCandidacy = (request: CandidacyRequest) : Observable<number> => {
    return this.http.post<number>("http://localhost:8080/api/v1/candidate/candidacy",
    request
    )
  }

  uploadFile = (params: FileUploadRequest) : any => {

    const request  = new RequestBuilder("http://localhost:8080/api/v1", "/candidate/file/{candidacy_id}", 'post');
    if (params){
      request.path('candidacy_id',params['candidacy_id'], {});
      request.body(params.body, 'multipart/form-data');
    }

    return this.http.request(
      request.build({ responseType: 'json', accept: 'application/json'})
    )
  }

}
