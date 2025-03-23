import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableNDTComponent } from './table-ndt.component';

describe('TableNDTComponent', () => {
  let component: TableNDTComponent;
  let fixture: ComponentFixture<TableNDTComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableNDTComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableNDTComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
