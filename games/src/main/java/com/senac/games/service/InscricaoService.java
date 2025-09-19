package com.senac.games.service;

import com.senac.games.dto.request.InscricaoDTORequest;
import com.senac.games.dto.request.InscricaoDTOUpdateRequest;
import com.senac.games.dto.response.InscricaoDTOResponse;
import com.senac.games.dto.response.InscricaoDTOUpdateResponse;
import com.senac.games.entity.Inscricao;
import com.senac.games.repository.InscricaoRepository;
import com.senac.games.repository.ParticipanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    private InscricaoRepository inscricaoRepository;

    private ParticipanteRepository participanteRepository;

    @Autowired
    private ModelMapper modelMapper;
    private InscricaoService(InscricaoRepository inscricaoRepository, ParticipanteRepository participanteRepository){
        this.inscricaoRepository = inscricaoRepository;
        this.participanteRepository = participanteRepository;
    }

    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.listarInscrioes();
    }

    public Inscricao listarInscricaoPorId(Integer inscricaoId){
        return this.inscricaoRepository.listarInscricaoPorId(inscricaoId);

    }

    public InscricaoDTOResponse criarInscricao(InscricaoDTORequest inscricaoDTORequest){
        Inscricao inscricao = new Inscricao();
        inscricao.setData(inscricaoDTORequest.getData());
        inscricao.setStatus(inscricaoDTORequest.getStatus());
        inscricao.setParticipante(participanteRepository.listarParticipantePorId(inscricaoDTORequest.getIdParticipante()));

        Inscricao inscricaoSave = this.inscricaoRepository.save(inscricao);

        InscricaoDTOResponse inscricaoDTOResponse = modelMapper.map(inscricaoSave, InscricaoDTOResponse.class);

        return inscricaoDTOResponse;
    }

    public InscricaoDTOResponse atualizarInscricao(Integer inscricaoId, InscricaoDTORequest inscricaoDTORequest){
        Inscricao inscricao = this.listarInscricaoPorId(inscricaoId);
        if(inscricao!=null){
            modelMapper.map(inscricaoDTORequest,inscricao);
            Inscricao inscricaoSave = this.inscricaoRepository.save(inscricao);

            InscricaoDTOResponse inscricaoDTOResponse = modelMapper.map(inscricaoSave, InscricaoDTOResponse.class);
            return inscricaoDTOResponse;}
        else
            return null;
    }

    public InscricaoDTOUpdateResponse atualizarStatusInscricao(Integer inscricaoId, InscricaoDTOUpdateRequest inscricaoDTOUpdateRequest){
        Inscricao inscricao = this.listarInscricaoPorId(inscricaoId);
        if(inscricao!=null){
            modelMapper.map(inscricaoDTOUpdateRequest,inscricao);
            Inscricao inscricaoSave = this.inscricaoRepository.save(inscricao);

            InscricaoDTOUpdateResponse inscricaoDTOUpdateResponse = modelMapper.map(inscricaoSave, InscricaoDTOUpdateResponse.class);
            return inscricaoDTOUpdateResponse;}
        else
            return null;
    }

    public void apagarInscricao(Integer inscricaoId){
        this.inscricaoRepository.apagarInscricao(inscricaoId);

    }
}
