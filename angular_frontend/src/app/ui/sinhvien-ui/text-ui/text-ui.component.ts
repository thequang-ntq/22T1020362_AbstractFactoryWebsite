import { Component, OnInit} from '@angular/core';
import { SinhVien } from '../../../entity/sinhvien/sinhvien';
import { TextSVService } from '../../../service/sinhvien/textSV.service';
import { HttpErrorResponse } from '@angular/common/http';
// import { NgForm } from '@angular/forms';
import { DbchoiceComponent } from '../../../component/dbchoice/dbchoice.component';
import { EntitychoiceComponent } from '../../../component/entitychoice/entitychoice.component';
import { TableSVComponent } from '../../../component/table-sv/table-sv.component';
import { LogoutComponent } from '../../../component/logout/logout.component';
import { ButtonDeleteComponent } from '../../../component/button-delete/button-delete.component';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-text-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableSVComponent, LogoutComponent, ButtonDeleteComponent, FormsModule],
  templateUrl: './text-ui.component.html',
  styleUrl: './text-ui.component.css'
})
export class TextSVUIComponent implements OnInit {
  public sv: SinhVien[] = [];
  public deleteSV: SinhVien = {} as SinhVien;
  public selectedOption: string = 'sinhvien';
  public selectedDB: string = 'text';


  constructor(private textSVService: TextSVService) {}

  ngOnInit() {
    this.onReadSV();
  }

  public onReadSV(): void {
    this.textSVService.readSV().subscribe({
      next: (response: SinhVien[]) => {
        this.sv = response;
        console.log(this.sv);
      },
      error: (error: HttpErrorResponse) => {
        if (error.status === 409) {
          alert("Mã sinh viên không tồn tại. Vui lòng nhập mã sinh viên khác.");
        } else if (error.error && error.error.message) {
          alert(error.error.message);
        } else {
          alert("Hệ thống đang gặp phải lỗi và đang trong quá trình xử lý lỗi.");
        }
      }
    });
  }

  public onDeleteSV(deleteForm: NgForm): void {
    document.getElementById('close-employee-form')!.click();
    document.addEventListener("DOMContentLoaded", function () {
      document.addEventListener('hide.bs.modal', function (event) {
          if (document.activeElement) {
              (document.activeElement as any).blur();
          }
      });
    });
    if(deleteForm.valid){
      let msv: string = deleteForm.value.masv;
      this.textSVService.deleteSV(msv).subscribe({
        next: (response: void) => {
          this.onReadSV();
          console.log(this.sv);
          deleteForm.reset();
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
          deleteForm.reset();
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
