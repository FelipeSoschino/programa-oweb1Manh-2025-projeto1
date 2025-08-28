package com.senac.games.controller;

import com.senac.games.entity.Usuario;
import com.senac.games.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@Tag(name="Usuario", description = "API para gerenciamento dos usuários")
public class UsuarioController {

    private UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Usuários", description = "End point para listar todos os usuários")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(this.usuarioService.listarUsuarios());
    }

    @GetMapping("/listarPorUsuarioId/{usuarioId}")
    @Operation(summary = "Listar Usuários pelo Id", description = "End point para listar um usuário dado seu Id")
    public ResponseEntity<Usuario> listarUsuarioId(@PathVariable("usuarioId")Integer usuarioId){
        Usuario usuario = usuarioService.listarUsuarioPorId(usuarioId);
        if (usuario == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(usuario);
    }




}
