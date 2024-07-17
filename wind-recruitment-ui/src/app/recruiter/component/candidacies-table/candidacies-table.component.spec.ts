import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidaciesTableComponent } from './candidacies-table.component';

describe('CandidaciesTableComponent', () => {
  let component: CandidaciesTableComponent;
  let fixture: ComponentFixture<CandidaciesTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CandidaciesTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CandidaciesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
