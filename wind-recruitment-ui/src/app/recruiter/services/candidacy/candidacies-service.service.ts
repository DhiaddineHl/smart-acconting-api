import { Injectable } from '@angular/core';
import {TopicResponse} from "../topic/topic-service.service";

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

}

export interface CandidacyRequest {
  topicId?: number
}

@Injectable({
  providedIn: 'root'
})
export class CandidaciesServiceService {

  constructor() { }
}
