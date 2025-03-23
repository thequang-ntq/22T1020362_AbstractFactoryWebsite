import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SinhvienUIComponent } from './sinhvien-ui.component';

describe('SinhvienUIComponent', () => {
  let component: SinhvienUIComponent;
  let fixture: ComponentFixture<SinhvienUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SinhvienUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SinhvienUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
