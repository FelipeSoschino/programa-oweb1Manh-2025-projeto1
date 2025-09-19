package com.senac.games.controller;

import com.senac.games.dto.request.JogoDTORequest;
import com.senac.games.dto.response.JogoDTOResponse;
import com.senac.games.entity.Jogo;
import com.senac.games.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jogo")
@Tag(name="Jogo", description = "API para gerenciamento de jogos")
public class JogoController {

    private JogoService jogoService;

    public JogoController(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar jogos", description = "Endpoint para todos os jogos ")
    public ResponseEntity<List<Jogo>> listarJogos(){
        return ResponseEntity.ok(jogoService.listarJogos());

    }

    @GetMapping("/listar/{jogoId}")
    @Operation(summary = "Listar jogo por ID",description = "Endpoint para listar um jogo dado seu ID")
    public ResponseEntity<Jogo> listarJodoPorId(@PathVariable("jogoId")Integer jogoId){
        Jogo jogo = jogoService.listarJogoPorId(jogoId);
        if (jogo == null){
            return ResponseEntity.noContent().build();
        }
        else
            return ResponseEntity.ok(jogo);
    }

    @PostMapping("criar")
    @Operation(summary = "Criar Jogo",description = "Endpoint para criação de um jogo no banco")
    public ResponseEntity<JogoDTOResponse> criarJogo(@RequestBody JogoDTORequest jogoDTORequest){
        return ResponseEntity.ok(jogoService.criarJogo(jogoDTORequest));
    }
}
