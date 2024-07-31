import { Injectable } from '@angular/core';
import {CandidacyResponse} from "../candidacy/candidacies-service.service";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

interface ValidationResponse{
  id : number,
  candidacy: CandidacyResponse
}

interface ValidationResponsePage {
  content?: Array<ValidationResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}

@Injectable({
  providedIn: 'root'
})
export class ValidationServiceService {

  constructor(private httpClient: HttpClient) { }

  getAllValidations = (size: number, number: number): Observable<ValidationResponsePage> => {
    return this.httpClient.get<ValidationResponsePage>("http://localhost:8080/api/v1/hr/validations", {
      params: {
        size : size,
        number : number
      }
    })
  }

  getValidationById = (validationId: number) : Observable<ValidationResponse> => {
    return this.httpClient.get<ValidationResponse>(`http://localhost:8080/api/v1/hr/validations/${validationId}`)
  }

  getValidationsByRecruiter = (size: number, number: number) => {
    return this.httpClient.get<ValidationResponsePage>("http://localhost:8080/api/v1/hr/validationsByRecriuter", {
      params: {
        size: size,
        number: number
      }
    })
  }


}
