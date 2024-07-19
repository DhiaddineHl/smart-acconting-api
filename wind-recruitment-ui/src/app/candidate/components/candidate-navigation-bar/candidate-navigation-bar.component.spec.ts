import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateNavigationBarComponent } from './candidate-navigation-bar.component';

describe('CandidateNavigationBarComponent', () => {
  let component: CandidateNavigationBarComponent;
  let fixture: ComponentFixture<CandidateNavigationBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidateNavigationBarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidateNavigationBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
