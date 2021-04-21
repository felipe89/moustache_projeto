
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AgendamentoCrudComponent } from './views/agendamento-crud/agendamento-crud.component'
import { HomeComponent } from './views/home/home.component'
import { ClientesComponent } from './views/clientes/clientes.component'
import { AgendaComponent } from './views/agenda/agenda.component';
import { PrecosComponent } from './views/precos/precos.component'
import { AgendamentoCreateComponent } from './components/agendamento-create/agendamento-create.component';

const routes: Routes = [{
  path: 'home', 
  component: HomeComponent
}, 
{
  path: 'agendamento', 
  component: AgendamentoCrudComponent
},
{
  path: 'clientes', 
  component: ClientesComponent
},
{
  path: 'agenda', 
  component: AgendaComponent
},
{
  path: 'precos', 
  component: PrecosComponent
},
{
  path: 'agendamento/create', 
  component: AgendamentoCreateComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
