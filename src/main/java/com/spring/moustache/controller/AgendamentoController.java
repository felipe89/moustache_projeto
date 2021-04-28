package com.spring.moustache.controller;

import com.spring.moustache.model.Agendamento;
import com.spring.moustache.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @RequestMapping(value = "/agendar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@RequestBody @Valid Agendamento agendamento ) {
        return agendamentoRepository.save(agendamento);
    }

    @GetMapping("{id}")
    public Agendamento buscarPorId(@PathVariable long id){
        return agendamentoRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }

    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAgendamento(@PathVariable long id){
        agendamentoRepository
                .findById(id)
                .map(agendamento -> {
                    agendamentoRepository.delete(agendamento);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }

    @RequestMapping(value = "/agenda/{id}", method = RequestMethod.PUT)
    public void atualizaAgendamento(@PathVariable long id, @RequestBody Agendamento agendamentoAtualizado){
        agendamentoRepository
        .findById(id)
        .map(agendamento -> {
            agendamento.setNome(agendamentoAtualizado.getNome());
            agendamento.setEmail(agendamentoAtualizado.getEmail());
            agendamento.setData(agendamentoAtualizado.getData());
            agendamento.setHora(agendamentoAtualizado.getHora());
            return agendamentoRepository.save(agendamentoAtualizado);
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não encontrado"));
    }

    @RequestMapping(value = "/agenda", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Agendamento> todosAgendamentos() {
        List<Agendamento> listar = agendamentoRepository.findAll();

        return listar;
    }
}
