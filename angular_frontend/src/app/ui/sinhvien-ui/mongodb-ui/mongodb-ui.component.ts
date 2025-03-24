import { Component, OnInit} from '@angular/core';
import { SinhVien } from '../../../entity/sinhvien/sinhvien';
import { MongoDBSVService } from '../../../service/sinhvien/mongodbSV.service';
import { HttpErrorResponse } from '@angular/common/http';
// import { NgForm } from '@angular/forms';
import { DbchoiceComponent } from '../../../component/dbchoice/dbchoice.component';
import { EntitychoiceComponent } from '../../../component/entitychoice/entitychoice.component';
import { TableSVComponent } from '../../../component/table-sv/table-sv.component';
import { LogoutComponent } from '../../../component/logout/logout.component';
import { ButtonDeleteComponent } from '../../../component/button-delete/button-delete.component';

@Component({
  selector: 'app-mongodb-ui',
  imports: [DbchoiceComponent, EntitychoiceComponent, TableSVComponent, LogoutComponent, ButtonDeleteComponent],
  templateUrl: './mongodb-ui.component.html',
  styleUrl: './mongodb-ui.component.css'
})
export class MongoDBSVUIComponent implements OnInit {
  public sv: SinhVien[] = [];
  public deleteSV: SinhVien = {} as SinhVien;
  public selectedOption: string = 'sinhvien';
  public selectedDB: string = 'mongodb';


  constructor(private mongoDBSVService: MongoDBSVService) {}

  ngOnInit() {
    this.onReadSV();
  }

  public onReadSV(): void {
    this.mongoDBSVService.readSV().subscribe({
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
    this.mongoDBSVService.deleteSV(msv).subscribe({
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
