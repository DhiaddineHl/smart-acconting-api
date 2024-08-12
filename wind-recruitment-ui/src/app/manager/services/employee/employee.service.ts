import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CandidacyResponse} from "../../../recruiter/services/candidacy/candidacies-service.service";
import {Observable} from "rxjs";

export interface EmployeeResponse {
  id: number,
  full_name: string,
  email: string,
  speciality: string,
  account_state: boolean
}

export interface EmployeesResponsePage{
  content?: Array<EmployeeResponse>;
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
export class EmployeeService {

  constructor(
    private client : HttpClient
  ) { }

  getAllHRRecruiter = (size: number, number: number): Observable<EmployeesResponsePage> => {
    return this.client.get<EmployeesResponsePage>("http://localhost:8080/api/v1/manager/employees/hr", {
      params: {
        size: size,
        number: number
      }
    })
  }

  getAllTechnicalRecruiter = (size: number, number: number): Observable<EmployeesResponsePage> => {
    return this.client.get<EmployeesResponsePage>("http://localhost:8080/api/v1/manager/employees/technical", {
      params: {
        size: size,
        number: number
      }
    })
  }

  blockEmployee(employee_id : number) : Observable<void>{
    return this.client.put<void>(`http://localhost:8080/api/v1/manager/block-employee/${employee_id}`, {})
  }

  activateEmployee(employee_id: number) : Observable<void>{
    return this.client.put<void>(`http://localhost:8080/api/v1/manager/enable-employee/${employee_id}`, {})
  }



}
