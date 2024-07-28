import { TestBed } from '@angular/core/testing';

import { CandidaciesServiceService } from './candidacies-service.service';

describe('CandidaciesServiceService', () => {
  let service: CandidaciesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CandidaciesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
