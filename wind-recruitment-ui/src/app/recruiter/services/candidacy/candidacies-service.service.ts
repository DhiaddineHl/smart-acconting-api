import { Injectable } from '@angular/core';
import {TopicResponse} from "../topic/topic-service.service";
import {Observable} from "rxjs";
import {StrictHttpResponse} from "../../../services/strict-http-response";
import {HttpClient, HttpContext} from "@angular/common/http";
import {UploadCandidacyFiles$Params} from "../../../services/fn/candidate-controller/upload-candidacy-files";
import {map} from "rxjs/operators";
import {ApiConfiguration} from "../../../services/api-configuration";
import {uploadCandidacyFiles} from "./helpers/file-upload-helper";


export interface CandidaciesResponsePage{
  content?: Array<CandidacyResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
export interface CandidacyResponse {
  id: number
  candidate_full_name: string
  topic: TopicResponse
  file: Array<string>
  createdAt: string
  status: string
}

interface CandidacyRequest {
  topic_id?: number
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

  getAllCandidacies = (size: number, number: number) : Observable<CandidaciesResponsePage> => {
    return this.http.get<CandidaciesResponsePage>('http://localhost:8080/api/v1/hr/candidacies', {
      params: {
        size: size,
        number: number
      }
    })
  }
  getCandidaciesByCandidate = (candidateId: number, size: number, number: number) => {
    return this.http.get<CandidaciesResponsePage>(`http://localhost:8080/api/v1/hr/candidacies/candidate/${candidateId}`, {
      params: {
        size: size,
        number: number
      }
    })
  }

  getCandidacyById = (candidacyId: number) : Observable<CandidacyResponse> => {
    return this.http.get<CandidacyResponse>(`http://localhost:8080/api/v1/hr/candidacies/${candidacyId}`)
  }

  getMyCandidacies = (size: number, number:number): Observable<CandidaciesResponsePage> => {
    return this.http.get<CandidaciesResponsePage>("http://localhost:8080/api/v1/candidate/myCandidacies")
  }

  validateCandidacy = (candidacy_id: number): Observable<StrictHttpResponse<void>> => {
    return this.http.post<StrictHttpResponse<void>>(`http://localhost:8080/api/v1/hr/validate-candidacy/${candidacy_id}`, {})
  }

}
