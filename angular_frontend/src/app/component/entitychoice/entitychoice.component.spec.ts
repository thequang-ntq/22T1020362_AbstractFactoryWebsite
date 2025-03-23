import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntitychoiceComponent } from './entitychoice.component';

describe('EntitychoiceComponent', () => {
  let component: EntitychoiceComponent;
  let fixture: ComponentFixture<EntitychoiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EntitychoiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntitychoiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
