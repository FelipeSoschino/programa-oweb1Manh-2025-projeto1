package com.senac.games.service;

import com.senac.games.dto.request.ParticipanteDTORequest;
import com.senac.games.dto.response.ParticipanteDTOResponse;
import com.senac.games.entity.Participante;
import com.senac.games.repository.ParticipanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ParticipanteService(ParticipanteRepository participanteRepository){
        this.participanteRepository = participanteRepository;
    }


    public List<Participante> listarParticipante(){
        return this.participanteRepository.findAll();
    }

    public Participante listarParticipantePorId(Integer participanteId){
        return this.participanteRepository.findById(participanteId).orElse(null);
    }


    public ParticipanteDTOResponse criarParticipante(ParticipanteDTORequest participanteDTORequest) {

        Participante participante = modelMapper.map(participanteDTORequest, Participante.class);

        Participante participanteSave = this.participanteRepository.save(participante);
        ParticipanteDTOResponse participanteDTOResponse = modelMapper.map(participanteSave, ParticipanteDTOResponse.class);
        return participanteDTOResponse;}


//        /*
//        Participante participante = new Participante();
//        participante.setNome(participanteDTO.getNome());
//        participante.setEmail(participanteDTO.getEmail());
//        participante.setEndereco(participanteDTO.getEndereco());
//        participante.setIdentificacao(participanteDTO.getIdentificacao());
//        participante.setStatus(participanteDTO.getStatus());
//*/
//        Participante participanteSave = this.participanteRepository.save(participante);
//
//        ParticipanteDTOResponse participanteDTOResponse = new ParticipanteDTOResponse();
//
//        participanteDTOResponse.setId(participanteSave.getId());
//        participanteDTOResponse.setNome(participanteSave.getNome());
//        participanteDTOResponse.setEmail(participanteSave.getEmail());
//        participanteDTOResponse.setEndereco(participanteSave.getEndereco());
//        participanteDTOResponse.setIdentificacao(participanteSave.getIdentificacao());
//        participanteDTOResponse.setStatus(participanteSave.getStatus());

//        return participanteDTOResponse;

//    }
}
