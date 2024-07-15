import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaciesComponent } from './candidacies.component';

describe('CandidaciesComponent', () => {
  let component: CandidaciesComponent;
  let fixture: ComponentFixture<CandidaciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaciesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidaciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
