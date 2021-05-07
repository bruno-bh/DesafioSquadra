import { SistemaFilterDTO } from './dto/sistemaFilterdto';
import { environment } from './../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sistema } from './sistema';

@Injectable({
  providedIn: 'root'
})
export class SistemaService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllSistemas(filterDTO: SistemaFilterDTO): Observable<Sistema[]> {
    return this.http.get<Sistema[]>(`${this.apiUrl}/sistemas?descricao=${filterDTO.descricao}&sigla=${filterDTO.sigla}&email=${filterDTO.email}`);
  }

  public newSistema(sistema: Sistema): Observable<Sistema> {
    return this.http.post<Sistema>(`${this.apiUrl}/sistemas/new`, sistema);
  }

  public updateSistema(sistema: Sistema): Observable<Sistema> {
    return this.http.put<Sistema>(`${this.apiUrl}/sistemas/sistema`, sistema);
  }

  public deleteSistema(sistemaId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/sistemas/${sistemaId}`);
  }

}

