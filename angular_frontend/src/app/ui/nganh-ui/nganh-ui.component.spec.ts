import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NganhUIComponent } from './nganh-ui.component';

describe('NganhUIComponent', () => {
  let component: NganhUIComponent;
  let fixture: ComponentFixture<NganhUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NganhUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NganhUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
