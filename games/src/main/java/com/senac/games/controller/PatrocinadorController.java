package com.senac.games.controller;

import com.senac.games.entity.Participante;
import com.senac.games.entity.Patrocinador;
import com.senac.games.service.PatrocinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
