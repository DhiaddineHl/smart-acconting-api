import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountActivationFormComponent } from './account-activation-form.component';

describe('AccountActivationFormComponent', () => {
  let component: AccountActivationFormComponent;
  let fixture: ComponentFixture<AccountActivationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccountActivationFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountActivationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
