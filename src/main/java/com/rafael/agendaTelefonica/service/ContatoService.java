package com.rafael.agendaTelefonica.service;

import com.rafael.agendaTelefonica.entity.ContatoEntity;
import com.rafael.agendaTelefonica.repository.ContatoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepo contatoRepo;

    public EntityModel<ContatoEntity> getById(@PathVariable Integer id) {
        ContatoEntity contato = contatoRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato com esse id não foi encotrado"));

        return this.addWhatsAppLink(contato);
    }

    public List<EntityModel<ContatoEntity>> getByFilter(ContatoEntity filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        Stream<ContatoEntity> contatosStream = contatoRepo.findAll(example).stream();
        List<EntityModel<ContatoEntity>> contatos = contatosStream.map(contato -> this.addWhatsAppLink(contato)).collect(Collectors.toList());

        return contatos;
    }

    private EntityModel<ContatoEntity> addWhatsAppLink(ContatoEntity contato) {
        EntityModel<ContatoEntity> contatoComLink = EntityModel.of(contato);

        contatoComLink.add(Link.of("https://api.whatsapp.com/send?phone=" + contato.getTelefone()).withRel("whatsAppLink"));

        return contatoComLink;
    }
}
