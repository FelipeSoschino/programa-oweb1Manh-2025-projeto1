package com.senac.games.service;

import com.senac.games.entity.Jogo;
import com.senac.games.entity.Usuario;
import com.senac.games.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private JogoRepository jogoRepository;

    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarJogos(){
        return jogoRepository.findAll();
    }

    public Jogo listarJogoPorId(Integer JogoId){
        return this.jogoRepository.findById(JogoId).orElse(null);

    }
}
