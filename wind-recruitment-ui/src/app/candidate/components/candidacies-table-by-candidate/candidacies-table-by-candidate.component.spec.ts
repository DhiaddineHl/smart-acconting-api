import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaciesTableByCandidateComponent } from './candidacies-table-by-candidate.component';

describe('CandidaciesTableByCandidateComponent', () => {
  let component: CandidaciesTableByCandidateComponent;
  let fixture: ComponentFixture<CandidaciesTableByCandidateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaciesTableByCandidateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidaciesTableByCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
