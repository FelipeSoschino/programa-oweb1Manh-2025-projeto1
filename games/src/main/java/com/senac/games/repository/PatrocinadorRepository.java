package com.senac.games.repository;


import com.senac.games.entity.Patrocinador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Patrocinador p SET p.status = -1 where p.id = :id")
    void apagarPatrocinador(Integer patrocinadorId);

    @Query("SELECT p FROM Patrocinador p where p.status >= 0")
    List<Patrocinador> listarPartrocinadores();
    @Query("SELECT p FROM Patrocinador p where p.status >= 0 AND p.id = :id")
    Patrocinador listarPatrocinadorPorId(@Param("id") Integer patrocinadorId);
}
