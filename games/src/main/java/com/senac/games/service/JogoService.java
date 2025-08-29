package com.senac.games.service;

import com.senac.games.dto.request.JogoDTORequest;
import com.senac.games.dto.response.JogoDTOResponse;
import com.senac.games.entity.Jogo;
import com.senac.games.entity.Usuario;
import com.senac.games.repository.JogoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private JogoRepository jogoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public JogoService(JogoRepository jogoRepository){
        this.jogoRepository = jogoRepository;
    }

    public List<Jogo> listarJogos(){
        return jogoRepository.findAll();
    }

    public Jogo listarJogoPorId(Integer JogoId){
        return this.jogoRepository.findById(JogoId).orElse(null);

    }

    public JogoDTOResponse criarJogo(JogoDTORequest jogoDTORequest){
        Jogo jogo = modelMapper.map(jogoDTORequest, Jogo.class);

        Jogo jogoSave = this.jogoRepository.save(jogo);

        JogoDTOResponse jogoDTOResponse = modelMapper.map(jogoSave, JogoDTOResponse.class);
        return jogoDTOResponse;

    }
}
