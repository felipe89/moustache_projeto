package com.spring.moustache.service;

import com.spring.moustache.model.Agendamento;

import java.util.List;

public interface AgendamentoService {

    List<Agendamento> findAll();

    Agendamento findById(Long id);

    String save(Agendamento agendamento);


}
