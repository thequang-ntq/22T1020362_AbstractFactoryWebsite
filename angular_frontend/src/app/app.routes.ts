import { Routes } from '@angular/router';
export const routes: Routes = [
    {
        path: '',
        pathMatch: 'full',
        loadComponent: () => {
          return import('./ui/login-ui/login-ui.component').then((m) => m.LoginUIComponent);
        },
      },
      {
        path: 'sinhvien/mysql',
        loadComponent: () => {
          return import('./ui/sinhvien-ui/mysql-ui/mysql-ui.component').then((m) => m.MySQLSVUIComponent);
        },
      },
      {
        path: 'sinhvien/mongodb',
        loadComponent: () => {
          return import('./ui/sinhvien-ui/mongodb-ui/mongodb-ui.component').then((m) => m.MongoDBSVUIComponent);
        },
      },
      {
        path: 'sinhvien/text',
        loadComponent: () => {
          return import('./ui/sinhvien-ui/text-ui/text-ui.component').then((m) => m.TextSVUIComponent);
        },
      },
      {
        path: 'nganh/mysql',
        loadComponent: () => {
          return import('./ui/nganh-ui/mysql-ndt-ui/mysql-ndt-ui.component').then((m) => m.MySQLNDTUIComponent);
        },
      },
      {
        path: 'nganh/mongodb',
        loadComponent: () => {
          return import('./ui/nganh-ui/mongodb-ndt-ui/mongodb-ndt-ui.component').then((m) => m.MongoDBNDTUIComponent);
        },
      },
      {
        path: 'nganh/text',
        loadComponent: () => {
          return import('./ui/nganh-ui/text-ndt-ui/text-ndt-ui.component').then((m) => m.TextNDTUIComponent);
        },
      },
];
