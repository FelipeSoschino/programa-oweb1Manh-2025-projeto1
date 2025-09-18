package com.senac.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="jogo")
public class Jogo {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jogo_id")
    private int id;

    @Column(name="jogo_nome")
    private String nome;

    @Column(name="jogo_status")
    private int status;

    public int getIdCategoria() {
        return idCategoria = categoria.getId();
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Transient
    @JsonProperty("idCategoria")
    private int idCategoria;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="categoria_id", nullable = false)
    private Categoria categoria;










}
