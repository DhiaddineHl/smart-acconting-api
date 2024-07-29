/* tslint:disable */
/* eslint-disable */
import { TopicResponse } from '../models/topic-response';
export interface PageResponseTopicResponse {
  content?: Array<TopicResponse>;
  first?: boolean;
  last?: boolean;
  number?: number;
  size?: number;
  totalElements?: number;
  totalPages?: number;
}
