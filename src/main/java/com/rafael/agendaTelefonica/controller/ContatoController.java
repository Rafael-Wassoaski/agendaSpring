package com.rafael.agendaTelefonica.controller;

import com.rafael.agendaTelefonica.entity.ContatoEntity;
import com.rafael.agendaTelefonica.repository.ContatoRepo;
import com.rafael.agendaTelefonica.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    private ContatoRepo contatoRepo;
    @Autowired
    private ContatoService contatoService;

    @GetMapping("/{id}")
    public EntityModel<ContatoEntity> getById(@PathVariable Integer id) {
        return contatoService.getById(id);
    }

    @GetMapping
    public List<EntityModel<ContatoEntity>> getByFilter(ContatoEntity filtro) {
        return contatoService.getByFilter(filtro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoEntity createContato(@RequestBody ContatoEntity contato) {
        return contatoService.save(contato);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContato(@PathVariable Integer id, @RequestBody ContatoEntity contato) {
        ContatoEntity contatoFound = contatoRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato com esse id não foi encotrado"));

        contato.setId(contatoFound.getId());
        contatoRepo.save(contato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContato(@PathVariable Integer id) {
        ContatoEntity contatoFound = contatoRepo
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato com esse id não foi encotrado"));

        contatoRepo.deleteById(id);
    }
}
