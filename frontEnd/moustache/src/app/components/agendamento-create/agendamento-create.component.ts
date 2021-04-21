import { Agendamento } from './../agendamento.model';
import { AgendamentoService } from './../agendamento.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-agendamento-create',
  templateUrl: './agendamento-create.component.html',
  styleUrls: ['./agendamento-create.component.css']
})
export class AgendamentoCreateComponent implements OnInit {

  novoAgendamento: Agendamento = {
    nome:'rafael',
    email:'rafael@teste.com',
    data:'2020/10/11',
    hora:'15:15'
  }

  constructor(
    private agendamentoService: AgendamentoService, 
    private router: Router) { }

  ngOnInit(): void {
  }
  criaAgendamento(): void {
    this.agendamentoService.cria(this.novoAgendamento).subscribe(()=>{
      this.agendamentoService.showMeMsg('Operação realizada com sucesso!')
      this.router.navigate(['/agendamento'])
    })
  }

  cancelaAgendamento(): void{
    this.router.navigate(['/agendamento'])
    this.agendamentoService.showMeMsg('Operação cancelada :(')
  }
}
