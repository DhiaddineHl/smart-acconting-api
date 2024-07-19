import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaciesPageComponent } from './candidacies-page.component';

describe('CandidaciesPageComponent', () => {
  let component: CandidaciesPageComponent;
  let fixture: ComponentFixture<CandidaciesPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaciesPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidaciesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
