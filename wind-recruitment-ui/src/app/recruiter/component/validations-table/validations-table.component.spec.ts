import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidationsTableComponent } from './validations-table.component';

describe('ValidationsTableComponent', () => {
  let component: ValidationsTableComponent;
  let fixture: ComponentFixture<ValidationsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ValidationsTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValidationsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
