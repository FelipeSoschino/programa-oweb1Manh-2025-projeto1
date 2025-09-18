package com.senac.games.service;

import com.senac.games.dto.request.JogoDTORequest;
import com.senac.games.dto.request.JogoDTOUpdateRequest;
import com.senac.games.dto.response.JogoDTOResponse;
import com.senac.games.dto.response.JogoDTOUpdateResponse;
import com.senac.games.entity.Jogo;
import com.senac.games.entity.Usuario;
import com.senac.games.repository.CategoriaRepository;
import com.senac.games.repository.JogoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private JogoRepository jogoRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public JogoService(JogoRepository jogoRepository,CategoriaRepository categoriaRepository){
        this.jogoRepository = jogoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Jogo> listarJogos(){
        return jogoRepository.listarJogos();
    }

    public Jogo listarJogoPorId(Integer jogoId){
        return this.jogoRepository.listarJogoPorId(jogoId);

    }

    public JogoDTOResponse criarJogo(JogoDTORequest jogoDTORequest){
        Jogo jogo = new Jogo();
        jogo.setNome(jogoDTORequest.getNome());
        jogo.setStatus(jogoDTORequest.getStatus());
        jogo.setCategoria(categoriaRepository.listarCategoriaPorId(jogoDTORequest.getCategoria()));

        Jogo jogoSave = this.jogoRepository.save(jogo);

        JogoDTOResponse jogoDTOResponse = modelMapper.map(jogoSave, JogoDTOResponse.class);
        return jogoDTOResponse;

    }

    public JogoDTOResponse atualizarJogo(Integer jogoId, JogoDTORequest jogoDTORequest){
        Jogo jogo = this.listarJogoPorId(jogoId);
        if(jogo!=null){
            modelMapper.map(jogoDTORequest,jogo);
            Jogo jogoSave = this.jogoRepository.save(jogo);

            JogoDTOResponse jogoDTOResponse = modelMapper.map(jogoSave, JogoDTOResponse.class);
            return jogoDTOResponse;}
        else
            return null;
    }

    public JogoDTOUpdateResponse atualizarStatusJogo(Integer jogoId, JogoDTOUpdateRequest jogoDTOUpdateRequest){
        Jogo jogo = this.listarJogoPorId(jogoId);
        if(jogo!=null){
            modelMapper.map(jogoDTOUpdateRequest,jogo);
            Jogo jogoSave = this.jogoRepository.save(jogo);

            JogoDTOUpdateResponse jogoDTOUpdateResponse = modelMapper.map(jogoSave, JogoDTOUpdateResponse.class);
            return jogoDTOUpdateResponse;}
        else
            return null;
    }

    public void apagarJogo(Integer jogoId){
        this.jogoRepository.apagarJogo(jogoId);
    }


}
