import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MySQLSVUIComponent } from './mysql-ui.component';

describe('MySQLSVUIComponent', () => {
  let component: MySQLSVUIComponent;
  let fixture: ComponentFixture<MySQLSVUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MySQLSVUIComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MySQLSVUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
