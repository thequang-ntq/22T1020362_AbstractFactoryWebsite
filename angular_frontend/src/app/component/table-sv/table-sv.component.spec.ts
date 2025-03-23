import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableSVComponent } from './table-sv.component';

describe('TableSVComponent', () => {
  let component: TableSVComponent;
  let fixture: ComponentFixture<TableSVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableSVComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableSVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
