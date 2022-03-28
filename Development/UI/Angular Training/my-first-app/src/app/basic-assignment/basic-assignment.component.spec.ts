import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasicAssignmentComponent } from './basic-assignment.component';

describe('BasicAssignmentComponent', () => {
  let component: BasicAssignmentComponent;
  let fixture: ComponentFixture<BasicAssignmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BasicAssignmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BasicAssignmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
