package com.senac.games.service;

import com.senac.games.dto.request.ParticipanteDTORequest;
import com.senac.games.dto.request.ParticipanteDTOUpdateRequest;
import com.senac.games.dto.response.ParticipanteDTOResponse;
import com.senac.games.dto.response.ParticipanteDTOUpdateResponse;
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

    public ParticipanteDTOResponse atualizarParticipante(Integer participanteId, ParticipanteDTORequest participanteDTORequest) {
        Participante participante = this.listarParticipantePorId(participanteId);
        if (participante != null){
            modelMapper.map(participanteDTORequest, participante);


            Participante tempoResponse = participanteRepository.save(participante);
            return modelMapper.map(tempoResponse,ParticipanteDTOResponse.class);


        }
        else
            return null;
    }

    public ParticipanteDTOUpdateResponse atualizarStatusParticipante(Integer participanteId, ParticipanteDTOUpdateRequest participanteDTOUpdateRequest) {
        Participante participante = this.listarParticipantePorId(participanteId);
        if(participante != null){
            modelMapper.map(participanteDTOUpdateRequest,participante);

            Participante participanteUpdate = participanteRepository.save(participante);
            return modelMapper.map(participanteUpdate, ParticipanteDTOUpdateResponse.class);
        }
        else
            return null;
    }
}

















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

