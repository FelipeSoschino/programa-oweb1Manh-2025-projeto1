package com.senac.games.service;

import com.senac.games.entity.Premio;
import com.senac.games.repository.PremioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioService {

    private PremioRepository premioRepository;

    public PremioService(PremioRepository premioRepository){
        this.premioRepository = premioRepository;
    }

    public List<Premio> listarPremio(){
        return this.premioRepository.findAll();
    }

    public Premio listarPremioPorId(Integer premioId){
        return this.premioRepository.findById(premioId).orElse(null);
    }
}
