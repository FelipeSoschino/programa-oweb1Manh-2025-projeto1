package com.senac.games.service;

import com.senac.games.entity.Inscricao;
import com.senac.games.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoServer {

    private InscricaoRepository inscricaoRepository;
    private InscricaoServer(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.findAll();
    }


}
