import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SinhVien } from './entity/sinhvien/sinhvien';
import { Nganh } from './entity/nganh/nganh';
import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MongoDBNDTService } from './service/nganh/mongodbNDT.service';
import { MySQLNDTService } from './service/nganh/mysqlNDT.service';
import { TextNDTService } from './service/nganh/textNDT.service';
import { MongoDBSVService } from './service/sinhvien/mongodbSV.service';
import { MySQLSVService } from './service/sinhvien/mysqlSV.service';
import { TextSVService } from './service/sinhvien/textSV.service';

@NgModule({
  declarations: [
    // AppComponent
  ],
  imports: [
    BrowserModule, FormsModule
  ],
  providers: [MongoDBNDTService, MySQLNDTService, TextNDTService, 
    MongoDBSVService, MySQLSVService, TextSVService, provideHttpClient()],
//   bootstrap: [AppComponent]
})
export class AppModule { }