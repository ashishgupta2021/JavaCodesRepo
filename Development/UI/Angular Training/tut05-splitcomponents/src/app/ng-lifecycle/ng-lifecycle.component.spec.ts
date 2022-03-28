import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgLifecycleComponent } from './ng-lifecycle.component';

describe('NgLifecycleComponent', () => {
  let component: NgLifecycleComponent;
  let fixture: ComponentFixture<NgLifecycleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgLifecycleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgLifecycleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
