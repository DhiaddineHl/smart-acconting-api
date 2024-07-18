import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteringModalComponent } from './registering-modal.component';

describe('RegisteringModalComponent', () => {
  let component: RegisteringModalComponent;
  let fixture: ComponentFixture<RegisteringModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegisteringModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisteringModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
