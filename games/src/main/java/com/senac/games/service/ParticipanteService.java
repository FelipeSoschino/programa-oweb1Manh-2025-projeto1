package com.senac.games.service;

import com.senac.games.dto.request.ParticipanteDTORequest;
import com.senac.games.dto.response.ParticipanteDTOResponse;
import com.senac.games.entity.Participante;
import com.senac.games.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository){
        this.participanteRepository = participanteRepository;
    }


    public List<Participante> listarParticipante(){
        return this.participanteRepository.findAll();
    }

    public Participante listarParticipantePorId(Integer participanteId){
        return this.participanteRepository.findById(participanteId).orElse(null);
    }


    public ParticipanteDTOResponse criarParticipante(ParticipanteDTORequest participanteDTO) {
        Participante participante = new Participante();
        participante.setNome(participanteDTO.getNome());
        participante.setEmail(participanteDTO.getEmail());
        participante.setEndereco(participanteDTO.getEndereco());
        participante.setIdentificacao(participanteDTO.getIdentificacao());
        participante.setStatus(participanteDTO.getStatus());

        Participante participanteSave = this.participanteRepository.save(participante);

        ParticipanteDTOResponse participanteDTOResponse = new ParticipanteDTOResponse();

        participanteDTOResponse.setId(participanteSave.getId());
        participanteDTOResponse.setNome(participanteSave.getNome());
        participanteDTOResponse.setEmail(participanteSave.getEmail());
        participanteDTOResponse.setEndereco(participanteSave.getEndereco());
        participanteDTOResponse.setIdentificacao(participanteSave.getIdentificacao());
        participanteDTOResponse.setStatus(participanteSave.getStatus());

        return participanteDTOResponse;

    }
}
