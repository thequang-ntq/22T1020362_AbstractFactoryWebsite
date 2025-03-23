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
        path: 'sinhvien',
        loadComponent: () => {
          return import('./ui/sinhvien-ui/sinhvien-ui.component').then((m) => m.SinhvienUIComponent);
        },
      },
      {
        path: 'nganh',
        loadComponent: () => {
          return import('./ui/nganh-ui/nganh-ui.component').then((m) => m.NganhUIComponent);
        },
      },
];
