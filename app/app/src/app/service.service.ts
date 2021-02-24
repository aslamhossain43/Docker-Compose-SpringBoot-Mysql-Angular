import { Injectable } from '@angular/core';

import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee, IEmployee } from './app.model';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private host = environment.API_HOST;
  private getUrl = this.host + '/get';
  private addUrl = this.host + '/add';
  private deleteUrl = this.host + '/delete/';
  constructor(private http: HttpClient) { }
  getAll(): Observable<HttpResponse<IEmployee[]>> {
    return this.http.get<IEmployee[]>(this.getUrl, { observe: 'response' });
  }
  add(): Observable<HttpResponse<IEmployee[]>> {
    return this.http.get<IEmployee[]>(this.addUrl, { observe: 'response' });
  }
  delete(id?: any): Observable<HttpResponse<{}>> {
    return this.http.delete(this.deleteUrl + `${id}`, { observe: 'response' });
  }
}
