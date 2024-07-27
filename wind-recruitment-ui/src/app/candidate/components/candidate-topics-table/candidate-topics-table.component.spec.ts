import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateTopicsTableComponent } from './candidate-topics-table.component';

describe('CandidateTopicsTableComponent', () => {
  let component: CandidateTopicsTableComponent;
  let fixture: ComponentFixture<CandidateTopicsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidateTopicsTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidateTopicsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
