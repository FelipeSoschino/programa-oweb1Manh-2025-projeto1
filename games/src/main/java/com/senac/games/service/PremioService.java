package com.senac.games.service;

import com.senac.games.dto.request.PremioDTORequest;
import com.senac.games.dto.response.PremioDTOResponse;
import com.senac.games.entity.Premio;
import com.senac.games.repository.PremioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioService {

    private PremioRepository premioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PremioService(PremioRepository premioRepository){
        this.premioRepository = premioRepository;
    }

    public List<Premio> listarPremio(){
        return this.premioRepository.findAll();
    }

    public Premio listarPremioPorId(Integer premioId){
        return this.premioRepository.findById(premioId).orElse(null);
    }

    public PremioDTOResponse criarPremio(PremioDTORequest premioDTORequest){
        Premio premio = modelMapper.map(premioDTORequest, Premio.class);

        Premio premioSave = this.premioRepository.save(premio);

        PremioDTOResponse premioDTOResponse = modelMapper.map(premioSave, PremioDTOResponse.class);
        return premioDTOResponse;
    }
}
