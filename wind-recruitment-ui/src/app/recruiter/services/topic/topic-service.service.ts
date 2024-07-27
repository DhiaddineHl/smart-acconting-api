import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StrictHttpResponse} from "../../../services/strict-http-response";

export interface TopicCreationRequest{
  name: string
  duration: number
  description: string
  requirements: Array<string>
}

export interface TopicResponse{
  id: number
  description: string;
  duration: number;
  name: string;
  requirements: string[];
}
export interface TopicResponsePage{
  content?: Array<TopicResponse>;
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
export class TopicServiceService {

  constructor(private httpClient: HttpClient) { }

  createTopic = (request: TopicCreationRequest) : Observable<StrictHttpResponse<void>> => {
    return this.httpClient.post<StrictHttpResponse<void>>("http://localhost:8080/api/v1/hr/topic", request)
  }
  updateTopic = (request: TopicCreationRequest, topicId: number) : Observable<StrictHttpResponse<void>> => {
    return this.httpClient.put<StrictHttpResponse<void>>(`http://localhost:8080/api/v1/hr/topic/${topicId}`, request)
  }
  deleteTopic = (topicId: number) : Observable<StrictHttpResponse<void>> => {
    return this.httpClient.delete<StrictHttpResponse<void>>(`http://localhost:8080/api/v1/hr/topic/${topicId}`)
  }

  getAllTopics = (size: number, number: number) : Observable<TopicResponsePage> => {
    return this.httpClient.get<TopicResponsePage>('http://localhost:8080/api/v1/hr/topics', {
      params: {
        size: size,
        number: number
      }
    })
  }

  getTopicById = (topicId: number) : Observable<TopicResponse> => {
    return this.httpClient.get<TopicResponse>(`http://localhost:8080/api/v1/hr/topic/${topicId}`)
  }

  getTopicsByRecruiter = (number: number, size: number) : Observable<TopicResponsePage> => {
    return this.httpClient.get<TopicResponsePage>('http://localhost:8080/api/v1/hr/topicsByRecruiter', {
      params: {
        number: number,
        size: size
      }
    })
  }

}
