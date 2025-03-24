import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySQLNDTUIComponent } from './mysql-ndt-ui.component';

describe('MySQLNDTUIComponent', () => {
  let component: MySQLNDTUIComponent;
  let fixture: ComponentFixture<MySQLNDTUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MySQLNDTUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MySQLNDTUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
