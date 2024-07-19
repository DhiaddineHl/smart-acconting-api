import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidacyModalComponent } from './candidacy-modal.component';

describe('CandidacyModalComponent', () => {
  let component: CandidacyModalComponent;
  let fixture: ComponentFixture<CandidacyModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidacyModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidacyModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
