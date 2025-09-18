package com.senac.games.repository;

import com.senac.games.entity.Categoria;
import com.senac.games.entity.Patrocinador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Categoria p SET p.status = -1 where p.id = :id")
    void apagarCategoria(Integer categoriaId);

    @Query("SELECT p FROM Categoria p where p.status >= 0")
    List<Categoria> listarCategorias();
    @Query("SELECT p FROM Categoria p where p.status >= 0 AND p.id = :id")
    Categoria listarCategoriaPorId(@Param("id") Integer categoriaId);
}
