import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Nganh } from '../../entity/nganh/nganh';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TextNDTService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public readNDT(): Observable<Nganh[]> {
    return this.http.get<Nganh[]>(`${this.apiServerUrl}/text/nganh`);
  }

  public insertNDT(ndt: Nganh): Observable<Nganh> {
    return this.http.post<Nganh>(`${this.apiServerUrl}/text/nganh/add`, ndt);
  }
}
