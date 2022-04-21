package com.rafael.agendaTelefonica.repository;

import com.rafael.agendaTelefonica.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepo extends JpaRepository<ContatoEntity, Integer> {
}
