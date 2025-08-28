package com.senac.games.controller;

import com.senac.games.entity.Premio;
import com.senac.games.service.PremioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/premio")
@Tag(name="Premio", description = "API para gerenciamento de premios")
public class PremioController {

    private PremioService premioService;

    public PremioController(PremioService premioService){
        this.premioService = premioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Premios", description = "Endpoint para listar todos os premios ")
    public ResponseEntity<List<Premio>> listarPremio(){
        return ResponseEntity.ok(premioService.listarPremio());
    }

    @GetMapping("/listarPorPremioId/{premioId}")
    @Operation(summary = "Listar Premio por Id", description = "Endpoint para listar um premio dado seu Id ")
    public ResponseEntity<Premio> listarPremioId(@PathVariable("premioId")Integer premioId){
        Premio premio = premioService.listarPremioPorId(premioId);
        if (premio ==null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(premio);
    }

}
