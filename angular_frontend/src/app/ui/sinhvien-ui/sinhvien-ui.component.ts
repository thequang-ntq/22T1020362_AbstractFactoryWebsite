import { Component, OnInit } from '@angular/core';
import { SinhVien } from '../../entity/sinhvien/sinhvien';
import { TextSVService } from '../../service/sinhvien/textSV.service';
import { MongoDBSVService } from '../../service/sinhvien/mongodbSV.service';
import { MySQLSVService } from '../../service/sinhvien/mysqlSV.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sinhvien-ui',
  imports: [],
  templateUrl: './sinhvien-ui.component.html',
  styleUrl: './sinhvien-ui.component.css'
})
export class SinhvienUIComponent implements OnInit {
  public sv!: SinhVien[];
  public deleteSV!: SinhVien;

  constructor(private textSVService: TextSVService, private mongoDBSVService: MongoDBSVService, private mySQLSVService: MySQLSVService) {}

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

  public onDeleteSV(msv: string, type: string): void {
    var service;
    if(type === 'MySQL'){
      service = this.mySQLSVService;
    }
    else if(type === 'MongoDB'){
      service = this.mongoDBSVService;
    }
    else{
      service = this.textSVService;
    }
    service.deleteSV(msv).subscribe({
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
