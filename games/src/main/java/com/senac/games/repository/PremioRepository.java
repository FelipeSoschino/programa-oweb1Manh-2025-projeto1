package com.senac.games.repository;

import com.senac.games.entity.Jogo;
import com.senac.games.entity.Premio;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremioRepository extends JpaRepository<Premio, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Premio p SET p.status = -1 where p.id = :id")
    void apagarPremio(Integer premioId);

    @Query("SELECT P FROM Premio p where p.status >= 0")
    List<Premio> listarPremios();
    @Query("SELECT P FROM Premio p where p.status >= 0 AND p.id = :id")
    Premio listarPremioPorId(@Param("id") Integer premioId);
}
