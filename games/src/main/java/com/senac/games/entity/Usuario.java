package com.senac.games.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_id")
    private int id;
    @Column(name= "usuario_nome")
    private  String nome;
    @Column(name= "usuario_cpf")
    private  String cpf;
    @Column(name="usuario_data_nascimento")
    private Date data;
    @Column(name="usuario_status")
    private int status;


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public Date getData() {return data;}

    public void setData(Date data) {this.data = data;}

    public int getStatus() {return status;}

    public void setStatus(int status) {this.status = status;}
}
