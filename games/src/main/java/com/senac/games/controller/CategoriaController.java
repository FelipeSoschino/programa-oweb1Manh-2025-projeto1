package com.senac.games.controller;

import com.senac.games.dto.request.CategoriaDTORequest;
import com.senac.games.dto.response.CategoriaDTOResponse;
import com.senac.games.entity.Categoria;
import com.senac.games.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@Tag(name="Categoria", description = "API para gerenciamento de categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar categorias", description = "Endpoint para listar todas as categorias")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/listar/{idCategoria}")
    @Operation(summary ="" ,description = "")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable("idCategoria")Integer idCategoria){
        Categoria categoria = categoriaService.listarCategoriaPorId(idCategoria);
        if (categoria ==null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(categoria);
    }

    @PostMapping("/criar")
    @Operation(summary = "",description = "")
    public ResponseEntity<CategoriaDTOResponse> criarCategoria(@Valid @RequestBody CategoriaDTORequest categoriaDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaService.criarCategoria(categoriaDTORequest));
    }


}
