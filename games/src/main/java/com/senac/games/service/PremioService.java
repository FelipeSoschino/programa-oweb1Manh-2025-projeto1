package com.senac.games.service;

import com.senac.games.dto.request.JogoDTORequest;
import com.senac.games.dto.request.JogoDTOUpdateRequest;
import com.senac.games.dto.request.PremioDTORequest;
import com.senac.games.dto.request.PremioDTOUpdateRequest;
import com.senac.games.dto.response.JogoDTOResponse;
import com.senac.games.dto.response.JogoDTOUpdateResponse;
import com.senac.games.dto.response.PremioDTOResponse;
import com.senac.games.dto.response.PremioDTOUpdateResponse;
import com.senac.games.entity.Jogo;
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

    public PremioService(PremioRepository premioRepository) {
        this.premioRepository = premioRepository;
    }

    public List<Premio> listarPremio() {
        return this.premioRepository.findAll();
    }

    public Premio listarPremioPorId(Integer premioId) {
        return this.premioRepository.findById(premioId).orElse(null);
    }

    public PremioDTOResponse criarPremio(PremioDTORequest premioDTORequest) {
        Premio premio = modelMapper.map(premioDTORequest, Premio.class);

        Premio premioSave = this.premioRepository.save(premio);

        PremioDTOResponse premioDTOResponse = modelMapper.map(premioSave, PremioDTOResponse.class);
        return premioDTOResponse;
    }

    public PremioDTOResponse atualizarPremio(Integer premioId, PremioDTORequest premioDTORequest) {
        Premio premio = this.listarPremioPorId(premioId);
        if (premio != null) {
            modelMapper.map(premioDTORequest, premio);
            Premio premioSave = this.premioRepository.save(premio);

            PremioDTOResponse premioDTOResponse = modelMapper.map(premioSave, PremioDTOResponse.class);
            return premioDTOResponse;
        } else
            return null;
    }

    public PremioDTOUpdateResponse atualizarStatusPremio(Integer premioId, PremioDTOUpdateRequest premioDTOUpdateRequest) {
        Premio premio = this.listarPremioPorId(premioId);
        if (premio != null) {
            modelMapper.map(premioDTOUpdateRequest, premio);
            Premio premioSave = this.premioRepository.save(premio);

            PremioDTOUpdateResponse premioDTOUpdateResponse = modelMapper.map(premioSave, PremioDTOUpdateResponse.class);
            return premioDTOUpdateResponse;
        } else
            return null;
    }

    public void apagarPremio(Integer premioId) {
        this.premioRepository.apagarPremio(premioId);
    }
}
