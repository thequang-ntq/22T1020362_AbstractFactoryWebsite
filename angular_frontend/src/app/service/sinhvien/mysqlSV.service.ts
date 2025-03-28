import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SinhVien } from '../../entity/sinhvien/sinhvien';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MySQLSVService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public readSV(): Observable<SinhVien[]> {
    return this.http.get<SinhVien[]>(`${this.apiServerUrl}/mysql/sinhvien`);
  }

  public deleteSV(msv: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/mysql/sinhvien/delete/${msv}`);
  }
}
