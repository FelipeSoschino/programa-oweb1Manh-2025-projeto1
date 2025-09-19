package com.senac.games.controller;

import com.senac.games.dto.request.InscricaoDTORequest;
import com.senac.games.dto.request.JogoDTORequest;
import com.senac.games.dto.response.InscricaoDTOResponse;
import com.senac.games.dto.response.JogoDTOResponse;
import com.senac.games.entity.Inscricao;
import com.senac.games.entity.Jogo;
import com.senac.games.service.InscricaoService;
import com.senac.games.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inscricao")
@Tag(name = "Inscrição", description = "API para gerenciamento de Inscrições")
public class InscricaoController {

    private InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService){
        this.inscricaoService = inscricaoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar inscricaos", description = "Endpoint para todos os inscricaos ")
    public ResponseEntity<List<Inscricao>> listarInscricaos(){
        return ResponseEntity.ok(inscricaoService.listarInscricoes());

    }

    @GetMapping("/listar/{inscricaoId}")
    @Operation(summary = "Listar inscricao por ID",description = "Endpoint para listar um inscricao dado seu ID")
    public ResponseEntity<Inscricao> listarJodoPorId(@PathVariable("inscricaoId")Integer inscricaoId){
        Inscricao inscricao = inscricaoService.listarInscricaoPorId(inscricaoId);
        if (inscricao == null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(inscricao);
    }

    @PostMapping("criar")
    @Operation(summary = "Criar Inscricao",description = "Endpoint para criação de um inscricao no banco")
    public ResponseEntity<InscricaoDTOResponse> criarInscricao(@RequestBody InscricaoDTORequest inscricaoDTORequest){
        return ResponseEntity.ok(inscricaoService.criarInscricao(inscricaoDTORequest));
    }
}

    

