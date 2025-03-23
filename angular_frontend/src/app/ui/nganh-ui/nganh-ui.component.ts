import { Component, OnInit } from '@angular/core';
import { Nganh } from '../../entity/nganh/nganh';
import { TextNDTService } from '../../service/nganh/textNDT.service';
import { MongoDBNDTService } from '../../service/nganh/mongodbNDT.service';
import { MySQLNDTService } from '../../service/nganh/mysqlNDT.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-nganh-ui',
  imports: [],
  templateUrl: './nganh-ui.component.html',
  styleUrl: './nganh-ui.component.css'
})
export class NganhUIComponent implements OnInit {
  public ndt!: Nganh[];

  constructor(private textNDTService: TextNDTService, private mongoDBNDTService: MongoDBNDTService, private mySQLNDTService: MySQLNDTService) {}

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
    var service;
    if(type === 'MySQL'){
      service = this.mySQLNDTService;
    }
    else if(type === 'MongoDB'){
      service = this.mongoDBNDTService;
    }
    else{
      service = this.textNDTService;
    }
    service.insertNDT(insertForm.value).subscribe({
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
