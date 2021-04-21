import { Agendamento } from './agendamento.model';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgendamentoService {
    
  baseUrl = "http://localhost:8081/agendamento/agendar"

  constructor(
    private matSnackBar:MatSnackBar,
    private http: HttpClient) { }

  showMeMsg(msg: string):  void{
    this.matSnackBar.open(msg,'', {
      duration: 1000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }
  cria(agendamento: Agendamento): Observable <Agendamento> {
  return this.http.post<Agendamento>(this.baseUrl,agendamento)
  }
}
