import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SinhVien } from '../../entity/sinhvien/sinhvien';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MongoDBSVService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public readSV(): Observable<SinhVien[]> {
    return this.http.get<SinhVien[]>(`${this.apiServerUrl}/mongodb/sinhvien`);
  }

  public deleteSV(msv: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/mongodb/sinhvien/delete/${msv}`);
  }
}
