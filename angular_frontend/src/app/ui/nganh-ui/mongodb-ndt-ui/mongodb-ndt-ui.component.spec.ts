import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MongoDBNDTUIComponent } from './mongodb-ndt-ui.component';

describe('MongoDBNDTUIComponent', () => {
  let component: MongoDBNDTUIComponent;
  let fixture: ComponentFixture<MongoDBNDTUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MongoDBNDTUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MongoDBNDTUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
