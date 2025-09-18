package com.senac.games.repository;

import com.senac.games.entity.Jogo;
import com.senac.games.entity.Patrocinador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Jogo p SET p.status = -1 where p.id = :id")
    void apagarJogo(Integer jogoId);

    @Query("SELECT p FROM Jogo p where p.status >= 0")
    List<Jogo> listarJogos();
    @Query("SELECT p FROM Jogo p where p.status >= 0 AND p.id = :id")
    Jogo listarJogoPorId(@Param("id") Integer jogoId);
}
