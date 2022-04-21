package com.rafael.agendaTelefonica.entity;

import javax.persistence.*;

@Entity
@Table(name = "Contato")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String telefone;

    public ContatoEntity(){}

    public ContatoEntity(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
