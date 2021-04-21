package com.spring.moustache.service.serviceImpl;

import com.spring.moustache.model.Agendamento;
import com.spring.moustache.repository.AgendamentoRepository;
import com.spring.moustache.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AgendamentoServiceImpl  implements AgendamentoService {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public List<Agendamento> findAll() {

        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento findById(Long id) {

        // FIXME - Melhora a validação do Optional retornado
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);

        return agendamento.get();
    }

//    @Override
//    public Agendamento save(Agendamento agendamento) {
//
//        return agendamentoRepository.save(agendamento);
//    }

    @Override
    public String save(Agendamento agendamento) {

        Agendamento save = agendamentoRepository.save(agendamento);

        return save.getId() != 0? "ok" : "error" ;

    }
}
