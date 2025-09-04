package com.senac.games.controller;

import com.senac.games.dto.request.ParticipanteDTORequest;
import com.senac.games.dto.request.PatrocinadoDTOUpdateRequest;
import com.senac.games.dto.request.PatrocinadorDTORequest;
import com.senac.games.dto.response.PatrocinadorDTOResponse;
import com.senac.games.dto.response.PatrocinadorDTOUpdateResponse;
import com.senac.games.entity.Patrocinador;
import com.senac.games.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patrocinador")
@Tag(name="Partrocinador", description = "API para gerenciamento de partrocinador")
public class PatrocinadorController {


    private PatrocinadorService patrocinadorService;

    public PatrocinadorController(PatrocinadorService patrocinadorService) {
        this.patrocinadorService = patrocinadorService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar patrocinadores", description = "Endpoint para listar todos os patrocinadores ")
    public ResponseEntity<List<Patrocinador>> listarPatrocinadores(){

        return ResponseEntity.ok(patrocinadorService.listarPatrocinadores());

    }

    @GetMapping("/listarPorPatrocinadorId/{patrocinadorId}")
    @Operation(summary = "Listar patrocinador por ID", description = "Endpoint para listar um patrocinador pelo seu id")
    public ResponseEntity<Patrocinador> listarParticipantePorId(@PathVariable("patrocinadorId") Integer patrocinadorId){
        Patrocinador patrocinador = patrocinadorService.listarPatrocinadorPorId(patrocinadorId);
        if(patrocinador == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(patrocinador);}

    @PostMapping("/criar")
    @Operation(summary = "Criar Patrocinador", description = "End point para criação de um novo Patrocinador")
    public ResponseEntity<PatrocinadorDTOResponse> criarPatroinador(@Valid@RequestBody PatrocinadorDTORequest patrocinadorDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patrocinadorService.criarPatrocinador(patrocinadorDTORequest));
    }

    @PutMapping("/atualizar/{patrocinadorId}")
    @Operation(summary = "Atualizar Patrocinador",description = "Endpont para atualizar os dados de um Patrocinador")
    public ResponseEntity<PatrocinadorDTOResponse> atualizarPatrocinador(@PathVariable("patrocinadorId")Integer patrocinadorId,
                                                                         @RequestBody PatrocinadorDTORequest patrocinadorDTORequest){
        return ResponseEntity.ok(this.patrocinadorService.atualizarPatrocinador(patrocinadorId,patrocinadorDTORequest));
    }

    @PatchMapping("atualizarStatus/{patrocinadorId}")
    @Operation(summary = "Atualizar Status do Patrocinador",description = "Endpont para atualizar o status de um Patrocinador")
    public ResponseEntity<PatrocinadorDTOUpdateResponse> atualizarStatusPatrocinador(@PathVariable("patrocinadorId")Integer patrocinadorId,
                                                                               @RequestBody PatrocinadoDTOUpdateRequest patrocinadorDTOUpdateRequest){
        return ResponseEntity.ok(this.patrocinadorService.atualizarStatusPatrocinador(patrocinadorId,patrocinadorDTOUpdateRequest));
    }

    @DeleteMapping("Deletar/{patrocinadorId}")
    @Operation(summary = "Remover patrocinador", description = "Endpoint para remover um patrocinador dado seu ID")
    public void apagarPatrocinador(@PathVariable("patrocinadorId") Integer patrocinadorId){
        this.patrocinadorService.apagarPatrocinador(patrocinadorId);
    }


}
