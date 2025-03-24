import { Component, OnInit } from '@angular/core';
import { Nganh } from '../../../entity/nganh/nganh';
import { TextNDTService } from '../../../service/nganh/textNDT.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { DbchoiceComponent } from '../../../component/dbchoice/dbchoice.component';
import { EntitychoiceComponent } from '../../../component/entitychoice/entitychoice.component';
import { TableNDTComponent } from '../../../component/table-ndt/table-ndt.component';
import { LogoutComponent } from '../../../component/logout/logout.component';
import { ButtonAddComponent } from '../../../component/button-add/button-add.component';

@Component({
  selector: 'app-text-ndt-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableNDTComponent, LogoutComponent, ButtonAddComponent],
  templateUrl: './text-ndt-ui.component.html',
  styleUrl: './text-ndt-ui.component.css'
})
export class TextNDTUIComponent implements OnInit {
  public ndt: Nganh[] = [];
  public selectedOption: string = 'nganh';
  public selectedDB: string = 'text';

  selectedDBEvent(db: string) {
    this.selectedDB = db;
  }

  constructor(private textNDTService: TextNDTService) {}

  ngOnInit() {
    this.onReadNDT();
  }

  public onReadNDT(): void {
    this.textNDTService.readNDT().subscribe({
      next: (response: Nganh[]) => {
        this.ndt = response;
        console.log(this.ndt);
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onInsertNDT(insertForm: NgForm, type: string): void {
    document.getElementById('add-employee-form')!.click();
    this.textNDTService.insertNDT(insertForm.value).subscribe({
      next: (response: Nganh) => {
        console.log(response);
        this.onReadNDT();
        insertForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
        insertForm.reset();
      }
    });
  }

  public onOpenModal(ndt: Nganh): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-target', '#insertNDTModal');
    container!.appendChild(button);
    button.click();
  }

}
