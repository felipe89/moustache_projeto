import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-agendamento-crud',
  templateUrl: './agendamento-crud.component.html',
  styleUrls: ['./agendamento-crud.component.css']
})
export class AgendamentoCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navegaParaCriacaoDeAgendamento(): void {
  this.router.navigate(['/agendamento/create'])
  }
}
