package com.senac.games.service;

import com.senac.games.dto.request.InscricaoDTORequest;
import com.senac.games.dto.response.InscricaoDTOResponse;
import com.senac.games.entity.Inscricao;
import com.senac.games.entity.Usuario;
import com.senac.games.repository.InscricaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class InscricaoServer {

    private InscricaoRepository inscricaoRepository;

    @Autowired
    private ModelMapper modelMapper;
    private InscricaoServer(InscricaoRepository inscricaoRepository){
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Inscricao listarInscricaoPorId(Integer InscricaoId){
        return this.inscricaoRepository.findById(InscricaoId).orElse(null);

    }

    public InscricaoDTOResponse criarInscricao(InscricaoDTORequest inscricaoDTORequest){
        Inscricao inscricao = modelMapper.map(inscricaoDTORequest,Inscricao.class);

        Inscricao inscricaoSave = this.inscricaoRepository.save(inscricao);

        InscricaoDTOResponse inscricaoDTOResponse = modelMapper.map(inscricaoSave, InscricaoDTOResponse.class);

        return inscricaoDTOResponse;
    }



}
