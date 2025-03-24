import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MongoDBSVUIComponent } from './mongodb-ui.component';

describe('MongoDBSVUIComponent', () => {
  let component: MongoDBSVUIComponent;
  let fixture: ComponentFixture<MongoDBSVUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MongoDBSVUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MongoDBSVUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
