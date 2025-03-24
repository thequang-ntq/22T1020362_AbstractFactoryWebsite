import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { MongoDBNDTService } from './service/nganh/mongodbNDT.service';
import { MySQLNDTService } from './service/nganh/mysqlNDT.service';
import { TextNDTService } from './service/nganh/textNDT.service';
import { MongoDBSVService } from './service/sinhvien/mongodbSV.service';
import { MySQLSVService } from './service/sinhvien/mysqlSV.service';
import { TextSVService } from './service/sinhvien/textSV.service';

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    MongoDBNDTService, MySQLNDTService, TextNDTService, 
    MongoDBSVService, MySQLSVService, TextSVService,
  ]
};
