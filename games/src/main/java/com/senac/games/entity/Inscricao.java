package com.senac.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="inscricao")
public class Inscricao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inscricao_id")
    private int id;

    @Column(name="inscricao_data")
    private Date data;

    @Column(name="inscricao_status")
    private int status;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="participante_id")
    private Participante participante;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }




}
