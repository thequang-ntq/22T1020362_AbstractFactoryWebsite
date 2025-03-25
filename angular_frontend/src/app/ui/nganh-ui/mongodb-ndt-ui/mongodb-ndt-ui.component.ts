import { Component, OnInit } from '@angular/core';
import { Nganh } from '../../../entity/nganh/nganh';
import { MongoDBNDTService } from '../../../service/nganh/mongodbNDT.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { DbchoiceComponent } from '../../../component/dbchoice/dbchoice.component';
import { EntitychoiceComponent } from '../../../component/entitychoice/entitychoice.component';
import { TableNDTComponent } from '../../../component/table-ndt/table-ndt.component';
import { LogoutComponent } from '../../../component/logout/logout.component';
import { ButtonAddComponent } from '../../../component/button-add/button-add.component';

@Component({
  selector: 'app-mongodb-ndt-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableNDTComponent, LogoutComponent, ButtonAddComponent, FormsModule],
  templateUrl: './mongodb-ndt-ui.component.html',
  styleUrl: './mongodb-ndt-ui.component.css'
})
export class MongoDBNDTUIComponent implements OnInit {
  public ndt: Nganh[] = [];
  public selectedOption: string = 'nganh';
  public selectedDB: string = 'mongodb';


  constructor(private mongoDBNDTService: MongoDBNDTService) {}

  ngOnInit() {
    this.onReadNDT();
  }

  public onReadNDT(): void {
    this.mongoDBNDTService.readNDT().subscribe({
      next: (response: Nganh[]) => {
        this.ndt = response;
        console.log(this.ndt);
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onInsertNDT(insertForm: NgForm): void {
    document.getElementById('close-employee-form')!.click();
    document.addEventListener("DOMContentLoaded", function () {
      document.addEventListener('hide.bs.modal', function (event) {
          if (document.activeElement) {
              (document.activeElement as any).blur();
          }
      });
    });
    // if(this.textNDTService === undefined || insertForm.value === undefined) return;
    if(insertForm.valid){
      let form: Nganh = {
        maNganh: insertForm.value.manganh,
        tenNganh: insertForm.value.tennganh
      } as Nganh;
      // console.log(form);
      // console.log(this.textNDTService);
      this.mongoDBNDTService.insertNDT(form).subscribe({
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
    
  }

  public onOpenModal(): void {
    const container = document.getElementById('tbl');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#addEmployeeModal');
    container!.appendChild(button);
    button.click();
}

}
