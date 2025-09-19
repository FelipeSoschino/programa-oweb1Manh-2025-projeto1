package com.senac.games.repository;

import com.senac.games.entity.Inscricao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository  extends JpaRepository<Inscricao, Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE Inscricao p SET p.status = -1 where p.id = :id")
    void apagarInscricao(Integer inscricaoId);

    @Query("SELECT p FROM Inscricao p where p.status >= 0")
    List<Inscricao> listarInscrioes();
    @Query("SELECT p FROM Inscricao p where p.status >= 0 AND p.id = :id")
    Inscricao listarInscricaoPorId(@Param("id") Integer id);
}
