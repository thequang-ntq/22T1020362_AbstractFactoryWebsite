import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextNDTUIComponent } from './text-ndt-ui.component';

describe('TextNDTUIComponent', () => {
  let component: TextNDTUIComponent;
  let fixture: ComponentFixture<TextNDTUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TextNDTUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextNDTUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
