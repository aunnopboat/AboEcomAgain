import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransectionComponent } from './transaction.component';

describe('TransectionComponent', () => {
  let component: TransectionComponent;
  let fixture: ComponentFixture<TransectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
