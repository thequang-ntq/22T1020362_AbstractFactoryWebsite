import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextSVUIComponent } from './text-ui.component';

describe('TextSVUIComponent', () => {
  let component: TextSVUIComponent;
  let fixture: ComponentFixture<TextSVUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TextSVUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextSVUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
