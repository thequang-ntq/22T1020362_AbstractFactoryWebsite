import { Component, OnInit } from '@angular/core';
import { Nganh } from '../../../entity/nganh/nganh';
import { MySQLNDTService } from '../../../service/nganh/mysqlNDT.service';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';
import { DbchoiceComponent } from '../../../component/dbchoice/dbchoice.component';
import { EntitychoiceComponent } from '../../../component/entitychoice/entitychoice.component';
import { TableNDTComponent } from '../../../component/table-ndt/table-ndt.component';
import { LogoutComponent } from '../../../component/logout/logout.component';
import { ButtonAddComponent } from '../../../component/button-add/button-add.component';

@Component({
  selector: 'app-mysql-ndt-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableNDTComponent, LogoutComponent, ButtonAddComponent, FormsModule],
  templateUrl: './mysql-ndt-ui.component.html',
  styleUrl: './mysql-ndt-ui.component.css'
})
export class MySQLNDTUIComponent implements OnInit {
  public ndt: Nganh[] = [];
  public selectedOption: string = 'nganh';
  public selectedDB: string = 'mysql';


  constructor(private mysqlNDTService: MySQLNDTService) {}

  ngOnInit() {
    this.onReadNDT();
  }

  public onReadNDT(): void {
    this.mysqlNDTService.readNDT().subscribe({
      next: (response: Nganh[]) => {
        this.ndt = response;
        console.log(this.ndt);
      },
      error: (error: HttpErrorResponse) => {
        if (error.status === 409) {
          alert("Mã ngành đã tồn tại. Vui lòng nhập mã ngành khác.");
        } else if (error.error && error.error.message) {
          alert(error.error.message);
        } else {
          alert("Hệ thống đang gặp phải lỗi và đang trong quá trình xử lý lỗi.");
        }
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
      this.mysqlNDTService.insertNDT(form).subscribe({
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
