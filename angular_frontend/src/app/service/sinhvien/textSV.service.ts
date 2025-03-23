import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SinhVien } from '../../entity/sinhvien/sinhvien';

@Injectable({
  providedIn: 'root'
})
export class TextSVService {
  private apiServerUrl = '';

  constructor(private http: HttpClient){}

  public readSV(): Observable<SinhVien[]> {
    return this.http.get<SinhVien[]>(`${this.apiServerUrl}/text/sinhvien`);
  }

  public deleteSV(msv: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/text/sinhvien/delete/${msv}`);
  }
}
