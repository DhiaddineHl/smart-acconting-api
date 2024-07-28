import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicDetailsModalComponent } from './topic-details-modal.component';

describe('TopicDetailsModalComponent', () => {
  let component: TopicDetailsModalComponent;
  let fixture: ComponentFixture<TopicDetailsModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopicDetailsModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopicDetailsModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
