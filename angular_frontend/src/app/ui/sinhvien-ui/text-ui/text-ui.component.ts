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

@Component({
  selector: 'app-text-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableSVComponent, LogoutComponent, ButtonDeleteComponent],
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
        alert(error.message);
      }
    });
  }

  public onDeleteSV(msv: string): void {
    this.textSVService.deleteSV(msv).subscribe({
      next: (response: void) => {
        this.onReadSV();
        console.log(this.sv);
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onOpenModal(sv: SinhVien): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    this.deleteSV = sv;
    button.setAttribute('data-target', '#deleteSVModal');
    container!.appendChild(button);
    button.click();
  }

}
